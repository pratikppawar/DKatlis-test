package app.models;

import java.util.HashMap;

public class TicketManagerImpl implements TicketManager {
	
	private Integer[] parkingSlotsList;
	private HashMap<String, ParkingTicket> parkedCars;
	
	public TicketManagerImpl() {
		super();
		parkedCars = new HashMap<String, ParkingTicket>();
	}
	
	public HashMap<String, ParkingTicket> getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(HashMap<String, ParkingTicket> parkedCars) {
		this.parkedCars = parkedCars;
	}

	public Integer[] getParkingSlotsList() {
		return parkingSlotsList;
	}

	public void setParkingSlotsList(Integer[] parkingSlotsList) {
		this.parkingSlotsList = parkingSlotsList;
	}

	public void processInput(Input ip) {
		
	}

	public void createParkingLotAction(Input ip) {

	}

	public void parkAction(Input ip) {

	}

	public void leaveAction(Input ip) {

	}

	public void statusAction(Input ip) {

	}
}
