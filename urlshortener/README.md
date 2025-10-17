**Scalable 7-Character URL Shortener**

NanoLink is a high-throughput, minimalist URL shortening service implemented in Java (typically using Spring Boot). It generates highly compact, 7-character short links using Base62 encoding.

To achieve superior performance and scalability, NanoLink utilizes a two-tier architecture:

1. Shortener Service: Uses an in-memory key-value store for near-instantaneous redirection lookups.

2. Token Manager: A separate service responsible for pre-allocating large, unique ranges of IDs to the Shortener instances, ensuring thread safety and reduced contention across multiple running application instances.

**Features**

1. 7-Character Short Links: Generates compact, easy-to-share tokens (e.g., nan.lk/aBcDeFg).

2. Massive Capacity: Over 3.5 trillion unique URLs (62^7) possible with the 7-character limit.

3. High Performance: Link lookups are lightning-fast using a Java ConcurrentHashMap (in-memory store).

4. Distributed ID Management: Uses a dedicated Token Manager to hand out batches of IDs, enabling horizontal scaling of the Shortener Service without ID conflicts.

5. Base62 Encoding: Custom logic converts sequential Long IDs into the compressed alphanumeric Base62 format.

**Scalability Strategy: The Token Manager**

1. The core challenge in scaling a shortener is ensuring two separate servers don't generate the same ID. NanoLink solves this using a Token Manager:

2. Central Counter: The Token Manager holds a single, persistent counter (next_available_id).

3. Range Request: When a NanoLink Shortener instance starts up or runs out of tokens, it makes a single, synchronized call to the Token Manager asking for a new batch (e.g., a batch of 10,000 IDs).

4. Batch Allocation: The Token Manager atomically updates its counter and returns a range: [ID_Start, ID_Start + 9999].

5. Local Consumption: The Shortener instance then uses this batch of 10,000 IDs locally, converting them to Base62 tokens. It does not need to talk to the Token Manager again until this local pool is exhausted.

This dramatically reduces network calls and database contention, allowing many Shortener instances to operate simultaneously at high speed.

**Base62 Mechanism**

All URLs are mapped to a sequential long integer ID. This ID is converted to its 7-character Base62 token.

The Base62 alphabet is defined as:

0-9 (10 chars), A-Z (26 chars), a-z (26 chars)

The shortest 7-character token is 1000000, corresponding to the decimal value 62^6=56,800,235,584. Application only begins generating 7-character tokens once the sequential ID reaches this floor.
