package app.commons;

import app.models.Input;

public class TicketUtils {

	public static Boolean validateInput(String inputString) {
		// TODO Auto-generated method stub
		if(inputString == null || inputString.length() == 0) {
			return false;
		}
		String[] tokens = inputString.split(" ");
		if(tokens.length > 3) {
			return false;
		}

		switch (tokens[0]) {
		case "create_parking_lot" :
			try {
				Integer.parseInt(tokens[1]);
				return true;
			} catch (Exception e) {
				return false;
			}
		case "park":
			if(tokens.length == 2) {
				return true;
			}
			break;
		case "leave":
			if(tokens.length == 3) {
				try {
					Integer.parseInt(tokens[2]);
					return true;
				} catch (Exception e) {
					return false;
				}
			}

			break;
		case "status":
			if(tokens.length == 1) {
				return true;
			}
			break;

		default:
			return false;
		}
		return false;
	}

	public static Input createInputObj(String inputString) {
		// TODO Auto-generated method stub
		return (new Input());
	}
}
