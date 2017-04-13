package Gui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import businessLogic.UserLogic;


public class GenerateInterface extends JFrame implements ActionListener
{
	
	private JTextField userField;
	private JPasswordField passField;
	private JButton btnLog;
	private static final long serialVersionUID = 1L;
    private JPanel contentPanel;
	
	

//cons
	public GenerateInterface() {
		
		super("Aplicatia bancii tale :) ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 450, 450);
		contentPanel = new JPanel();
		
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel logInlbl = new JLabel("Panou Autentificare");
		logInlbl.setBounds(130, 40, 400, 15);
		contentPanel.add(logInlbl);
		
		JLabel lblUsername = new JLabel("User");
		lblUsername.setBounds(41, 87, 65, 14);
		contentPanel.add(lblUsername);
		
		userField = new JTextField();
		userField.setBounds(145,90,121, 20);
		contentPanel.add(userField);
		userField.setColumns(10);
		
		JLabel passlbl = new JLabel("Parola");
		passlbl.setBounds(41, 113, 65, 20);
		contentPanel.add(passlbl);
		
		passField = new JPasswordField();
		passField.setBounds(145, 110, 121, 20);
		contentPanel.add(passField);
		passField.setColumns(10);
		
		btnLog = new JButton("Autentificare");
		btnLog.setBounds(145, 161,120, 30);
		
		btnLog.addActionListener( action );
		btnLog.addActionListener(this);
		btnLog.setActionCommand("Go");
		contentPanel.add(btnLog);
		
		setVisible(true);
	}
	
	public String getUserName()
	{
		String user=userField.getText();
		return user;
	}
	Action action = new AbstractAction()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	    	
	    }
	};

	
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	      
	        String username=userField.getText();
	        @SuppressWarnings("deprecation")
			String pass=passField.getText();
	        String comanda = e.getActionCommand();
	        
	        if(comanda.equals("Go"))
	        {
	            if(UserLogic.userCorect(username))
		            
	            	if(UserLogic.matchPass(username, pass))
			        {
	            		dispose();
			            if(UserLogic.isAdmin(username))
			             	new Admin();
			            else {
			            	    new Employee(username);
					            try{
								    PrintWriter objWrite = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    objWrite.println("Angajatul "+username+" s-a logat la : "+new Date());
								    objWrite.close();
								} catch (IOException ss) {
									
									System.out.println(ss);
								}
					        }
			         }
		            else {
		            			JOptionPane.showMessageDialog(null, "Parola gresita");
		            			passField.setBackground(Color.RED);
		            			passField.setText("");
		            			
		            	}
	            	
		            
	            else JOptionPane.showMessageDialog(null, "Username gresit");
	        }
	    }
	
	    
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					GenerateInterface gui = new GenerateInterface();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    //sfarsit interfata.
}