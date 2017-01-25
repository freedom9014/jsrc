import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class GetConnection{
	public static void main(String[] args){
		try{
			//JDBCドライバのクラス名を完全限定名で指定してロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
				Connection=
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:ip",	"scott","tiger");
			System.out.println("接続完了");

			//Oracleから切断する
			cn.close();
			System.out.println("切断完了");
				
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

