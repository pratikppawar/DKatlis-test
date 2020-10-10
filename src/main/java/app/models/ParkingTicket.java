package app.models;

import java.util.Date;

public class ParkingTicket {

	private Car parkedCar;
	private Date startTime;
	private Date endTime;
	private int slotNumber;
	private int totalParkingCharge;

	public static int baseCharge = 10;
	public static int extraHourlyCharge = 10;

	public ParkingTicket() {}

	public ParkingTicket(Car parkedCar, int slotNumber) {
		this.parkedCar = parkedCar;
	}

	public int getTotalParkingCharge() {
		return totalParkingCharge;
	}
	public void setTotalParkingCharge(int totalParkingCharge) {
		this.totalParkingCharge = totalParkingCharge;
	}

	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Car getParkedCar() {
		return parkedCar;
	}
	public void setParkedCar(Car parkedCar) {
		this.parkedCar = parkedCar;
	}

	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
