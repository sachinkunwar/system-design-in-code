package com.example.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.parkinglot.controller.BillController;
import com.example.parkinglot.controller.GateController;
import com.example.parkinglot.controller.ParkingAttendantController;
import com.example.parkinglot.controller.ParkingFloorController;
import com.example.parkinglot.controller.ParkingLotController;
import com.example.parkinglot.controller.ParkingSpotController;
import com.example.parkinglot.controller.PaymentController;
import com.example.parkinglot.controller.TicketController;
import com.example.parkinglot.controller.TransactionController;
import com.example.parkinglot.controller.VehicleController;
import com.example.parkinglot.model.Bill;
import com.example.parkinglot.model.Gate;
import com.example.parkinglot.model.ParkingAttendant;
import com.example.parkinglot.model.ParkingFloor;
import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.PaymentReciept;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.model.constant.GateType;
import com.example.parkinglot.model.constant.ParkingSpotStatus;
import com.example.parkinglot.model.constant.VehicleType;
import com.example.parkinglot.repository.BillRepository;
import com.example.parkinglot.repository.GateRepository;
import com.example.parkinglot.repository.ParkingAttendantRepository;
import com.example.parkinglot.repository.ParkingFloorRepository;
import com.example.parkinglot.repository.ParkingLotRepository;
import com.example.parkinglot.repository.ParkingSpotRepository;
import com.example.parkinglot.repository.PaymentRecieptRepository;
import com.example.parkinglot.repository.TicketRepository;
import com.example.parkinglot.repository.TransactionRepository;
import com.example.parkinglot.repository.VehicleRepository;
import com.example.parkinglot.service.BillService;
import com.example.parkinglot.service.GateService;
import com.example.parkinglot.service.ParkingAttendantService;
import com.example.parkinglot.service.ParkingFloorService;
import com.example.parkinglot.service.ParkingLotService;
import com.example.parkinglot.service.ParkingSpotService;
import com.example.parkinglot.service.PaymentService;
import com.example.parkinglot.service.TicketService;
import com.example.parkinglot.service.TransactionService;
import com.example.parkinglot.service.VehicleService;

@SpringBootApplication
public class ParkinglotApplication {

	static BillRepository billRepository;
	static GateRepository gateRepository;
	static ParkingAttendantRepository parkingAttendantRepository;
	static ParkingFloorRepository parkingFloorRepository;
	static ParkingLotRepository parkingLotRepository;
	static PaymentRecieptRepository paymentRecieptRepository;
	static TicketRepository ticketRepository;
	static TransactionRepository transactionRepository;
	static VehicleRepository vehicleRepository;
	static ParkingSpotRepository parkingSpotRepository;
	
	static BillService billService;
	static GateService gateService;
	static ParkingAttendantService parkingAttendantService;
	static ParkingFloorService parkingFloorService;
	static TicketService ticketService;
	static TransactionService transactionService;
	static PaymentService paymentService;
	static ParkingLotService parkingLotService;
	static VehicleService vehicleService;
	static ParkingSpotService parkingSpotService;
	
	static ParkingLotController parkingLotController;
	static BillController billController;
	static GateController gateController;
	static ParkingAttendantController parkingAttendantController;
	static ParkingFloorController parkingFloorController;
	static PaymentController paymentController;
	static TicketController ticketController;
	static TransactionController transactionController;
	static VehicleController vehicleController;
	static ParkingSpotController parkingSpotController;

	public static void main(String[] args) {
//		SpringApplication.run(ParkinglotApplication.class, args);
		
		ParkingLot parkingLot = initParkingLot();
		try (Scanner sc = new Scanner(System.in)) {
			while(true) {
				System.out.println("1. Entry Gate\n"
						+ "2. Exit Gate\n"
						+"Enter Gate No:");
				int gateNo = sc.nextInt();
				switch(gateNo) {
				case 1:
					entryGate(parkingLot, sc); 
					break;
				case 2:
					exitGate(parkingLot, sc, 2);
					break;
				default:
					System.out.println("Please enter a valid gate number!");
				}
			}
		}
	}
	
	private static void exitGate(ParkingLot parkingLot, Scanner sc, int gateNo) {
		Gate gate = gateController.fetchGate(gateNo);
		System.out.println("Enter Vehicle Number for Billing:");
		String vehicleNumber = sc.next();
		Vehicle vehcile = vehicleController.fetchVehicle(vehicleNumber);
		Ticket ticket = ticketController.fetchTicket(vehcile);
		Bill bill = billController.generateBill(ticket, gate);
		System.out.println(bill);
		PaymentReciept paymentReciept = paymentController.pay(bill);
		System.out.println(paymentReciept);
		parkingSpotController.releaseParkingSpot(ticket.getParkingSpot());
	}
	
