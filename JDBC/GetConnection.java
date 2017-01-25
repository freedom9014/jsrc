import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class GetConnection{
	public static void main(String[] args){
		try{
			//JDBCドライバのクラス名を完全限定名で指定してロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
				Connection cn =
			DriverManager.getConnection
			//接続文字列。環境に応じてカスタム
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"scott","tiger");
			System.out.println("接続完了");

			//Oracleから切断する。切断しないとメモリ開放が明示的にされない。
			cn.close();
			System.out.println("切断完了");
				
		//JDBCを含むjarファイルにクラスパスを通し忘れると発生。
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		//OracleとのSQLでのやり取りでエラーが発生すると例外。
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

