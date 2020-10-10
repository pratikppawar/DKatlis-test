package app.models;

public interface TicketManager {
	public void processInput(Input currentInput);
	public void createParkingLotAction(Input ip);
	public void parkAction(Input ip);
	public void leaveAction(Input ip);
	public void statusAction(Input ip);	
}
