package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dbAccess.User;
import dbAccess.UserGW;

public class UserLogic {
	
	public static boolean userCorect(String user)
	{
		return UserGW.exists(user);
	}
	public static boolean matchPass(String username,String pass)
	{
		return UserGW.checkPassword(username, pass);
	}
	public static boolean isAdmin(String user)
	{
		return UserGW.isAdministrator(user);
	}
	public static synchronized void delete(int id)
	{
		UserGW.delete(id);
	}
	public static String report(String u) throws FileNotFoundException
	{
		@SuppressWarnings("resource")
		String text = new Scanner( new File(u+".txt") ).useDelimiter("\\A").next();
        return text;
	}
	public static synchronized void insert(int id,String username, String password)
	{
		User.insert(id,username,password);
	}
	public static synchronized void update(int id,String username, String password) {
		 User.update(id,username,password);
	}
}