package app.models;

public class Input {

	public enum Action  {create_parking_lot, park, leave, status};
	
	private Action nextAction;
	private String carNumber;
	private int parkingSlotNumber;
	private int totalSlots;
	
	public Input() {}
	
	public Input(Action nextAction, String carNumber,
			int parkingSlotNumber) {
		this.nextAction = nextAction;
		this.carNumber = carNumber;
		this.parkingSlotNumber = parkingSlotNumber;
	}
	
	public Input(Action nextAction, int totalSlots) {
		this.nextAction = nextAction;
		this.totalSlots = totalSlots;
	}

	public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	public Input(Action nextAction, String carNumber) {
		this.nextAction = nextAction;
		this.carNumber = carNumber;
	}

	public Input(Action nextAction) {
		this.nextAction = nextAction;
	}

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
