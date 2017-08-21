package prabandh;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import database.schema.ACCOUNT;
import upyog.query.DeleteQuery;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.Data;
import upyog.query.SelectQuery;
import upyog.query.UpdateQuery;
import vasthu.Account;
import vasthu.Contact;
import vasthu.Saree;
import vasthu.Transaction;
public class Prabandh {

	public static void main(String[] args) {
		
		Transaction transactionObj = new Transaction();
		
		//INSERT RECORDS
		ArrayList<HashMap<String,Object>> transactions = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> transaction = new HashMap<String,Object>();
		transaction.put("Transaction Date","2017-09-29");
		transaction.put("Transaction Type", "BUY");
		transaction.put("Item ID", 16);
		transaction.put("Quantity", 3);
		transaction.put("Transaction Amount", 3000);
		transaction.put("Account ID", 1);
		transaction.put("Buyer", 1);
		transaction.put("Seller", 3);
		
		transactions.add(transaction);

		
		transaction = new HashMap<String,Object>();
		transaction.put("Transaction Date","2017-09-30");
		transaction.put("Transaction Type", "SELL");
		transaction.put("Item ID", 15);
		transaction.put("Quantity", 2);
		transaction.put("Transaction Amount", 4000.00);
		transaction.put("Account ID", 1);
		transaction.put("Buyer", 4);
		transaction.put("Seller", 1);
			
		transactions.add(transaction);
		
		transaction = new HashMap<String,Object>();
		transaction.put("Transaction Date","2017-09-30");
		transaction.put("Transaction Type", "SELL");
		transaction.put("Item ID", 16);
		transaction.put("Quantity", 1);
		transaction.put("Transaction Amount", 1200.00);
		transaction.put("Account ID", 1);
		transaction.put("Buyer", 6);
		transaction.put("Seller", 1);
			
		transactions.add(transaction);
		//int rs = transactionObj.insertTransaction(transaction);
		int rs = transactionObj.insertTransactions(transactions);
		if(rs>0)
		{
			System.out.println(rs+" Transaction(s) inserted successfully");
		}
		
		
		
		//UPDATE RECORDS
//		ArrayList<HashMap<String,Object>> contacts = new ArrayList<HashMap<String,Object>>();
//		HashMap<String,Object> contact = new HashMap<String,Object>();
//		contact.put("Primary Phone", "+91 23565444");
//		contact.put("Secondary Phone", "+9 44653");
//		contact.put("Email", "newcontact2@company2.com");
//		contacts.add(contact);
//		int rs = contactObj.updateContact(9, contact);
//		if(rs>0)
//		{
//			System.out.println(rs+" Contact(s) updated successfully");
//		}
		
		
		//DELETE RECORDS
//		ArrayList<Integer> deleteList = new ArrayList<Integer>();
//		deleteList.add(5);
//		deleteList.add(7);
//		deleteList.add(10);
//		int rs = contactObj.deleteContacts(deleteList);
//		if(rs>0)
//		{
//			System.out.println(rs+" Contact(s) deleted successfully");
//		}
		

	}

}
