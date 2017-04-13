package businessLogic;

import dbAccess.Customer;

public class CustomerLogic {
	public static synchronized void insert(int id,String name, int cardnumber,String cnp, String address)
	{
		Customer.insert(id,name,cardnumber, cnp, address);
	}
	public static synchronized void update(int id,String name, int cardnumber,String cnp, String address) {
		Customer.update(id,name,cardnumber,cnp, address);
	}
	public static synchronized void view()
	{
		Customer.view();
	}
	public static synchronized boolean find(int id) {
		return Customer.find(id);
	}
}