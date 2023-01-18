package com.dal;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;
import com.pojo.Account;
import com.util.DBUtil;

public class AccountDALImpl implements BankDAL {

	//
	private Connection con;
	private java.sql.CallableStatement cstmt;
	private Statement stmt;
	private ResultSet rset;
	private PreparedStatement pstmt1, pstmt2, pstmt3;

	public AccountDALImpl() throws SQLException {
		con = DBUtil.getCon();

		stmt = con.createStatement();
		System.out.println("statemet created");

		pstmt1 = con.prepareStatement("insert into account values(?,?,?,?)");
		pstmt2 = con.prepareStatement("update account set name=? ,type=? ,balance=? where id=?");
		pstmt3 = con.prepareStatement("delete from account where id=?");

		System.out.println("prepareStatement created");

		cstmt = con.prepareCall("{call transfer_funds(?,?,?,?,?)}");
		// out parameter

		cstmt.registerOutParameter(4, Types.DOUBLE);// parameter 4 data type is double JVM send this info to DB
		cstmt.registerOutParameter(5, Types.DOUBLE);// parameter 5

		System.out.println("---account dal created----");

	}

	public String moneyTransfer(int sId, int rId, double amount) throws SQLException {

		cstmt.setInt(1, sId);// 1st IN parameter
		cstmt.setInt(2, rId);// 2nd IN parameter
		cstmt.setDouble(3, amount);// 3rd IN parameter
		// execute Stored Procedure

		cstmt.execute();
		return "Money Transfer : Sender Balance=" + cstmt.getDouble(4) + "   Reciver Balance:" + cstmt.getDouble(5);
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> allAccount = new ArrayList<Account>();

		try {
			rset = stmt.executeQuery("select * from account");
			while (rset.next()) {
				allAccount.add(new Account(rset.getInt("id"), rset.getString("name"), rset.getString("type"),
						rset.getDouble("balance")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allAccount;
	}

	@Override
	public int addAccount(Account obj) {
		// TODO Auto-generated method stub
		try {
			pstmt1.setInt(1, obj.getId());
			pstmt1.setString(2, obj.getName());
			pstmt1.setString(3, obj.getType());
			pstmt1.setDouble(4, obj.getBalance());

			int i = pstmt1.executeUpdate();
			System.out.println("iserted account filed" + obj);
			return i;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAccount(Account obj) {
		// TODO Auto-generated method stub
		try {

			pstmt2.setString(1, obj.getName());
			pstmt2.setString(2, obj.getType());
			pstmt2.setDouble(3, obj.getBalance());
			pstmt2.setInt(4, obj.getId());

			int i = pstmt2.executeUpdate();
			System.out.println("updated account filed" + obj);
			return i;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		try {
			pstmt3.setInt(1, id);
			int i = pstmt3.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
