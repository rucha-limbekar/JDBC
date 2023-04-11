package testers;

import java.sql.*;
import static utils.DBUtils.openConnection;

public class GetAllTopics {

	public static void main(String[] args) {
		
		String sql="select * from topics";
		try(Connection cn=openConnection();
				Statement st=cn.createStatement();
				ResultSet rst=st.executeQuery(sql)){
			//there is no IN OUT params
			//so just print the result
			while(rst.next()) {
			System.out.printf("Topic Id %d Topic name %s%n", rst.getInt(1),rst.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
