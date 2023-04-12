package dao;

import java.sql.*;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Type;

import static utils.DBUtils.openConnection;

public class AccountDaoImpl implements IAccountDao {

	private Connection cn;
	private CallableStatement cst;
	
	public AccountDaoImpl() throws SQLException{
		cn=openConnection();
		//query need to write is only execution of Stored proc
		cst=cn.prepareCall("{call transfer_funds(?,?,?,?,?)}");
		//registering OUT params as those are not changing after user response or there is not role in those params of user
		//API of CST :- public void registerOutParameter(int paramPos,int JDBCType) throws SQLE
		cst.registerOutParameter(4, Types.DOUBLE);
		cst.registerOutParameter(5, Types.DOUBLE);
		System.out.println("DAO is created !!!!!!!!");
	}
	
	@Override
	public String transferFunds(int srcAccNo, int destAccNo, double amountToTransfer) throws SQLException {
		// set the IN params
		cst.setInt(1, srcAccNo);
		cst.setInt(2, destAccNo);
		cst.setDouble(3, amountToTransfer);
		//exc stored proc
		cst.execute();
		//now we need to retrieve the result which are holding into OUT params.
		return "updated src balanace."+cst.getDouble(4)+" Destination balance "+cst.getDouble(5);
	}

	//add a method to clean up
	public void cleanUp() throws SQLException{
		if(cst!=null)
			cst.close();
		if(cn!=null)
			cn.close();
		System.out.println("Emp DAO cleaned up");
	}
}
