public class Room
{
    private String name;
    private int roomNum;
    private int capacity;
    private Boolean reserved;
    private String ownedBy;

    public Room(String name, int roomNum, int cap, Boolean isReserved, String ownedBy)
    {
        this.name = name;
        this.roomNum = roomNum;
        this.capacity = cap;
        this.reserved = isReserved;
        this.ownedBy = ownedBy;
    }

	//@return the name
	public String getName()
	{
		return name;
	}

	//@return the roomNum
	public int getRoomNum()
	{
		return roomNum;
	}

	//@return the capacity
	public int getCapacity()
	{
		return capacity;
	}

	//@return the reserved
	public Boolean getReserved()
	{
		return reserved;
	}

	//@return the ownedBy
	public String getOwnedBy()
	{
		return ownedBy;
	}

	//@param name the name to set
	public void setName(String name)
	{
		this.name = name;
	}

	//@param roomNum the roomNum to set
	public void setRoomNum(int roomNum)
	{
		this.roomNum = roomNum;
	}

	//@param capacity the capacity to set
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	//@param reserved the reserved to set
	public void setReserved(Boolean reserved)
	{
		this.reserved = reserved;
	}

	//@param ownedBy the ownedBy to set
	public void setOwnedBy(String ownedBy)
	{
		this.ownedBy = ownedBy;
	}
	
	@Override
	public String toString()
	{
		return name + ";" + roomNum + ";" + capacity + ";" + reserved + ";" + ownedBy;
	}
    
	
}