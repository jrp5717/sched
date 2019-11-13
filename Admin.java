import java.util.Scanner;

class Admin extends User {

	public Admin(String id, String pass) {
		super(id, pass, 2);
	}
	public int menu(Scanner input)
	{
		System.out.println("\nAccount contains " + " entries.\n"
						 + "Password Manager Menu\n"
						 + "---------------------\n"
						 + "1) See rooms\n"
						 + "2) Add a new room\n"
						 + "3) Edit a room's availability\n"
						 + "4) Remove a room\n"
						 + "0) Save & Quit\n");
		return input.nextInt();
	}
	public boolean doSomething(int choice, Scanner input, RoomList rooms)
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
        		roomNumber = input.nextInt();
        		if(rooms.remove(roomNumber))
        			System.out.println("Room " + roomNumber + " has been removed.");
        		else
        			System.out.println("ERROR: Room " + roomNumber + " does not exist.");
        		break;
        	case 0:
            	System.out.println("Goodbye!");
            	return false;
            default:
            	System.out.println("Invalid Input.");
        }
		return true;
	}
}