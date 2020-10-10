package app.models;

public class Car {

	private String carNumber;
	private String carColor;
	
	public Car() {}
	public Car(String carNumber, String carColor) {
		this.carNumber = carNumber;
		this.carColor = carColor;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
}
