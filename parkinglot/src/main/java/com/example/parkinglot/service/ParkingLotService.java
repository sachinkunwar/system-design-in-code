package com.example.parkinglot.service;


import com.example.parkinglot.model.ParkingFloor;
import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.Ticket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.model.constant.ParkingSpotStatus;
import com.example.parkinglot.model.constant.VehicleType;
import com.example.parkinglot.repository.ParkingLotRepository;

public class ParkingLotService {
	private ParkingLotRepository parkingLotRepository;
	private TicketService ticketService;
	public ParkingLotService(ParkingLotRepository parkingLotRepository, TicketService ticketService) {
		this.parkingLotRepository = parkingLotRepository;
		this.ticketService = ticketService;
	}

	public ParkingLot create(ParkingLot parkingLot) {
		return parkingLotRepository.save(parkingLot);
	}

	public Ticket park(ParkingLot parkingLot, Vehicle vehicle) {
		//check for available parking spots
		ParkingSpot parkingSpots = findAvailableParkingSpots(parkingLot, vehicle.getVehicleType());
		if(parkingSpots == null) return null;
		
		//assign a parking spot to vehicle
		parkingSpots.setVehicle(vehicle);
		parkingSpots.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
		
		//generate ticket
		return ticketService.generateTicket(parkingLot, parkingSpots);
	}

	private ParkingSpot findAvailableParkingSpots(ParkingLot parkingLot, VehicleType vehicleType) {
		for(int floor = 0; floor < parkingLot.getParkingFloors().size(); floor++) {
			ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floor);
			for(int spot = 0; spot < parkingFloor.getParkingSpots().size(); spot++) {
				ParkingSpot parkingSpot = parkingFloor.getParkingSpots().get(spot);
				if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.FREE) && parkingSpot.getVehicleType().equals(vehicleType)) {
					return parkingSpot;
				}
			}
		}
		return null;
	}

	public void showParkingSpots(ParkingLot parkingLot) {
		for(int floor = 0; floor < parkingLot.getParkingFloors().size(); floor++) {
			ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floor);
			System.out.println("Floor No: "+(floor+1));
			for(int spot = 0; spot < parkingFloor.getParkingSpots().size(); spot++) {
				ParkingSpot parkingSpot = parkingFloor.getParkingSpots().get(spot);
				System.out.print("|"+ (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.FREE)? " ":
					(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.OCCUPIED)?"X":"NA")) +"|");
			}
			System.out.println();
		}	
	}
}
