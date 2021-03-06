package upyog;


import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import database.schema.FIELD;
import upyog.query.Query;
import upyog.query.SelectQuery;

public class Field {
	
	private JSONArray fields;
	private HashMap<String,String> fieldLabelVsColumnMap;
	public static int TRUE = 1;
	public static int FALSE = 0;
	public static SelectQuery getSelectQueryForField()
	{
		SelectQuery sq = new SelectQuery();
		Query query = new Query();
		sq.addSelectColumn(query.new Column(FIELD.TABLE,FIELD.FIELD_ID));
		sq.addSelectColumn(query.new Column(FIELD.TABLE,FIELD.TABLE_NAME));
		sq.addSelectColumn(query.new Column(FIELD.TABLE,FIELD.COLUMN_NAME));
		sq.addSelectColumn(query.new Column(FIELD.TABLE,FIELD.FIELD_LABEL));
		return sq;
	}
	
	public Field()
	{
		Data data = new Data();
		data.setDataType("json");
		SelectQuery sq = getSelectQueryForField();
		JSONObject fieldInfo = (JSONObject)data.getData(sq);
		try
		{
			if(fieldInfo!=null && fieldInfo.has(FIELD.TABLE))
			{
				this.fields = fieldInfo.getJSONArray(FIELD.TABLE);
			}
		}
		catch(JSONException je)
		{
			System.out.println("Something went wrong in fetching fields data \n"+je.getMessage()+"\n");
			je.printStackTrace();
		}
	}
	public Field(String tableName)
	{
		Data data = new Data();
		data.setDataType("json");
		SelectQuery sq = getSelectQueryForField();
		Query query = new Query();
		Query.Criteria fieldCr = query.new Criteria(query.new Column(FIELD.TABLE,FIELD.TABLE_NAME),tableName,Query.comparison_operators.EQUAL_TO);
		sq.setCriteria(fieldCr);
		JSONObject fieldInfo = (JSONObject)data.getData(sq);
		try
		{
			if(fieldInfo!=null && fieldInfo.has(FIELD.TABLE))
			{
				this.fields = fieldInfo.getJSONArray(FIELD.TABLE);
			}
		}
		catch(JSONException je)
		{
			System.out.println("Something went wrong in fetching fields data \n"+je.getMessage()+"\n");
			je.printStackTrace();
		}
	}
	public HashMap<String,String> getFieldLabelVsColumnMap()
	{
		if(this.fieldLabelVsColumnMap==null)
		{
			this.fieldLabelVsColumnMap = new HashMap<String,String>();
			try
			{
				for(int i=0; i<this.fields.length(); i++)
				{
					JSONObject field = fields.getJSONObject(i);
					String fieldLabel = field.getString(FIELD.FIELD_LABEL);
					String columnName = field.getString(FIELD.COLUMN_NAME);
					this.fieldLabelVsColumnMap.put(fieldLabel, columnName);
				}
			}
			catch(JSONException je)
			{
				System.out.println(je.getMessage()+"\n");
				je.printStackTrace();
			}
		}
		return this.fieldLabelVsColumnMap;
	}

}
