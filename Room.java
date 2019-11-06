import java.util.List;

public class Room
{
    public String name;
    public int roomNum;
    public int capacity;
    public List<String> features;
    public Boolean reserved;
    public String ownedBy;

    public Room(String name, int roomNum, int cap, List<String> features, Boolean isReserved, String ownedBy)
    {
        this.name = name;
        this.roomNum = roomNum;
        this.capacity = cap;
        this.features = features;
        this.reserved = isReserved;
        this.ownedBy = ownedBy;
    }
}