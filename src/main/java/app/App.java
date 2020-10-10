package app;

import app.models.TicketManager;
import app.models.TicketManagerImpl;

public class App {
	
	private TicketManager ticketManagerObj;
	
	public App() {
		ticketManagerObj = new TicketManagerImpl();
	}
	
	public static void main(String[] args) {
		App appObj = new App();
	}

	public TicketManager getTicketManagerObj() {
		return ticketManagerObj;
	}

	public void setTicketManagerObj(TicketManager ticketManagerObj) {
		this.ticketManagerObj = ticketManagerObj;
	}
}
