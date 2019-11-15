import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RoomList
{
	ArrayList<Room> rooms;
	String loc;
	
	public RoomList()
	{
		rooms = new ArrayList<Room>();
		loc = "Rooms";
		readIn();
	}
	
	public boolean reserve(int roomNum, String id) {
		if (!rooms.get(roomNum).getReserved()) {
			rooms.get(roomNum).setReserved(true);
			rooms.get(roomNum).setOwnedBy(id);
			return true;
		}
		return false;
	}

	public boolean cancel(int roomNum, String id) {
		if (rooms.get(roomNum).getOwnedBy().equals(id)) {
			rooms.get(roomNum).setReserved(false);
			rooms.get(roomNum).setOwnedBy("none");
			return true;
		}
		return false;
	}

	public void changeReservation(int roomNum, String newOwner, boolean reserve) {
		rooms.get(roomNum).setOwnedBy(newOwner);
		rooms.get(roomNum).setReserved(reserve);
	}

	public boolean add(Room r) {
		if (rooms.add(r)) {
			return true;
		}
		return false;
	}

	public boolean remove(int roomNum) {
		
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getRoomNum() == roomNum) {
				rooms.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void printRooms()
    {
        for (Room room : rooms) {
            System.out.println("Room name: " + room.getName()
            				+ "\nNumber: " + room.getRoomNum()
            				+ "\nCapacity: " + room.getCapacity()
            				+ "\nReserved: " + room.getReserved()
            				+ "\nCurrent Owner: " + room.getOwnedBy()
            				+ "\n");
        }
    }
	
	public boolean validRoomNumber(int i)
	{
		for(Room r: rooms)
			if(r.getRoomNum() == i)
				return true;
		return false;
	}
	private void readIn()
	{
		try {
	    	BufferedReader reader = new BufferedReader(new FileReader(loc));
			while(true)
			{
				String[] tokens = reader.readLine().split(";");
				boolean isReserved = tokens[3].equals("true");
				rooms.add(new Room(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]), isReserved, tokens[4]));
			}
	    } catch(Exception e){}
	}
	public void save()
	{
		String all = "";
		for(int i = 0; i < rooms.size(); i++)
		{
			all += rooms.get(i).toString() + "\n";
		}
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(loc));
			writer.write(all);
			writer.close();
		} catch(Exception e)
		{
			System.out.println("Error saving to PasswordLog");
		}
	}
}
