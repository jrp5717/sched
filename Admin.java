import java.util.ArrayList;

class Admin extends User {
	private String id, pass;
	ArrayList<Room> roomList;

	public Admin(String id, String pass, ArrayList<Room> roomList) {
		this.id = id;
		this.pass = pass;
		this.roomList = roomList;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param roomList the roomList to set
	 */
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}

	/**
	 * @return the roomList
	 */
	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public boolean editAvailability(int roomNum) {
		if (!roomList.get(roomNum).reserved) {
			roomList.get(roomNum).reserved = true;
		}
		return false;
	}

	public void changeReservation(int roomNum, String newOwner) {
		roomList.get(roomNum).ownedBy = newOwner;
	}

	public boolean add(Room r) {
		if (roomList.add(r)) {
			return true;
		}
		return false;
	}

	public void remove(int roomNum) {
		roomList.remove(roomNum);
	}
}