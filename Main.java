import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomList rooms = new RoomList();
        UserList listOfUsers = new UserList();
        listOfUsers.add(new Student("student1", ""));
        listOfUsers.add(new Student("student2", ""));
        listOfUsers.add(new Admin("admin", ""));
        rooms.add(new Room("Library 205", 205, 30, false, ""));
        rooms.add(new Room("Library 204", 204, 30, true, "student1"));
        Scanner input = new Scanner(System.in);
        int access = 3;
        Boolean progLoop = true;
        User user;

        do{
    		System.out.println("Type in Username");
    		String userIn = input.nextLine();
    		System.out.println("Type in Password");
    		String passIn = input.nextLine();
    		
        	user = listOfUsers.Login(userIn, passIn);
        	
            if (user == null) {
                System.out.println("Wrong login");
            } else {
                access = user.getAccess();
            	System.out.println("Accepted!");
            }
        }while (access == 3);
        
        while (progLoop){
             int choice = user.menu(input);
             progLoop = user.doSomething(choice, input, rooms);
        }
    }
}