package app.commons;

import org.junit.Assert;
import org.junit.Test;
import app.models.Input;


public class TicketUtilsTest {

	@Test
	public void validateInputTestEmptyStringInput() {
		String input = "";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertFalse(outputToCheck);
	}

	@Test
	public void validateInputTestIncorrectAction() {
		String input = "move KA-01-HH-1234";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertFalse(outputToCheck);
	}

	@Test
	public void validateInputTestMissingParkingSlotNumber() {
		String input = "leave KA-01-HH-1234";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertFalse(outputToCheck);
	}

	@Test
	public void validateInputTestInvalidParkingSlotNumber() {
		String input = "leave KA-01-HH-1234 A";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertFalse(outputToCheck);
	}

	@Test
	public void validateInputTestMissingCarNumber() {
		String input = "leave 6";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertFalse(outputToCheck);
	}

	@Test
	public void validateInputTestValidInputForParkAction() {
		String input = "park KA-01-HH-1234";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertTrue(outputToCheck);
	}

	@Test
	public void validateInputTestValidInputForleaveAction() {
		String input = "leave KA-01-HH-3141 4";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertTrue(outputToCheck);
	}

	@Test
	public void validateInputTestValidInputForCreatParkingLotAction() {
		String input = "create_parking_lot 6";
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertTrue(outputToCheck);
	}

	@Test
	public void validateInputTestValidInputForStatusAction() {
		String input = Input.Action.status.toString();
		Boolean outputToCheck = TicketUtils.validateInput(input);
		Assert.assertTrue(outputToCheck);
	}

	@Test
	public void createInputObjValidInputForParkAction() {
		String input = "park KA-01-HH-1234";
		Input outputToCheck = TicketUtils.createInputObj(input);
		Assert.assertEquals(Input.Action.park, outputToCheck.getNextAction());
		Assert.assertEquals("KA-01-HH-1234", outputToCheck.getCarNumber());
		Assert.assertNotNull(outputToCheck.getParkingSlotNumber());
	}

	@Test
	public void createInputObjTestValidInputForleaveAction() {
		String input = "leave KA-01-HH-3141 4";
		Input outputToCheck = TicketUtils.createInputObj(input);
		Assert.assertEquals(Input.Action.leave, outputToCheck.getNextAction());
		Assert.assertEquals("KA-01-HH-3141", outputToCheck.getCarNumber());
		Assert.assertEquals(4,outputToCheck.getParkingSlotNumber());
	}

	@Test
	public void createInputObjTestValidInputForCreatParkingLotAction() {
		String input = "create_parking_lot 6";
		Input outputToCheck = TicketUtils.createInputObj(input);
		Assert.assertEquals(Input.Action.create_parking_lot, outputToCheck.getNextAction());
		Assert.assertEquals(outputToCheck.getParkingSlotNumber(), 0);
		Assert.assertNull(outputToCheck.getCarNumber());
	}

	@Test
	public void createInputObjTestValidInputForStatusAction() {
		String input = "status";
		Input outputToCheck = TicketUtils.createInputObj(input);
		Assert.assertEquals(Input.Action.status, outputToCheck.getNextAction());
		Assert.assertEquals(outputToCheck.getParkingSlotNumber(),0);
		Assert.assertNull(outputToCheck.getCarNumber());
	}
}
