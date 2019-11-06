import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	private static String username;
	private static String password;

	public User() { }

	public User (String username, String Password)
	{
		this.username = username;
		this.password = password;
	}

	String getUsername() {return username;}
	String getPassword() {return password;}

	public static int Login()
	{
		Scanner in = new Scanner(System.in);
		String userIn;
		String passIn;

		List<User> listOfUsers = new ArrayList<>();

		listOfUsers.add(new User("student", ""));
		listOfUsers.add(new User("admin", ""));

		System.out.println("Type in Username");
		userIn = in.nextLine();
		System.out.println("Type in Password");
		passIn = in.nextLine();
		in.close();

		for (User user : listOfUsers)
		{
			if (user.getUsername().equals("student"))
			{
				if(user.getPassword().equals(""))
				{
					username = userIn;
					password = passIn;
					return 0;
				}
			}
			else if(user.getUsername().equals("admin"))
			{
				if(user.getPassword().equals(""))
				{
					username = userIn;
					password = passIn;
					return 1;
				}
			}
		}
		return 2;
	}

}
