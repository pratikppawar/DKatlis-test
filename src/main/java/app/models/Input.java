package app.models;

public class Input {

	enum Action  {create_parking_lot, park, leave, status};
	
	private Action nextAction;
	private String carNumber;
	private int parkingSlotNumber;
	
	public Action getNextAction() {
		return nextAction;
	}
	public void setNextAction(Action nextAction) {
		this.nextAction = nextAction;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public int getParkingSlotNumber() {
		return parkingSlotNumber;
	}
	public void setParkingSlotNumber(int parkingSlotNumber) {
		this.parkingSlotNumber = parkingSlotNumber;
	}
}