package by.htp.dz6.equipment.command;



public class CommandChooser {

	public static CommandAction chooseAction(String action) {
		
		switch (action) {
		case "login": {
			System.out.println("Login action");
			return new LoginCommandAction();
			
		}
		}
		return null;
	}
	
}

