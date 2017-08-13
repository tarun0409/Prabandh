package prabandh;

import org.json.JSONObject;

import database.Table;
import upyog.Data;
import upyog.Query;
import upyog.SelectQuery;
public class Prabandh {

	public static void main(String[] args) {
		
		Data data = new Data();
		data.setDataType("json");
		SelectQuery sq = new SelectQuery();
		Query query = new Query();
		sq.addSelectColumn(query.new Column(""+Table.Tables.ACCOUNT, Table.Account.ACCOUNT_ID));
		sq.addSelectColumn(query.new Column(""+Table.Tables.ACCOUNT, Table.Account.ACCOUNT_BALANCE));
		sq.addSelectColumn(query.new Column(""+Table.Tables.ACCOUNT, Table.Account.ACCOUNT_NAME));
		sq.addSelectColumn(query.new Column(""+Table.Tables.ACCOUNT, Table.Account.ACCOUNT_MANAGER));
		sq.addSelectColumn(query.new Column(""+Table.Tables.ACCOUNT, Table.Account.ACCOUNT_OWNER));
		JSONObject myData = (JSONObject)data.getData(sq);
		System.out.println(myData.toString());

	}

}
