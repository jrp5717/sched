import java.util.Scanner;

class Admin extends User {

	public Admin(String id, String pass) {
		super(id, pass, 2);
	}
	public int menu(Scanner input)
	{
		int choice = -1;
		System.out.println("\nRoom Reservation Menu\n"
						 + "---------------------\n"
						 + "1) See rooms\n"
						 + "2) Add a new room\n"
						 + "3) Edit a room's availability\n"
						 + "4) Remove a room\n"
						 + "---------------------\n"
						 + "5) See users \n"
						 + "6) Add a new user\n"
						 + "7) Remove a user\n"
						 + "---------------------\n"
						 + "8) Change Password\n"
						 + "0) Save & Quit\n");
		while(choice < 0 || choice > 8)
		{
			try {
				String temp = input.nextLine();
				choice = Integer.valueOf(temp);
			} catch (Exception e) { System.out.println("Try again..."); }
		}
		return choice;
	}
	public boolean doSomething(int choice, Scanner input, RoomList rooms, UserList users)
	{
		switch(choice){
			case 1:
				rooms.printRooms();
				break;
        	case 2:
        		System.out.println("Which room would you like to add? ");
        		int roomNumber = input.nextInt();
        		System.out.println("How many people can it fit? ");
        		int capacity = input.nextInt();
        		rooms.add(new Room(("Library " + roomNumber), roomNumber, capacity, false, ""));
        		break;
        	case 3:
        		System.out.println("Which room reservation would you like to change?");
        		roomNumber = input.nextInt();
        		System.out.println("Who is the reservation for? (Type * to make the room available again): ");
        		String owner = input.nextLine();
        		if(owner.equals("*"))
        		{
        			rooms.changeReservation(roomNumber, "", false);
        			System.out.println("Room " + roomNumber + " has been made available.");
        		}
        		else
        		{
        			rooms.changeReservation(roomNumber, owner, true);
        			System.out.println("Room " + roomNumber + " has been reserved for " + owner + ".");
        		}
        		break;
        	case 4:
        		System.out.println("Which room would you like to remove?");
        		roomNumber = 0;
        		while(true)
        		{
        			try {
        				roomNumber = input.nextInt();
        			} catch(Exception e) { System.out.println("Please enter an integer: "); };
        			if(rooms.validRoomNumber(roomNumber))
        				break;
        			System.out.println("Room does not exist, enter a valid room number: ");
        		}
        		if(rooms.remove(roomNumber))
        			System.out.println("Room " + roomNumber + " has been removed.");
        		else
        			System.out.println("ERROR: Room " + roomNumber + " does not exist.");
        		break;
			case 5:
				users.printUsers();
				break;
        	case 6:
        		input.nextLine();
        		System.out.println("Username: ");
        		String username = input.nextLine();
        		System.out.println("Password: ");
        		String password = input.nextLine();
        		users.add(new Student(username, password));
        		break;
        	case 7:
        		System.out.println("Which user would you like to remove?");
        		username = input.nextLine();
        		if(users.remove(username))
        			System.out.println("User " + username + " has been removed.");
        		else
        			System.out.println("ERROR: User " + username + " does not exist.");
        		break;
        	case 8:
        		System.out.println("Password: ");
        		this.setPassword(input.nextLine());
        		System.out.println("Password has been changed.");
        		break;
        	case 0:
            	System.out.println("Goodbye!");
            	rooms.save();
            	users.save();
            	return false;
            default:
            	System.out.println("Invalid Input.");
        }
		return true;
	}
}