package app.models;

public interface TicketManager {
	public String processInput(Input currentInput);
	public String createParkingLotAction(Input ip);
	public String parkAction(Input ip);
	public String leaveAction(Input ip);
	public String statusAction(Input ip);	
}