	private static void entryGate(ParkingLot parkingLot, Scanner sc) {
		parkingLotController.showParkingSpots(parkingLot);
		System.out.println("Enter Vehicle Number :");
		String vehicleNumber = sc.next();
		System.out.println("1. FOUR Wheeler\n"
				+ "2. Two Wheeler\n"
				+ "Enter Vehicle Type :");
		int vehicleType = sc.nextInt();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleType(vehicleType == 1 ? VehicleType.FOUR_WHEELER : VehicleType.TWO_WHEELER);
		vehicleController.create(vehicle);
		Ticket ticket = parkingLotController.park(parkingLot, vehicle);
		if(ticket != null) {
			System.out.println(ticket);
		}else {
			System.out.println("Sorry, Parking Spots are not available for the vehicle type :" + vehicle.getVehicleType());
		}
	}

	private static ParkingLot initParkingLot() {
		System.out.println("=================Initilizing ParkingLot===================");
		billRepository = new BillRepository();
		gateRepository = new GateRepository();
		parkingAttendantRepository = new ParkingAttendantRepository();
		parkingFloorRepository = new ParkingFloorRepository();
		parkingLotRepository = new ParkingLotRepository();
		paymentRecieptRepository = new PaymentRecieptRepository();
		ticketRepository = new TicketRepository();
		transactionRepository = new TransactionRepository();
		vehicleRepository = new VehicleRepository();
		parkingSpotRepository = new ParkingSpotRepository();
		
		billService = new BillService(billRepository);
		gateService = new GateService(gateRepository);
		parkingAttendantService = new ParkingAttendantService(parkingAttendantRepository);
		parkingFloorService = new ParkingFloorService(parkingFloorRepository);
		ticketService = new TicketService(ticketRepository);
		transactionService = new TransactionService(transactionRepository);
		paymentService = new PaymentService(paymentRecieptRepository, transactionService);
		parkingLotService = new ParkingLotService(parkingLotRepository, ticketService);
		vehicleService = new VehicleService(vehicleRepository);
		parkingSpotService = new ParkingSpotService(parkingSpotRepository);
		
		parkingLotController = new ParkingLotController(parkingLotService);
		billController = new BillController(billService);
		gateController = new GateController(gateService);
		parkingAttendantController = new ParkingAttendantController(parkingAttendantService);
		parkingFloorController = new ParkingFloorController(parkingFloorService);
		paymentController = new PaymentController(paymentService);
		ticketController = new TicketController(ticketService);
		transactionController = new TransactionController(transactionService);
		vehicleController = new VehicleController(vehicleService);
		parkingSpotController = new ParkingSpotController(parkingSpotService);

		int totalFloors = 1;
		int totalSpotsOnEachFloor = 5;
		List<ParkingFloor> floors = new ArrayList<>();
		for(int i = 0; i < totalFloors; i++) {
			ParkingFloor floor = new ParkingFloor();
			List<ParkingSpot> spots = new ArrayList<>();
			for(int j = 0; j < totalSpotsOnEachFloor; j++) {
				ParkingSpot spot = new ParkingSpot();
				spot.setParkingSpotStatus(ParkingSpotStatus.FREE);
				spot.setVehicleType(j%2 == 0 ? VehicleType.FOUR_WHEELER : VehicleType.TWO_WHEELER);
				parkingSpotController.create(spot);
				spots.add(spot);
			}
			floor.setParkingSpots(spots);
			parkingFloorController.create(floor);
			floors.add(floor);
		}
		ParkingAttendant parkingAttendant1 = new ParkingAttendant();
		parkingAttendant1.setName("Rahul");
		parkingAttendant1.setMobileNumber("9876543210");
		parkingAttendantController.create(parkingAttendant1);
		
		ParkingAttendant parkingAttendant2 = new ParkingAttendant();
		parkingAttendant2.setName("Ravi");
		parkingAttendant2.setMobileNumber("9876543211");
		parkingAttendantController.create(parkingAttendant2);
		
		Gate entryGate = new Gate();
		entryGate.setGatetype(GateType.ENTRY);
		entryGate.setParkingAttendant(parkingAttendant1);
		gateController.create(entryGate);
		
		Gate exitGate = new Gate();
		exitGate.setGatetype(GateType.EXIT);
		exitGate.setParkingAttendant(parkingAttendant2);
		gateController.create(exitGate);
		
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setName("XYZ Parking Lot");
		parkingLot.setAddress("44/1 ABC APARTMENT, 5TH MAIN ROAD\n"
				+ "JAYANAGAR\n"
				+ "BANGALORE, KA 560041\n"
				+ "IND");
		parkingLot.setParkingFloors(floors);
		parkingLot.setEntryGate(entryGate);
		parkingLot.setExitGate(exitGate);
		
		parkingLotController.create(parkingLot);
		
		System.out.println("ParkingLot Initialized!!");
		
		return parkingLot;
	}

}
