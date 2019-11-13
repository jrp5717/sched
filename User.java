import java.util.Scanner;

public class User {
	private String username;
	private String password;
	private int access;

	public User() {this("admin", "", 0);}

	public User (String username, String password)
	{
		this(username,password,0);
	}
	
	public User(String username, String password, int access)
	{
		this.username = username;
		this.password = password;
		this.access = access;
	}
	public int menu(Scanner input)
	{
		return 0;
	}
	public boolean doSomething(int choice, Scanner input, RoomList rooms)
	{
		return false;
	}
	
	String getUsername() {return username;}
	String getPassword() {return password;}
	int getAccess() {return access;}
	void setUsername(String username) {this.username = username;}
	void setPassword(String password) {this.password = password;}
}
