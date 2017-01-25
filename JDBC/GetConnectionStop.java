import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class GetConnectionStop{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
				Connection=
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:ip",	"scott","tiger");
			System.out.println("接続完了");
			
			//外部（実行環境）からの入力を待って、処理ストップ
			BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("ただいま接続中");
				String b = a.readLine();
				System.out.printf("入力 = %s%n長さ = %d文字%n", b, b.length());
			} catch(IOException b) {
				System.out.println("入力エラー");
			}

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
