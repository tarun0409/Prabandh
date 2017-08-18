package prabandh;

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
		
		Data data = new Data();
		data.setDataType("json");
		
		
		//SELECT QUERY
//		SelectQuery sq = new SelectQuery();
//		Query query = new Query();
//		sq.addSelectColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_ID));
//		sq.addSelectColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_BALANCE));
//		sq.addSelectColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME));
//		sq.addSelectColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER));
//		sq.addSelectColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_OWNER));
//		JSONObject myData = (JSONObject)data.getData(sq);
//		System.out.println(myData.toString());
		
		
		//INSERT QUERY
//		Query query = new Query();
//		InsertQuery iq  = new InsertQuery();
//		iq.setInsertTableName(ACCOUNT.TABLE);
//		HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME),"InsertedAccount1");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_OWNER),"InsertedAccount1Owner");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER),"InsertedAccount1Manager");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_BALANCE),3950.50);
//		iq.addInsertEntry(insertRow);
//		insertRow = new HashMap<Query.Column,Object>();
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME),"InsertedAccount2");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_OWNER),"InsertedAccount2Owner");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER),"InsertedAccount2Manager");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_BALANCE),3850.70);
//		iq.addInsertEntry(insertRow);
//		insertRow = new HashMap<Query.Column,Object>();
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME),"InsertedAccount3");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_OWNER),"InsertedAccount3Owner");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER),"InsertedAccount3Manager");
//		insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_BALANCE),3750.70);
//		iq.addInsertEntry(insertRow);
//		data.insertData(iq);
		//System.out.println(insertRes.toString());
		
		
		//UPDATE QUERY
//		Query query = new Query();
//		UpdateQuery uq = new UpdateQuery();
//		uq.setUpdateTableName(ACCOUNT.TABLE);
//		uq.setValueForColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME),"UpdatedAccountName2");
//		uq.setValueForColumn(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER),"UpdatedAccountManager2");
//		Query.Criteria cr = query.new Criteria(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_ID),10,Query.comparison_operators.EQUAL_TO);
//		uq.setCriteria(cr);
//		int rs = data.updateData(uq);
//		if(rs>0)
//		{
//			System.out.println(rs+" record(s) updated successfully!");
//		}
		
		
		//DELETE QUERY
//		Query query = new Query();
//		DeleteQuery dq = new DeleteQuery();
//		dq.setDeleteTableName(ACCOUNT.TABLE);
//		Query.Criteria dcr = query.new Criteria(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_ID),6,Query.comparison_operators.EQUAL_TO);
//		dq.setDeleteCriteria(dcr);
//		int rs = data.deleteData(dq);
//		if(rs>0)
//		{
//			System.out.println(rs+" record(s) deleted successfully!");
//		}
		
		//Account.insertAccount("CustomAccount1", "CustomAccount1Owner", "CustomAccount1Manager", new Float(100.50), null);
		Contact.insertContact("InsertedPerson2", "5431", null, "ips2@sample.com", null, null, null);
		
		
		

	}

}
