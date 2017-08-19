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
public class Prabandh {

	public static void main(String[] args) {
		
		Contact contactObj = new Contact();
		
		//INSERT RECORDS
//		ArrayList<HashMap<String,Object>> contacts = new ArrayList<HashMap<String,Object>>();
//		HashMap<String,Object> contact = new HashMap<String,Object>();
//		contact.put("Contact Name", "NewContact2");
//		contact.put("Primary Phone", "+991 23565444");
//		contact.put("Secondary Phone", "+99 446534");
//		contact.put("Email", "newcontact2@company1.com");
//		contacts.add(contact);
//		contact = new HashMap<String,Object>();
//		contact.put("Contact Name", "NewContact3");
//		contact.put("Primary Phone", "+991 2345844");
//		contact.put("Secondary Phone", "+99 432434");
//		contact.put("Email", "newcontact3@company1.com");
//		contacts.add(contact);
//		contact = new HashMap<String,Object>();
//		contact.put("Contact Name", "NewContact4");
//		contact.put("Primary Phone", "+991 2345844");
//		contact.put("Secondary Phone", "+99 432434");
//		contact.put("Email", "newcontact4@company1.com");
//		contacts.add(contact);
//		//int rs = contactObj.insertContact(contact);
//		int rs = contactObj.insertContacts(contacts);
//		if(rs>0)
//		{
//			System.out.println(rs+" Contact(s) inserted successfully");
//		}
		
		
		
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
