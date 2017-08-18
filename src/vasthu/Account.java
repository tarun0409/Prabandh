package vasthu;

import java.util.ArrayList;
import java.util.HashMap;

import database.schema.ACCOUNT;
import upyog.Data;
import upyog.query.InsertQuery;
import upyog.query.Query;

public class Account {
	
	private String accountName;
	private String accountOwner;
	private String accountManager;
	private float accountBalance;
	private String notes;
	
	
	public Account() {}
	
	public Account(String accountName, String accountOwner, String accountManager, float accountBalance, String notes)
	{
		this.accountName = accountName;
		this.accountOwner = accountOwner;
		this.accountManager = accountManager;
		this.accountBalance = accountBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public static int insertAccount(String accountName, String accountOwner, String accountManager, float accountBalance, String notes)
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(accountName,accountOwner,accountManager,accountBalance,notes));
		int rs = insertAccounts(accounts);
		return rs;
	}
	public int insertAccount()
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(this);
		int rs = insertAccounts(accounts);
		return rs;
	}
	public static int insertAccounts(ArrayList<Account> accounts)
	{
		Data data = new Data();
		Query query = new Query();
		InsertQuery iq = new InsertQuery();
		for(Account account : accounts)
		{
			if(account.accountName==null || account.accountOwner==null || account.accountManager==null)
			{
				System.out.println("Unable to insert account. Check if any of mandatory values are null!");
				break;
			}
			iq.setInsertTableName(ACCOUNT.TABLE);
			HashMap<Query.Column,Object> insertRow = new HashMap<Query.Column,Object>();
			insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_NAME),account.accountName);
			insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_OWNER),account.accountOwner);
			insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_MANAGER),account.accountManager);
			if(account.accountBalance>0.0F)
			{
				insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.ACCOUNT_BALANCE),account.accountBalance);
			}
			if(account.notes!=null)
			{
				insertRow.put(query.new Column(ACCOUNT.TABLE,ACCOUNT.NOTES),account.notes);
			}
			iq.addInsertEntry(insertRow);
		}
		int rs = data.insertData(iq);
		if(rs>0)
		{
			System.out.println(rs+" record(s) inserted successfully");
		}
		return rs;
	}

}
