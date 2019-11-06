import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room("Library 205", 205, 30, null, false, "admin"));
        roomList.add(new Room("Library 204", 204, 30, null, true, "user"));
        Scanner input = new Scanner(System.in);
        int access = 0;
        Boolean progLoop = true;
        Boolean loginLoop = true;
        User u = new User();

        while (loginLoop) {
            access = u.Login();
            if (access == 3) {
                System.out.println("Wrong login");
            } else {
                loginLoop = false;
            }
        }

        while (progLoop) {
            System.out.println("Accepted!");
            System.out.println("What would you like to do?");
            if (access == 1) {
                u = new Student("user", "", roomList);
                System.out.println("[1] Reserve a room");
                System.out.println("[2] Cancel a reservation");
                System.out.println("[0] Quit\n");
                int choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("Which room would you like to reserve?");

                } else if (choice == 2) {
                    System.out.println("Which reservation would you like to cancel?");

                } else if (choice == 0) {
                    System.out.println("Goodbye!");
                    progLoop = false;
                } else {
                    System.out.println("Invalid Input.");
                }
            } else if (access == 2) {
                u = new Admin("admin", "", roomList);
                System.out.println("[1] Add a new room");
                System.out.println("[2] Edit a room's availability");
                System.out.println("[3] Remove a room");
                System.out.println("[0] Quit\n");
                int choice = input.nextInt();
                if (choice == 1) {

                } else if (choice == 2) {

                } else if (choice == 3) {

                } else if (choice == 0) {
                    System.out.println("Goodbye!");
                    progLoop = false;
                } else {
                    System.out.println("Invalid Input");
                }
            }
        }
    }

    public static void printRooms(ArrayList<Room> rooms)
    {
        for (Room room : rooms) {
            System.out.println("Room name: " + room.name);
            System.out.println("Number: " + room.roomNum);
            System.out.println("Capacity: " + room.capacity);
            System.out.println("Reserved: " + room.reserved);
            System.out.println("Current Owner: " + room.ownedBy);
        }
    }
}