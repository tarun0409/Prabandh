package vasthu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.schema.CONTACT;
import upyog.Data;
import upyog.Field;
import upyog.query.DeleteQuery;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.query.UpdateQuery;

public class Contact {
	
	Field contactFieldObj;
	
	private Field getContactFieldObject()
	{
		if(contactFieldObj==null)
		{
			contactFieldObj = new Field(CONTACT.TABLE);
		}
		return contactFieldObj;
	}
	
	public int insertContact(HashMap<String,Object> contact)
	{
		ArrayList<HashMap<String,Object>> contacts = new ArrayList<HashMap<String,Object>>();
		contacts.add(contact);
		return (insertContacts(contacts));
	}
	public int insertContacts(ArrayList<HashMap<String,Object>> contacts)
	{
		Data data = new Data();
		Field fieldObj = this.getContactFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		InsertQuery iq  = new InsertQuery();
		iq.setInsertTableName(CONTACT.TABLE);
		for(HashMap<String,Object> contact : contacts)
		{
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			for(Map.Entry<String, Object> contactEntry : contact.entrySet())
			{
				String fieldLabel = contactEntry.getKey();
				Object value = contactEntry.getValue();
				if(fieldLabelVsColumnMap.containsKey(fieldLabel))
				{
					String columnName = fieldLabelVsColumnMap.get(fieldLabel);
					Query.Column column = query.new Column(CONTACT.TABLE,columnName);
					insertRow.put(column, value);
				}
			}
			iq.addInsertEntry(insertRow);
		}
		return data.insertData(iq);
	}
	
	public int updateContact(int contactId, HashMap<String,Object> contact)
	{
		Data data = new Data();
		Field fieldObj = this.getContactFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		UpdateQuery uq = new UpdateQuery();
		uq.setUpdateTableName(CONTACT.TABLE);
		for(Map.Entry<String, Object> contactEntry : contact.entrySet())
		{
			String fieldLabel = contactEntry.getKey();
			Object value = contactEntry.getValue();
			if(fieldLabelVsColumnMap.containsKey(fieldLabel))
			{
				String columnName = fieldLabelVsColumnMap.get(fieldLabel);
				Query.Column column = query.new Column(CONTACT.TABLE,columnName);
				uq.setValueForColumn(column, value);
			}
		}
		Query.Criteria upCr = query.new Criteria(query.new Column(CONTACT.TABLE,CONTACT.CONTACT_ID),contactId,Query.comparison_operators.EQUAL_TO);
		uq.setCriteria(upCr);	
		return data.updateData(uq);
	}
	
	public int deleteContact(int contactId)
	{
		ArrayList<Integer> contactIds = new ArrayList<Integer>();
		contactIds.add(contactId);
		return deleteContacts(contactIds);
	}
	public int deleteContacts(ArrayList<Integer> contactIds)
	{
		Data data = new Data();
		Query query = new Query();
		DeleteQuery dq = new DeleteQuery();
		dq.setDeleteTableName(CONTACT.TABLE);
		Query.Criteria dlCr = query.new Criteria(query.new Column(CONTACT.TABLE,CONTACT.CONTACT_ID),contactIds,Query.comparison_operators.IN);
		dq.setDeleteCriteria(dlCr);
		return data.deleteData(dq);
	}

}
