package app.models;

import java.util.Date;

public class ParkingTicket {
	
	private Car parkedCar;
	private Date startTime;
	private Date endTime;
	
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
