import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserList
{
	ArrayList<User> users;
	String loc;
	
	public UserList()
	{
		users = new ArrayList<User>();
		loc = "Users";
		readIn();
	}
	public boolean add(User s) {
		if (users.add(s)) {
			return true;
		}
		return false;
	}
	public boolean remove(String username) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				users.remove(i);
				return true;
			}
		}
		return false;
	}
	public User Login(String userIn, String passIn)
	{
		for (User user : users)
		{
			if(user.getUsername().equals(userIn))
			{
				if(user.getPassword().equals(passIn))
				{
					return user;
				}
			}
		}
		return null;
	}
	private void readIn()
	{
		try {
	    	BufferedReader reader = new BufferedReader(new FileReader(loc));
			while(true)
			{
				String[] tokens = reader.readLine().split(";");
				if(tokens[0].equals("2"))
					users.add(new Admin(tokens[1], tokens[2]));
				else
					users.add(new Student(tokens[1], tokens[2]));
			}
	    } catch(Exception e){}
	}
	public void save()
	{
		String all = "";
		for(int i = 0; i < users.size(); i++)
		{
			all += users.get(i).toString() + "\n";
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
	public void printUsers()
    {
        for (User u : users) {
            System.out.println(u.getUsername());
        }
    }
}