package upyog;

import java.util.ArrayList;

public class SelectQuery {
	private ArrayList<Query.Column> selectColumns;
	private ArrayList<Query.Join> joins;
	private Query.Criteria criteria;
	private String orderBy;
	private String groupBy;
	
	public static enum order
	{
		ASC,DESC;
	}
	
	public static enum aggregate_functions 
	{
		MIN,MAX,SUM,AVG,COUNT;
	}
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
	public void setOrderBy(ArrayList<Query.Column> orderByColumns, String order)
	{
		orderBy = "ORDER BY";
		int arrLen = orderByColumns.size();
		int cnt = 1;
		for(Query.Column orderByColumn : orderByColumns)
		{
			orderBy+=" "+orderByColumn.getColumnString();
			if(cnt!=arrLen)
			{
				orderBy+=",";
			}
			cnt++;
		}
		if(order!=null)
		{
			orderBy+=" "+order;
		}
		else
		{
			orderBy+=" "+SelectQuery.order.ASC;
		}
	}
	
	public void setGroupBy(ArrayList<Query.Column> groupByColumns)
	{
		groupBy = "GROUP BY";
		int arrLen = groupByColumns.size();
		int cnt = 1;
		for(Query.Column groupByColumn : groupByColumns)
		{
			groupBy+=" "+groupByColumn.getColumnString();
			if(cnt!=arrLen)
			{
				groupBy+=",";
			}
			cnt++;
		}
	}
	
	
}
