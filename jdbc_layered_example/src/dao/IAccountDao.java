package dao;

import java.sql.SQLException;

public interface IAccountDao {

	//add a method to transfer funds from src to dest acc.
	String transferFunds(int srcAccNo,int destAccNo, double amountToTransfer) throws SQLException;
}
