class Student extends User
{
    private String id, pass;
    public Student(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }

    public void setPass(String pass) {
      this.pass = pass;
    }

    public String getPass() {
      return pass;
    }

    public boolean reserve(int roomNum) {
      if ((roomList.reserve(roomNum))) {
        return true;
      }
      return false;
    }
    
    public boolean cancel(int roomNum) {
      if (roomList.getRoom(roomNum).compareTo(id)) {
        roomList.cancel(roomNum);
        return true;
      }
      return false;
    }
}