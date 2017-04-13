package dbAccess;
import java.util.Vector;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;
import java.awt.Dimension;


public class Customer { 
	public static  boolean find(int id) {
		try {
			Connection connect=null;
			connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "SELECT `id_client`, `name`, `identity_card_number`, `personal_numerical_code`, `address` FROM `client1` where `id_client`=?";
			PreparedStatement dbStatement = connect.prepareStatement(statement);
			dbStatement.setString(1, ((Integer)id).toString());
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int id_client = rs.getInt("id_client");
				if(id==id_client)
					return true;
			}
			return false;
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	public static void update(int id,String name, int cardnumber,String cnp, String address) {
		try {
			Connection connect=null;
			connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "UPDATE `client1` SET `name`=?, `identity_card_number`=?,`personal_numerical_code`=?, `address`=? where `id_client`=?";
			PreparedStatement dbStatement = connect.prepareStatement(statement);
			dbStatement.setString(1, name);
			dbStatement.setInt(2, cardnumber);
			dbStatement.setString(3, cnp);
			dbStatement.setString(4, address);
			dbStatement.setInt(5, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println(e);
		}
	}
	
	public static void insert(int id,String name, int cardnumber,String cnp, String address) {
		try {
			Connection connect=null;
			connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "INSERT INTO client1 (id_client, name, identity_card_number, personal_numerical_code,address) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement dbStatement = connect.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.setString(2, name);
			dbStatement.setInt(3, cardnumber);
			dbStatement.setString(4, cnp);
			dbStatement.setString(5, address);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	}
	
	public static void delete(int id) {
		try {
			Connection connect=null;
			connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "DELETE FROM `client1` where `id_client`=?";
			PreparedStatement dbStatement = connect.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
			System.out.println(e);
		}
	}
	public static DefaultTableModel createTab(ResultSet rs)       throws SQLException {

	    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	public static void view() {
		try {
			Connection connect=null;
			connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/assg1","root","");	
			String statement = "Select * FROM `client1`";
			PreparedStatement dbStatement = connect.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();

		   
		    JTable table = new JTable(createTab(rs));
		    table.setPreferredScrollableViewportSize(new Dimension(850,500));
		 
		    JOptionPane.showMessageDialog(null, new JScrollPane(table));
		    System.out.println("Succes aici.");
		
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
			System.out.println(e);
		}
	}	
}