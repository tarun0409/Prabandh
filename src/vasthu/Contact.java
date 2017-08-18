package vasthu;

import java.util.ArrayList;
import java.util.HashMap;

import database.schema.CONTACT;
import upyog.Data;
import upyog.query.InsertQuery;
import upyog.query.Query;

public class Contact {
	
	private String contactName;
	private String phonePrimary;
	private String phoneSecondary;
	private String emailID;
	private String addressPrimary;
	private String addressSecondary;
	private String notes;
	
	public Contact() {}
	
	public Contact(String contactName, String phonePrimary, String phoneSecondary, String emailID, String addressPrimary, String addressSecondary, String notes)
	{
		this.contactName = contactName;
		this.phonePrimary = phonePrimary;
		this.phoneSecondary = phoneSecondary;
		this.emailID = emailID;
		this.addressPrimary = addressPrimary;
		this.addressSecondary = addressSecondary;
		this.notes = notes;
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhonePrimary() {
		return phonePrimary;
	}
	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}
	public String getPhoneSecondary() {
		return phoneSecondary;
	}
	public void setPhoneSecondary(String phoneSecondary) {
		this.phoneSecondary = phoneSecondary;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getAddressPrimary() {
		return addressPrimary;
	}
	public void setAddressPrimary(String addressPrimary) {
		this.addressPrimary = addressPrimary;
	}
	public String getAddressSecondary() {
		return addressSecondary;
	}
	public void setAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public static int insertContact(String contactName, String phonePrimary, String phoneSecondary, String emailID, String addressPrimary, String addressSecondary, String notes)
	{
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(contactName,phonePrimary,phoneSecondary,emailID,addressPrimary,addressSecondary,notes));
		int rs = insertContacts(contacts);
		return rs;
	}
	public int insertContact()
	{
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(this);
		int rs = insertContacts(contacts);
		return rs;
	}
	public static int insertContacts(ArrayList<Contact> contacts)
	{
		Data data = new Data();
		Query query = new Query();
		InsertQuery iq = new InsertQuery();
		for(Contact contact : contacts)
		{
			if(contact.contactName==null)
			{
				System.out.println("Unable to insert account. Check if any of mandatory values are null!");
				break;
			}
			iq.setInsertTableName(CONTACT.TABLE);
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.CONTACT_NAME),contact.contactName);
			if(contact.phonePrimary!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.PHONE_PRIMARY),contact.phonePrimary);
			}
			if(contact.phoneSecondary!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.PHONE_SECONDARY),contact.phoneSecondary);
			}
			if(contact.emailID!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.EMAIL_ID),contact.emailID);
			}
			if(contact.addressPrimary!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.ADDRESS_PRIMARY),contact.addressPrimary);
			}
			if(contact.addressSecondary!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.ADDRESS_SECONDARY),contact.addressSecondary);
			}
			if(contact.notes!=null)
			{
				insertRow.put(query.new Column(CONTACT.TABLE,CONTACT.NOTES),contact.notes);
			}
			iq.addInsertEntry(insertRow);
		}
		int rs = data.insertData(iq);
		if(rs>0)
		{
			System.out.println(rs+" record(s) inserted successfully");
		}
		return rs;
	}

}
