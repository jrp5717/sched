import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(new Room("Library 205", 254, 30, null, false, "admin"));
        roomList.add(new Room("Library 204", 255, 30, null, true, "user"));
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

    /*
    public static ArrayList ListRead() {
        ArrayList<Room> roomlist;
        BufferedReader reader = new BufferedReader(new FileReader("vault.txt"));
        byte[] encKey = getKey(reader.readLine());
        String lineIn;
        lineIn = reader.readLine();
        String[] masterLine = lineIn.split(";");
        genIV = Base64.getDecoder().decode(masterLine[1]);
        masterpass = decryptPass(Base64.getDecoder().decode(masterLine[0]));
        while((lineIn = reader.readLine()) != null) {
            String[] splitLine = lineIn.split(";");
            vault.add(new Entry(splitLine[0], splitLine[1], splitLine[2], userKey, splitLine[3]));
        }
        reader.close();
    }
    */
}