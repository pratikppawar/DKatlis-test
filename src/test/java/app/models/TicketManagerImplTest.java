package app.models;

import java.util.Date;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TestUtils.TestUtils;

public class TicketManagerImplTest {

	private TicketManagerImpl obj;

	@Before
	public void setup() {
		this.obj = new TicketManagerImpl();
	}

	@Test
	public void processInputTestCreateParkingLotAction() {
		int totalSlots = 10;
		Input ip = new Input(Input.Action.create_parking_lot,
				totalSlots);
		String message = obj.processInput(ip);
		Integer[] slots = obj.getParkingSlotsList();
		Assert.assertNotNull(message);
		Assert.assertTrue(message.equals("Created parking lot with "+totalSlots+" slots"));
		Assert.assertTrue(slots.length == 10);
	}

	@Test
	public void processInputTestParkActionSuccess() {
		String carNumber = "KA-01-HH-1234";
		obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		Input ip = new Input(Input.Action.park, 
				carNumber,
				10);
		String message = obj.processInput(ip);
		HashMap<String, ParkingTicket> parkedCars = obj.getParkedCars();
		ParkingTicket ticket = parkedCars.get(carNumber);
		
		Assert.assertNotNull(message);
		Assert.assertTrue(message.equals("Allocated slot number: "+ticket.getSlotNumber()));
		Integer[] parkingSlots = obj.getParkingSlotsList();
		
		Assert.assertNotNull(ticket);
		Assert.assertTrue(parkingSlots[ticket.getSlotNumber()] == 1);
	}
	
	@Test
	public void processInputTestParkActionFailureSlotsFull() {
		String carNumber = "KA-01-HH-1234";
		obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		TestUtils.markAllSlotsOccupied(obj.getParkingSlotsList());
		Input ip = new Input(Input.Action.park, 
				carNumber,
				10);
		String message = obj.processInput(ip);
		
		Assert.assertNotNull(message);
		Assert.assertTrue(message.equals("Sorry, parking lot is full"));
		
		HashMap<String, ParkingTicket> parkedCars = obj.getParkedCars();
		ParkingTicket ticket = parkedCars.get(carNumber);
		Assert.assertNull(ticket);
	}
	
	@Test
	public void processInputTestLeaveActionFailureWrongCarNumber() {
		String carNumber = "KA-01-HH-4321";
		obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		String message = obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		
		Assert.assertNotNull(message);
		Assert.assertTrue(message.equals("Registration number "+carNumber+" not found"));
		
		ParkingTicket ticket = obj.getParkedCars().get(carNumber);		
		Assert.assertNull(ticket);
	}

	@Test
	public void processInputTestLeaveActionSuccessBaseCharge() {
		obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		
		String carNumber = "KA-01-HH1234";
		int slotNumber = 5;
		Date startTime = new Date();		
		ParkingTicket ticket = new ParkingTicket(new Car(carNumber, "Red"), slotNumber);
		ticket.setStartTime(startTime);
		startTime.setHours(startTime.getHours()+1);
		ticket.setEndTime(startTime);
		obj.getParkedCars().put(carNumber, ticket);
		String message = obj.processInput(new Input(Input.Action.leave,
				carNumber));
		Assert.assertNull(message);
		Assert.assertNotNull(message.equals("Registration number "+carNumber+" with Slot Number "+slotNumber+" is free with Charge 10"));
	}
	
	@Test
	public void processInputTestLeaveActionSuccessBaseChargePlusExtra() {
		obj.processInput(new Input(Input.Action.create_parking_lot,
				10));
		
		String carNumber = "KA-01-HH1234";
		int slotNumber = 5;
		Date startTime = new Date();		
		ParkingTicket ticket = new ParkingTicket(new Car(carNumber, "Red"), slotNumber);
		ticket.setStartTime(startTime);
		startTime.setHours(startTime.getHours()+4);
		ticket.setEndTime(startTime);
		obj.getParkedCars().put(carNumber, ticket);
		String message = obj.processInput(new Input(Input.Action.leave,
				carNumber));
		Assert.assertNull(message);
		Assert.assertNotNull(message.equals("Registration number "+carNumber+" with Slot Number "+slotNumber+" is free with Charge 30"));
	}
	
	@Test
	public void processInputTestStausActionSuccessBaseChargePlusExtra() {
		
	}
	
	@Test
	public void Test() {

	}
}
