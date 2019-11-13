import java.util.ArrayList;

public class UserList
{
	ArrayList<User> users;
	
	public UserList()
	{
		users = new ArrayList<User>();
	}
	public boolean add(User s) {
		if (users.add(s)) {
			return true;
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
}