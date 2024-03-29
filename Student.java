import java.util.Scanner;

class Student extends User {

	public Student(String id, String pass) {
		super(id, pass, 1);
	}
	
	public int menu(Scanner input)
	{
		System.out.println("Password Manager Menu\n"
						 + "---------------------\n"
						 + "1) See rooms\n"
						 + "2) Reserve a room\n"
						 + "3) Cancel a reservation\n"
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
        		System.out.println("Which room would you like to reserve?");
        		int roomNumber = 0;
        		while(true)
        		{
        			try {
        				roomNumber = input.nextInt();
        			} catch(Exception e) { System.out.println("Please enter an integer: "); };
        			if(rooms.validRoomNumber(roomNumber))
        				break;
        			System.out.println("Room does not exist, enter a valid room number: ");
        		}
        		if(rooms.reserve(roomNumber, this.getUsername()))
        			System.out.println("Room has been reserved.");
        		else
        			System.out.println("ERROR: Room is already reserved.");
        		break;
        		
        	case 3:
        		System.out.println("Which reservation would you like to cancel?");
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
        		if(rooms.cancel(roomNumber, this.getUsername()))
        			System.out.println("Reservation has been cancelled.");
        		else
        			System.out.println("ERROR: Room is not reserved by you.");
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