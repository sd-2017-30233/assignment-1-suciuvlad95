package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Pattern;

import businessLogic.AccountLogic;
import businessLogic.CustomerLogic;

public class Employee extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel firstPanel;
	private String username;
	
	private JTextField idField;
	private JTextField numeField;
	private JTextField cnpField;
	private JTextField cardNbField;
	private JTextField adresaField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	public Employee(String user){
		
	        super("fereastra angajat bancarr");
	        this.username=user;
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 650, 600);
			firstPanel = new JPanel();
			
			
			setContentPane(firstPanel);
			firstPanel.setLayout(null);
			  
			JButton btnAddClient = new JButton("Adauga client");
			btnAddClient.setBounds(45, 25, 130, 35);
			btnAddClient.setActionCommand("Open");
			firstPanel.add(btnAddClient);
			
			btnAddClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(idField.getText().equals("")|| !Pattern.matches("[0-9]+", idField.getText()))
						JOptionPane.showMessageDialog(null, "Id client incorect");
					else if(numeField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Nume gresit");
					else if(cardNbField.getText().equals("")|| !Pattern.matches("[0-9]+", cardNbField.getText()))
						JOptionPane.showMessageDialog(null, "numar card invalid");
					else if(cnpField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "CNP gresit");
					else if(adresaField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "adresa nu respecta regulile");
					else {
							int id=Integer.parseInt(idField.getText());
					        String name=numeField.getText();
					        int cardnb=Integer.parseInt(cardNbField.getText());
					        String CNP=cnpField.getText();
					        String address=adresaField.getText();
					        if(cmd.equals("Open"))
					        {
					        	if(CustomerLogic.find(id)==false)
								{
					        		CustomerLogic.insert(id,name,cardnb,CNP,address);
								    if(CustomerLogic.find(id)==true)
									JOptionPane.showMessageDialog(null, "Client nou adaugat");
								else JOptionPane.showMessageDialog(null, "Eroare la adaugare");
						         }
					        else JOptionPane.showMessageDialog(null, "Client existent deja");  
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" inserted client "+name+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}
					       }
					}
				}
			});
			
			
			JButton btnUpdateClient = new JButton("Update client");
			btnUpdateClient.setBounds(45, 70, 130, 35);
			btnUpdateClient.setActionCommand("Open");
			firstPanel.add(btnUpdateClient);
			btnUpdateClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(idField.getText().equals("")|| !Pattern.matches("[0-9]+", idField.getText()))
						JOptionPane.showMessageDialog(null, "Id client incorect");
					else if(numeField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Nume gresit");
					else if(cardNbField.getText().equals("")|| !Pattern.matches("[0-9]+", cardNbField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification card number");
					else if(cnpField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "CNP gresit");
					else if(adresaField.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid address");
					else {
										        
					        int id=Integer.parseInt(idField.getText());
					        String name=numeField.getText();
					        int cardnb=Integer.parseInt(cardNbField.getText());
					        String CNP=cnpField.getText();
					        String address=adresaField.getText();
					        
					        if(cmd.equals("Open"))
					        {
					        	if(CustomerLogic.find(id)==true)
					        	{
					        		CustomerLogic.update(id,name,cardnb,CNP,address);
					             JOptionPane.showMessageDialog(null, "Client actualizat");		
					        	}
					        	  else JOptionPane.showMessageDialog(null, "Clientul nu exista"); 
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" updated client "+name+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}
					        }
					}
				}
			});
		
			
			JButton btnNewButton = new JButton("Vezi clienti");
			btnNewButton.setBounds(45, 110, 130, 35);
			btnNewButton.setActionCommand("Open");
			firstPanel.add(btnNewButton);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
			        if(cmd.equals("Open"))
			        {
			        	CustomerLogic.view();			     
			        }
				}
			});
			
			
			JButton btnAddAccount = new JButton("Adauga cont");
			btnAddAccount.setBounds(45, 150, 130, 34);
			btnAddAccount.setActionCommand("Open");
			firstPanel.add(btnAddAccount);
			
			btnAddAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					//textField_5.setVisible(false);
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else if(textField_6.getText().equals("")|| !Pattern.matches("[0-9]+", textField_6.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification number");
					else if(textField_7.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid type");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else if(textField_9.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid date");
					else if(idField.getText().equals("")|| !Pattern.matches("[0-9]+", idField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else {
							int id=Integer.parseInt(textField_5.getText());
					        int number=Integer.parseInt(textField_6.getText());
					        String type=textField_7.getText();
					        int money=Integer.parseInt(textField_8.getText());
					        String date=textField_9.getText();
					        int clid=Integer.parseInt(idField.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountLogic.searchByID(id)==false)
					            {
					        		AccountLogic.inserare(id,number,type,money,date,clid);
					        		JOptionPane.showMessageDialog(null, "Cont adaugat");	
					            }
					            else JOptionPane.showMessageDialog(null, "Contul exista deja");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" inserted account "+number+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}
					        }
					}
				}
			});
			
		
			
			JButton btnUpdateAccount = new JButton("Update cont");
			btnUpdateAccount.setBounds(45, 190, 130, 34);
			btnUpdateAccount.setActionCommand("Open");
			firstPanel.add(btnUpdateAccount);
			
			btnUpdateAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else if(textField_6.getText().equals("")|| !Pattern.matches("[0-9]+", textField_6.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification number");
					else if(textField_7.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid type");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else if(textField_9.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid date");
					else if(idField.getText().equals("")|| !Pattern.matches("[0-9]+", idField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else {
							int id=Integer.parseInt(textField_5.getText());
					        int number=Integer.parseInt(textField_6.getText());
					        String type=textField_7.getText();
					        int money=Integer.parseInt(textField_8.getText());
					        String date=textField_9.getText();
					        int clid=Integer.parseInt(idField.getText());
					      //  Account acc=new Account(id,number,type,money,date,clid);
					        if(cmd.equals("Open"))
					        {
					        	if(AccountLogic.searchByID(id)==true)
					           {
					        		AccountLogic.update(id,number,type,money,date,clid);
					                JOptionPane.showMessageDialog(null, "Account updated");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" updated account "+number+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}
					        }
					}
				}
			});
		
			
			JButton btnDeleteAccount = new JButton("Sterge un cont");
			btnDeleteAccount.setBounds(45, 230, 130,34);
			btnDeleteAccount.setActionCommand("Open");
			firstPanel.add(btnDeleteAccount);
			
			btnDeleteAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
							JOptionPane.showMessageDialog(null, "Invalid account id");
					else {
						int id=Integer.parseInt(textField_5.getText());			       
				        if(cmd.equals("Open"))
				        {
				        	if(AccountLogic.searchByID(id)==true)
				            {
				        		AccountLogic.stergere(id);
				                JOptionPane.showMessageDialog(null, "Account deleted");
				            }
				       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
				        	try{
							    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
							    writer.println(username+" deleted account "+id+" at : "+new Date());
							    writer.close();
							} catch (IOException ee) {
								 System.out.println(ee);
							}				        	
				        }
					}
				}
			});
			
			
			JButton btnViewAccount = new JButton("Vezi conturi");
			btnViewAccount.setBounds(45, 270, 130, 34);
			btnViewAccount.setActionCommand("Open");
			firstPanel.add(btnViewAccount);
			btnViewAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
			        if(cmd.equals("Open"))
			        {
			        	AccountLogic.view();	     
			        }
				}
			});
			
			
			JButton btnTransferMoney = new JButton("Transfera bani");
			btnTransferMoney.setBounds(45, 310, 130, 34);
			btnTransferMoney.setActionCommand("Open");
			firstPanel.add(btnTransferMoney);
			
			btnTransferMoney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_10.getText().equals("")|| !Pattern.matches("[0-9]+", textField_10.getText()))
						JOptionPane.showMessageDialog(null, "Invalid source account id");
					else if(textField_11.getText().equals("")|| !Pattern.matches("[0-9]+", textField_11.getText()))
						JOptionPane.showMessageDialog(null, "Invalid destination account id");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else {
							int id_s=Integer.parseInt(textField_10.getText());
							int id_d=Integer.parseInt(textField_11.getText());
							int s=Integer.parseInt(textField_8.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountLogic.searchByID(id_s)==true && AccountLogic.searchByID(id_d)==true)
					            {
					        		AccountLogic.transfer(id_s,id_d,s);
					                JOptionPane.showMessageDialog(null, "Transfer terminat cu succes");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Contul nu exista.");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" a facut un transfer din "+id_s+" to "+id_d+" in valore de "+s+" la data de: "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}					        	
					        }
					}
				}
			});
			
			
			JButton btnProcessBills = new JButton("Plateste facturi");
			btnProcessBills.setBounds(45, 350, 130, 34);
			btnProcessBills.setActionCommand("Open");
			firstPanel.add(btnProcessBills);
			
			btnProcessBills.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					int id=0,s=0;
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else {id=Integer.parseInt(textField_5.getText());
				    	  if(textField_12.getText().equals("") || !Pattern.matches("[0-9]+", textField_12.getText()))
				    		  JOptionPane.showMessageDialog(null, "Invalid amount of money");
				    	  else {s=Integer.parseInt(textField_12.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountLogic.searchByID(id)==true)
					            {
					        		AccountLogic.plataFacturi(id,s);
					                JOptionPane.showMessageDialog(null, "Plata terminata cu succes");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Cont inexistent");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" a platit factura "+s+" pentru contul "+id+" la data : "+new Date());
								    writer.close();
								} catch (IOException ee) {
									 System.out.println(ee);
								}					        	
					        }
				    	  }
					}
				}
			});
			
			
			
			JButton btnLogout = new JButton("Delogara");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					 if(cmd.equals("Open"))
				        {
							dispose();
							try{
							    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
							    writer.println(username+" s-a delogat la : "+new Date());
							    writer.close();
							} catch (IOException ee) {
								
							  System.out.println(ee);
							}							
				            new GenerateInterface();
				        }
				}
			});
			btnLogout.setBounds(180, 500, 130, 25);
			btnLogout.setActionCommand("Open");
			firstPanel.add(btnLogout);
			
			JLabel lblNewLabel = new JLabel("Id-ul clientului");
			lblNewLabel.setBounds(240, 30, 46, 18);
			firstPanel.add(lblNewLabel);
			
			idField = new JTextField();
			idField.setBounds(357, 27, 123, 20);
			firstPanel.add(idField);
			idField.setColumns(10);
			
			JLabel lblName = new JLabel("Nume");
			lblName.setBounds(240, 64, 46, 14);
			firstPanel.add(lblName);
			
			numeField = new JTextField();
			numeField.setBounds(357, 61, 123, 20);
			firstPanel.add(numeField);
			numeField.setColumns(10);
			
			JLabel lblCardNumber = new JLabel("Nr. card");
			lblCardNumber.setBounds(240, 98, 78, 14);
			firstPanel.add(lblCardNumber);
			
			cardNbField = new JTextField();
			cardNbField.setBounds(357, 95, 123, 20);
			firstPanel.add(cardNbField);
			cardNbField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CNP-ul");
			lblNewLabel_1.setBounds(240, 132, 46, 14);
			firstPanel.add(lblNewLabel_1);
			
			cnpField = new JTextField();
			cnpField.setBounds(357, 129, 123, 20);
			firstPanel.add(cnpField);
			cnpField.setColumns(10);
			
			JLabel lblAddress = new JLabel("Adresa");
			lblAddress.setBounds(240, 166, 66, 14);
			firstPanel.add(lblAddress);
			
			adresaField = new JTextField();
			adresaField.setBounds(357, 163, 123, 20);
			firstPanel.add(adresaField);
			adresaField.setColumns(10);
			
			JLabel lblIdAccount = new JLabel("Id cont bancar");
			lblIdAccount.setBounds(240, 200, 66, 14);
			firstPanel.add(lblIdAccount);
			
			textField_5 = new JTextField();
			textField_5.setBounds(357, 197, 123, 20);
			firstPanel.add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Nr card");
			lblNewLabel_2.setBounds(240, 236, 46, 14);
			firstPanel.add(lblNewLabel_2);
			
			textField_6 = new JTextField();
			textField_6.setBounds(357, 233, 123, 20);
			firstPanel.add(textField_6);
			textField_6.setColumns(10);
			
			JLabel lblType = new JLabel("Tip cont");
			lblType.setBounds(240, 273, 46, 14);
			firstPanel.add(lblType);
			
			textField_7 = new JTextField();
			textField_7.setBounds(357, 270, 123, 20);
			firstPanel.add(textField_7);
			textField_7.setColumns(10);
			
			JLabel lblMoney = new JLabel("Soldul contului");
			lblMoney.setBounds(240, 312, 46, 16);
			firstPanel.add(lblMoney);
			
			textField_8 = new JTextField();
			textField_8.setBounds(357, 309, 123, 20);
			firstPanel.add(textField_8);
			textField_8.setColumns(10);
			
			JLabel lblDate = new JLabel("Data ");
			lblDate.setBounds(240, 351, 46, 14);
			firstPanel.add(lblDate);
			
			textField_9 = new JTextField();
			textField_9.setBounds(357, 348, 123, 20);
			firstPanel.add(textField_9);
			textField_9.setColumns(10);
			
			JLabel lblsa = new JLabel("Cont transfer");
			lblsa.setBounds(240, 390, 96, 14);
			firstPanel.add(lblsa);
			
			textField_10 = new JTextField();
			textField_10.setBounds(357, 387, 123, 20);
			firstPanel.add(textField_10);
			textField_10.setColumns(10);
			
			JLabel lblda = new JLabel("Cont de transferat");
			lblda.setBounds(240, 429, 116, 14);
			firstPanel.add(lblda);
			
			textField_11 = new JTextField();
			textField_11.setBounds(357, 426, 123, 20);
			firstPanel.add(textField_11);
			textField_11.setColumns(10);
			
			JLabel lblba = new JLabel("Valoarea facturii");
			lblba.setBounds(240, 468, 116, 14);
			firstPanel.add(lblba);
				
			textField_12 = new JTextField();
			textField_12.setBounds(357, 465, 123, 20);
			firstPanel.add(textField_12);
			textField_12.setColumns(10);

	        setVisible(true);
	    }
}