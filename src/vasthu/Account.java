package vasthu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.schema.ACCOUNT;
import upyog.Data;
import upyog.Field;
import upyog.query.DeleteQuery;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.query.UpdateQuery;

public class Account {
	
	Field accountFieldObj;
	
	private Field getAccountFieldObject()
	{
		if(accountFieldObj==null)
		{
			accountFieldObj = new Field(ACCOUNT.TABLE);
		}
		return accountFieldObj;
	}
	
	public int insertAccount(HashMap<String,Object> account)
	{
		ArrayList<HashMap<String,Object>> accounts = new ArrayList<HashMap<String,Object>>();
		accounts.add(account);
		return (insertAccounts(accounts));
	}
	public int insertAccounts(ArrayList<HashMap<String,Object>> accounts)
	{
		Data data = new Data();
		Field fieldObj = this.getAccountFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		InsertQuery iq  = new InsertQuery();
		iq.setInsertTableName(ACCOUNT.TABLE);
		for(HashMap<String,Object> account : accounts)
		{
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			for(Map.Entry<String, Object> accountEntry : account.entrySet())
			{
				String fieldLabel = accountEntry.getKey();
				Object value = accountEntry.getValue();
				if(fieldLabelVsColumnMap.containsKey(fieldLabel))
				{
					String columnName = fieldLabelVsColumnMap.get(fieldLabel);
					Query.Column column = query.new Column(ACCOUNT.TABLE,columnName);
					insertRow.put(column, value);
				}
			}
			iq.addInsertEntry(insertRow);
		}
		return data.insertData(iq);
	}
	
	public int updateAccount(int accountId, HashMap<String,Object> account)
	{
		Data data = new Data();
		Field fieldObj = this.getAccountFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		UpdateQuery uq = new UpdateQuery();
		uq.setUpdateTableName(ACCOUNT.TABLE);
		for(Map.Entry<String, Object> accountEntry : account.entrySet())
		{
			String fieldLabel = accountEntry.getKey();
			Object value = accountEntry.getValue();
			if(fieldLabelVsColumnMap.containsKey(fieldLabel))
			{
				String columnName = fieldLabelVsColumnMap.get(fieldLabel);
				Query.Column column = query.new Column(ACCOUNT.TABLE,columnName);
				uq.setValueForColumn(column, value);
			}
		}
		Query.Criteria upCr = query.new Criteria(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_ID),accountId,Query.comparison_operators.EQUAL_TO);
		uq.setCriteria(upCr);	
		return data.updateData(uq);
	}
	
	public int deleteAccount(int accountId)
	{
		ArrayList<Integer> accountIds = new ArrayList<Integer>();
		accountIds.add(accountId);
		return deleteAccounts(accountIds);
	}
	public int deleteAccounts(ArrayList<Integer> accountIds)
	{
		Data data = new Data();
		Query query = new Query();
		DeleteQuery dq = new DeleteQuery();
		dq.setDeleteTableName(ACCOUNT.TABLE);
		Query.Criteria dlCr = query.new Criteria(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_ID),accountIds,Query.comparison_operators.IN);
		dq.setDeleteCriteria(dlCr);
		return data.deleteData(dq);
	}
	
}
