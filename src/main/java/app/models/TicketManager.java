package app.models;

public interface TicketManager {
	public void processInput(Input currentInput);
	public void createParkingLotAction();
	public void parkAction();
	public void leavAction();
	public void statusAction();	
}
