import java.util.ArrayList;

public class RoomList
{
	ArrayList<Room> rooms;
	
	public RoomList()
	{
		rooms = new ArrayList<Room>();
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
			rooms.get(roomNum).setOwnedBy("");
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
}
