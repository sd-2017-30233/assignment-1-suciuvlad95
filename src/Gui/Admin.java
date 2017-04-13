package Gui;

import javax.swing.*;
import businessLogic.UserLogic;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;



public class  Admin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField passField;
	private JTextField textField;
	private JTextField textField_1;
	

	public Admin() {
		super("Fereastra Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 425);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Update angajat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Introduceti un user");
				else if(passField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Introduceti o parola");
				else {
						int id=Integer.parseInt(textField.getText());
				        String username=textField_1.getText();
				        String pass=passField.getText();
				        if(cmd.equals("Open"))
				        {
				        	if(UserLogic.userCorect(username))
				    		{ 
				        		UserLogic.update(id,username,pass);
				        		JOptionPane.showMessageDialog(null, "Angajat updated cu succes");
				    		}
				    		else JOptionPane.showMessageDialog(null, "Angajat inexistent");	     
				        }
				}
			}
		});

		btnNewButton.setBounds(47, 97, 150, 32);
		btnNewButton.setActionCommand("Open");
		contentPane.add(btnNewButton);
		
		
		
		JButton btnInsertEmployee = new JButton("Adaugare angajat");
		btnInsertEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Introduceti username");
				else if(passField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Introduceti password");
					passField.setBackground(Color.RED);
				}
				else {
						int id=Integer.parseInt(textField.getText());
				        String username=textField_1.getText();
				        String pass=passField.getText();
				        //User u=new User(id,username,pass);
				        if(cmd.equals("Open"))
				        {
				        	if(!UserLogic.userCorect(username))
				            {
				        		UserLogic.insert(id,username,pass);
				        		JOptionPane.showMessageDialog(null, "Angajatul s-a inserat cu succes");
				            }
				    		else JOptionPane.showMessageDialog(null, "Angajat deja introdus");
				        }
				}
			}
		});
		btnInsertEmployee.setBounds(47, 54, 150, 32);
		btnInsertEmployee.setActionCommand("Open");
		contentPane.add(btnInsertEmployee);
		

		
		JButton stergereButton = new JButton("Stergere angajat");
		stergereButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else {
						int id=Integer.parseInt(textField.getText());
				        if(cmd.equals("Open"))
				        {
				        	try{
				        			UserLogic.delete(id);
				        			JOptionPane.showMessageDialog(null, "ANGAJAT STERS");
				              
				        		}
				          catch(Exception s){
				        	  
				        	  System.out.println(s);
				          	 JOptionPane.showMessageDialog(null, "Angajat inexistent");
				          }
				        }
		        }
			}
		});
		stergereButton.setBounds(50, 140, 150, 34);
		stergereButton.setActionCommand("Open");
		contentPane.add(stergereButton);
		
		JButton raportButton = new JButton("Generare raport");
		raportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "usernameul nu respecta regulile");
				else {
						String username=textField_1.getText();
					   if(UserLogic.userCorect(username))
							try {
								try {
										JOptionPane.showMessageDialog(null,UserLogic.report(username));
								} catch (FileNotFoundException e1) {
									
									e1.printStackTrace();
								}
							} catch (HeadlessException e1) {
								
								e1.printStackTrace();
							}
					  else JOptionPane.showMessageDialog(null, "Acest user nu exista");
				}
			}
		});
		
		raportButton.setBounds(50, 183, 150, 34);
		raportButton.setActionCommand("Open");
		contentPane.add(raportButton);
		
		JButton btnLogout = new JButton("Delogare");
		btnLogout.setBounds(360, 190, 130, 30);
		btnLogout.setActionCommand("Open");
		contentPane.add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				String state = e.getActionCommand();
				 if(state.equals("Open"))
			        {
						dispose();
			            new GenerateInterface();
			        }
			}
		});
		
		
		
		JLabel lblIdEmployee = new JLabel("Id employee");
		lblIdEmployee.setBounds(250, 54, 101, 23);
		contentPane.add(lblIdEmployee);
		
		textField = new JTextField();
		textField.setBounds(374, 54, 116, 23);
		contentPane.add(textField);
		textField.setColumns(12);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(250, 106, 86, 14);
		contentPane.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(374, 103, 116, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(12);
		
		JLabel lblPassword = new JLabel("Parola");
		lblPassword.setBounds(250, 149, 86, 14);
		contentPane.add(lblPassword);
		
		passField = new JTextField();
		passField.setBounds(374, 146, 116, 23);
		contentPane.add(passField);
		passField.setColumns(12);
		
        setVisible(true);
	}
}
