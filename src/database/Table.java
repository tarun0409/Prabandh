package database;


public class Table {

	public static enum Tables
	{
		ACCOUNT;
	}
	public static class Account 
	{
		public static String ACCOUNT_ID = "ACCOUNT_ID";
		public static String ACCOUNT_NAME = "ACCOUNT_NAME";
		public static String ACCOUNT_OWNER = "ACCOUNT_OWNER";
		public static String ACCOUNT_MANAGER = "ACCOUNT_MANAGER";
		public static String ACCOUNT_BALANCE = "ACCOUNT_BALANCE";
		public static String NOTES = "NOTES";
	}
}
