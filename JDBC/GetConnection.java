import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class GetConnection{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle‚ÉÚ‘±‚·‚é
				Connection=
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:ip",	"scott","tiger");
			System.out.println("Ú‘±Š®—¹");

			//Oracle‚©‚çØ’f‚·‚é
			cn.close();
			System.out.println("Ø’fŠ®—¹");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

