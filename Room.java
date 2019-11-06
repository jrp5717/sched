public class Room
{
    String name;
    int roomNum;
    int capacity;
    List<String> features = new List<String>();
    Boolean reserved;
    String ownedBy;

    public Room(String name, int roomNum, int cap, List<String> features, Boolean isReserved, String ownedBy) {
        this.name = name;
        this.roomNum = roomNum;
        this.capacity = cap;
        this.features = features;
        this.reserved = isReserved;
        this.ownedBy = ownedBy;
    }
}