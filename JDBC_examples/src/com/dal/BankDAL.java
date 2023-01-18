package com.dal;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Account;

public interface BankDAL {
//CRUD for Accounts

	List<Account> getAllAccount();

	int addAccount(Account obj);

	int updateAccount(Account obj);

	int deleteAccount(int id);

	String moneyTransfer(int sId, int rId, double amount) throws SQLException;
}
