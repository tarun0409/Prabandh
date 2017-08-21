package vasthu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.schema.TRANSACTION;
import upyog.Data;
import upyog.Field;
import upyog.query.DeleteQuery;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.query.UpdateQuery;

public class Transaction {

Field transactionFieldObj;
	
	private Field getTransactionFieldObject()
	{
		if(transactionFieldObj==null)
		{
			transactionFieldObj = new Field(TRANSACTION.TABLE);
		}
		return transactionFieldObj;
	}
	
	public int insertTransaction(HashMap<String,Object> transaction)
	{
		ArrayList<HashMap<String,Object>> transactions = new ArrayList<HashMap<String,Object>>();
		transactions.add(transaction);
		return (insertTransactions(transactions));
	}
	public int insertTransactions(ArrayList<HashMap<String,Object>> transactions)
	{
		Data data = new Data();
		Field fieldObj = this.getTransactionFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		InsertQuery iq  = new InsertQuery();
		iq.setInsertTableName(TRANSACTION.TABLE);
		for(HashMap<String,Object> transaction : transactions)
		{
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			for(Map.Entry<String, Object> transactionEntry : transaction.entrySet())
			{
				String fieldLabel = transactionEntry.getKey();
				Object value = transactionEntry.getValue();
				if(fieldLabelVsColumnMap.containsKey(fieldLabel))
				{
					String columnName = fieldLabelVsColumnMap.get(fieldLabel);
					Query.Column column = query.new Column(TRANSACTION.TABLE,columnName);
					insertRow.put(column, value);
				}
			}
			iq.addInsertEntry(insertRow);
		}
		return data.insertData(iq);
	}
	
	public int updateTransaction(int transactionId, HashMap<String,Object> transaction)
	{
		Data data = new Data();
		Field fieldObj = this.getTransactionFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		UpdateQuery uq = new UpdateQuery();
		uq.setUpdateTableName(TRANSACTION.TABLE);
		for(Map.Entry<String, Object> transactionEntry : transaction.entrySet())
		{
			String fieldLabel = transactionEntry.getKey();
			Object value = transactionEntry.getValue();
			if(fieldLabelVsColumnMap.containsKey(fieldLabel))
			{
				String columnName = fieldLabelVsColumnMap.get(fieldLabel);
				Query.Column column = query.new Column(TRANSACTION.TABLE,columnName);
				uq.setValueForColumn(column, value);
			}
		}
		Query.Criteria upCr = query.new Criteria(query.new Column(TRANSACTION.TABLE,TRANSACTION.TRANSACTION_ID),transactionId,Query.comparison_operators.EQUAL_TO);
		uq.setCriteria(upCr);	
		return data.updateData(uq);
	}
	
	public int deleteTransaction(int transactionId)
	{
		ArrayList<Integer> transactionIds = new ArrayList<Integer>();
		transactionIds.add(transactionId);
		return deleteTransactions(transactionIds);
	}
	public int deleteTransactions(ArrayList<Integer> transactionIds)
	{
		Data data = new Data();
		Query query = new Query();
		DeleteQuery dq = new DeleteQuery();
		dq.setDeleteTableName(TRANSACTION.TABLE);
		Query.Criteria dlCr = query.new Criteria(query.new Column(TRANSACTION.TABLE,TRANSACTION.TRANSACTION_ID),transactionIds,Query.comparison_operators.IN);
		dq.setDeleteCriteria(dlCr);
		return data.deleteData(dq);
	}
}
