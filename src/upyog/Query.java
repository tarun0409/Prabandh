package upyog;

import java.util.ArrayList;

public class Query {
	public static enum comparison_operators
	{
		EQUAL_TO("="),NOT_EQUAL_TO("!="),GREATER_THAN(">"),LESSER_THAN("<"),GREATER_THAN_EQUAL_TO(">="),LESSER_THAN_EQUAL_TO("<="),IN("IN"),NOT_IN("NOT IN"),LIKE("LIKE"),NOT_LIKE("NOT LIKE");
		private String operator;
		comparison_operators(String operator)
		{
			this.operator = operator;
		}
		public String operator()
		{
			return this.operator;
		}
	}
	public static enum logical_operators
	{
		AND,OR,NOT;
	}
	public class Column
	{
		private String columnString;
		private String tableName;
		private String columnName;
		private String aggregateFunctionName;
		public Column(String tableName, String columnName)
		{
			this.tableName = tableName;
			this.columnName = columnName;
			columnString = tableName+"."+columnName;
		}
		public void setAggregateFunction(String function)
		{
			this.aggregateFunctionName = function;
			columnString = function+"("+columnString+")";
		}
		public String getTableName()
		{
			return this.tableName;
		}
		public String getColumnName()
		{
			return this.columnName;
		}
		public String getAggregateFunctionName()
		{
			return this.aggregateFunctionName;
		}
		public String getColumnString()
		{
			return this.columnString;
		}
	}
	public class Criteria
	{
		private String criteriaString;
		public Criteria(Object operand1, Object operand2, String operator)
		{
			criteriaString = "";
			String operandString = getStringForObject(operand1);
			criteriaString+=operandString;
			criteriaString+=" "+operator;
			operandString = getStringForObject(operand2);
			criteriaString+=" "+operandString;
		}
		public Criteria and(Criteria cr)
		{
			if(cr==null)
			{
				return null;
			}
			String newCrStr = this.criteriaString;
			newCrStr="("+newCrStr;
			newCrStr = newCrStr+" "+logical_operators.AND;
			newCrStr = " "+cr.getCriteriaAsString();
			newCrStr+=")";
			this.criteriaString = newCrStr;
			return this;
		}
		public Criteria or(Criteria cr)
		{
			if(cr==null)
			{
				return null;
			}
			String newCrStr = this.criteriaString;
			newCrStr="("+newCrStr;
			newCrStr = newCrStr+" "+logical_operators.OR;
			newCrStr = " "+cr.getCriteriaAsString();
			newCrStr+=")";
			this.criteriaString = newCrStr;
			return this;
		}
		
		public Criteria not()
		{
			String newCrStr = this.criteriaString;
			newCrStr = "("+logical_operators.NOT+"("+newCrStr+"))";
			this.criteriaString = newCrStr;
			return this;
		}
		
		
		@SuppressWarnings("unchecked")
		public String getStringForObject(Object opObj)
		{
			if(opObj==null)
			{
				return null;
			}
			else if((opObj instanceof String) || (opObj instanceof Integer) || (opObj instanceof Boolean))
			{
				return opObj.toString();
			}
			else if(opObj instanceof ArrayList)
			{
				String str = "(";
				ArrayList<Object> arr = (ArrayList<Object>)opObj;
				int arrLen = arr.size();
				int cnt = 1;
				for(Object arrObj : arr)
				{
					String item = getStringForObject(arrObj);
					str += " "+item;
					if(cnt!=arrLen)
					{
						str+=",";
					}
					cnt++;
				}
				str+=")";
				return str;
			}
			return opObj.toString();
		}
		public String getCriteriaAsString()
		{
			return this.criteriaString;
		}
	}
	public class Join
	{
		private String table1;
		private String table2;
		private Query.Criteria joinCriteria;
		public Join(String table1, String table2, Criteria criteria)
		{
			this.table1 = table1;
			this.table2 = table2;
			if(criteria!=null)
			{
				this.joinCriteria = criteria;
			}
		}
		public String getJoinAsString()
		{
			String joinString = this.table1;
			joinString+=" JOIN ";
			joinString+=this.table2;
			if(this.joinCriteria!=null)
			{
				joinString+=" ON "+this.joinCriteria.getCriteriaAsString();
			}
			return joinString;
		}
		public String getJoinAsString(String baseTableName)
		{
			String joinString = "JOIN";
			String table1 = this.table1;
			String table2 = this.table2;
			if(baseTableName.equals(table1))
			{
				joinString+=" "+table2;
			}
			else if(baseTableName.equals(table2))
			{
				joinString+=" "+table1;
			}
			if(this.joinCriteria!=null)
			{
				joinString+=" ON "+this.joinCriteria.getCriteriaAsString();
			}
			return joinString;
		}
		public String getJoinTable1()
		{
			return this.table1;
		}
		public String getJoinTable2()
		{
			return this.table2;
		}
		public String getJoinCriteriaAsString()
		{
			return this.joinCriteria.getCriteriaAsString();
		}
		
	}
}
