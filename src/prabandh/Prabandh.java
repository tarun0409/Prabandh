package prabandh;

import java.util.HashMap;

import org.json.JSONObject;

import database.schema.ACCOUNT;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.Data;
import upyog.query.SelectQuery;
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
		

	}

}
