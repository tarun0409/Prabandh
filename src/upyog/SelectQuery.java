package upyog;

import java.util.ArrayList;

public class SelectQuery {
	ArrayList<Query.Column> selectColumns;
	ArrayList<Query.Join> joins;
	Query.Criteria criteria;
	
	public SelectQuery()
	{
		selectColumns = new ArrayList<Query.Column>();
		joins = new ArrayList<Query.Join>();
	}
	public void addSelectColumn(Query.Column column)
	{
		selectColumns.add(column);
	}
	public void addSelectColumns(ArrayList<Query.Column> columns)
	{
		for(Query.Column column : columns)
		{
			if(!selectColumns.contains(column))
			{
				selectColumns.add(column);
			}
		}
	}
}
