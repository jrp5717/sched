import java.util.ArrayList;

class Student extends User {
	private String id, pass;
	ArrayList<Room> roomList;

	public Student(String id, String pass, ArrayList<Room> roomList) {
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
	 * @return the roomList
	 */
	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	/**
	 * @param roomList the roomList to set
	 */
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}

	public boolean reserve(int roomNum) {
		if (!roomList.get(roomNum).reserved) {
			roomList.get(roomNum).reserved = true;
			roomList.get(roomNum).ownedBy = this.id;
			return true;
		}
		return false;
	}

	public boolean cancel(int roomNum) {
		if (roomList.get(roomNum).ownedBy == this.id) {
			roomList.get(roomNum).reserved = false;
			return true;
		}
		return false;
	}
}