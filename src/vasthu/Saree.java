package vasthu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.schema.SAREE;
import upyog.Data;
import upyog.Field;
import upyog.query.DeleteQuery;
import upyog.query.InsertQuery;
import upyog.query.Query;
import upyog.query.UpdateQuery;

public class Saree {

	
	Field sareeFieldObj;
	
	private Field getSareeFieldObject()
	{
		if(sareeFieldObj==null)
		{
			sareeFieldObj = new Field(SAREE.TABLE);
		}
		return sareeFieldObj;
	}
	
	public int insertSaree(HashMap<String,Object> saree)
	{
		ArrayList<HashMap<String,Object>> sarees = new ArrayList<HashMap<String,Object>>();
		sarees.add(saree);
		return (insertSarees(sarees));
	}
	public int insertSarees(ArrayList<HashMap<String,Object>> sarees)
	{
		Data data = new Data();
		Field fieldObj = this.getSareeFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		InsertQuery iq  = new InsertQuery();
		iq.setInsertTableName(SAREE.TABLE);
		for(HashMap<String,Object> saree : sarees)
		{
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			for(Map.Entry<String, Object> sareeEntry : saree.entrySet())
			{
				String fieldLabel = sareeEntry.getKey();
				Object value = sareeEntry.getValue();
				if(fieldLabelVsColumnMap.containsKey(fieldLabel))
				{
					String columnName = fieldLabelVsColumnMap.get(fieldLabel);
					Query.Column column = query.new Column(SAREE.TABLE,columnName);
					insertRow.put(column, value);
				}
			}
			iq.addInsertEntry(insertRow);
		}
		return data.insertData(iq);
	}
	
	public int updateSaree(int sareeId, HashMap<String,Object> saree)
	{
		Data data = new Data();
		Field fieldObj = this.getSareeFieldObject();
		HashMap<String,String> fieldLabelVsColumnMap = fieldObj.getFieldLabelVsColumnMap();
		Query query = new Query();
		UpdateQuery uq = new UpdateQuery();
		uq.setUpdateTableName(SAREE.TABLE);
		for(Map.Entry<String, Object> sareeEntry : saree.entrySet())
		{
			String fieldLabel = sareeEntry.getKey();
			Object value = sareeEntry.getValue();
			if(fieldLabelVsColumnMap.containsKey(fieldLabel))
			{
				String columnName = fieldLabelVsColumnMap.get(fieldLabel);
				Query.Column column = query.new Column(SAREE.TABLE,columnName);
				uq.setValueForColumn(column, value);
			}
		}
		Query.Criteria upCr = query.new Criteria(query.new Column(SAREE.TABLE,SAREE.SAREE_ID),sareeId,Query.comparison_operators.EQUAL_TO);
		uq.setCriteria(upCr);	
		return data.updateData(uq);
	}
	
	public int deleteSaree(int sareeId)
	{
		ArrayList<Integer> sareeIds = new ArrayList<Integer>();
		sareeIds.add(sareeId);
		return deleteSarees(sareeIds);
	}
	public int deleteSarees(ArrayList<Integer> sareeIds)
	{
		Data data = new Data();
		Query query = new Query();
		DeleteQuery dq = new DeleteQuery();
		dq.setDeleteTableName(SAREE.TABLE);
		Query.Criteria dlCr = query.new Criteria(query.new Column(SAREE.TABLE,SAREE.SAREE_ID),sareeIds,Query.comparison_operators.IN);
		dq.setDeleteCriteria(dlCr);
		return data.deleteData(dq);
	}
	

}
