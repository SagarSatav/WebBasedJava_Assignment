package com.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dal.AccountDALImpl;
import com.pojo.Account;
import com.util.DBUtil;

public class TestBankAccount {

	public static void main(String[] args) {


		try {
			DBUtil.openConnection();

			System.out.println("1.show all account  2.Add Account  3.Update Account  4.delete Account");

			AccountDALImpl AccountDAL = new AccountDALImpl();

			Scanner sc = new Scanner(System.in);

			boolean exit = true;
			while (exit) {
				System.out.println("enter choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("show all accounts");
					List<Account> allAccount = AccountDAL.getAllAccount();
					allAccount.forEach(b -> System.out.println(b));
					break;
				case 2:
					System.out.println("add new account");
					Account acct = new Account(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					AccountDAL.addAccount(acct);

					break;

				case 3:

					System.out.println("update your account");
					Account acct1 = new Account(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
					AccountDAL.updateAccount(acct1);

					break;

				case 4:
					System.out.println("delete your account");
					int id = sc.nextInt();
					AccountDAL.deleteAccount(id);
					System.out.println("delete successfully");
					break;

				case 5:
					System.out.println("Enter SenderID Reciver ActID Amount");

					String status = AccountDAL.moneyTransfer(sc.nextInt(), sc.nextInt(), sc.nextDouble());
					System.out.println(status);

					break;

				case 6:
					System.out.println("exit");

					exit = false;

					break;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
