package businessLogic;

import dbAccess.Account;
import dbAccess.AccountGW;

public class AccountLogic {

		public static synchronized void inserare(int id,int number,String type,int money,String date, int clid)
		{
			Account.insert(id,number,type,money,date,clid);
		}
		public static synchronized void update(int id,int number,String type,int money,String date, int clid) {
			Account.update(id,number,type,money,date,clid);
		}
		public static synchronized void stergere(int id) {
			AccountGW.delete(id);
		}
		public static synchronized void view()
		{
			AccountGW.view();
		}
		public static synchronized void transfer(int id_s,int id_d, int amount)
		{
			AccountGW.transfer(id_s,id_d,amount);
		}
		public static synchronized void plataFacturi(int id,int amount)
		{
			 AccountGW.doBills(id,amount);
		}
		public static synchronized boolean searchByID(int id) {
			return AccountGW.find(id);
		}
}