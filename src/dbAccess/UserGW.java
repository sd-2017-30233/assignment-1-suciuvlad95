package dbAccess;

import java.sql.*;


public class UserGW {
	
	public static boolean isAdministrator(String user)
	{
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			
			String statement = "SELECT `type` FROM `userrole` where `id_user`=(Select `id_user` from `user` where `username`=?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, user);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int type1 = rs.getInt("type");
				if(type1==1)
					return true;
				else return false;
			}
			return false;
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users bad connection.");
			return false;
		}
	}
	public static boolean checkPassword(String username,String pass)
	{	
		try {
		Connection conn=null;
		conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
		String statement = "SELECT `password` FROM `user` where `username`=?";
		PreparedStatement dbStatement = conn.prepareStatement(statement);
		dbStatement.setString(1, username);
		ResultSet rs = dbStatement.executeQuery();
		
		while(rs.next()) {
			String pass1 = rs.getString("password");
			if(pass1.equals(pass))
				return true;
			else return false;
		}
		return false;
	} catch (SQLException e) {
	
		System.out.println("Error occured reading Users from the data source.");
		return false;
		}
	}
	public static boolean exists(String user)
	{
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "SELECT `id_user` FROM `user` where `username`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, user);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_user");
				if(id!=0)
					return true;
				else return false;
			}
			return false;
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users from the data source.");
			return false;
		}
	}
	public static void update(int id,String username, String pass) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "UPDATE `user` SET `username`=?, `password`=? where `id_user`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, username);
			dbStatement.setString(2, pass);
			dbStatement.setInt(3, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println("Error occured reading Users from the data source.");
		}
	}
	
	public static void insert(int id,String username, String pass) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "INSERT INTO `user` (`id_user`, `username`, `password`) VALUES (?, ?, ?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.setString(2, username);
			dbStatement.setString(3, pass);
			dbStatement.executeUpdate();
			String statement1 = "INSERT INTO `userrole` (`id_role`, `type`, `id_user`) VALUES (?, ?, ?)";
			PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
			dbStatement1.setInt(1, id+2);
			dbStatement1.setString(2, "employee");
			dbStatement1.setInt(3, id);
			dbStatement1.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("Error occured reading Users from the data source.");
		}
	}
	
	public static void delete(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");
			String statement1="DELETE FROM userrole WHERE userrole.id_user='"+id+"'";
			String statement = "DELETE FROM user where id_user='"+id+"'";
			PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
			dbStatement1.executeUpdate();
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users from the data source.");
		}
	}
}