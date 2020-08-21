import java.sql.*;
public class JDBCTesting {
	//1 define db url ,user ,pass ,db driver
	private final static String url="jdbc:mysql://localhost/schooldb";
	private final static String dbdriver="com.mysql.cj.jdbc.Driver";
	private final static String user="root";
	private final static String password="root@123";
	public static void main(String[] args) {		
		try {
			//2 Register db driver 
			Class.forName(dbdriver);
			Connection con=null;
			con=DriverManager.getConnection(url, user, password);
			System.out.println("connection create .");			
			if(con!=null) {
				//3 statement
				Statement stm=con.createStatement();
				//4 sql query
				String sql="select * from Category";
				ResultSet rs=stm.executeQuery(sql);
				//5 getting the data 
				System.out.println(String.format("%-5s%-20s%-20s","Id","Code","Description"));
				System.out.println("---------------------------------------------------");
				while(rs.next()) {
					System.out.println(String.format("%-5s%-20s%-20s",rs.getInt(1),rs.getString(2),rs.getString(2)));
				}
				//6 close all of the resources
				rs.close();
				stm.close();
				con.close();
			}
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
}
