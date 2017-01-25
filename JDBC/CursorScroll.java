
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.math.BigDecimal;

class CursorScroll {
	public static void main(String[] args){
		//ローカル変数で宣言しておくこと
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			cn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ip",
					"gogo", "password");
 

			//自動コミットをOFFにする
			cn.setAutoCommit(false);

			//select文
			String sql = "SELECT SNO, HNAME, PRICE FROM SYOHIN";

			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			st = cn.createStatement();

			//select文を送信し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			rs = st.executeQuery(sql);

			//カーソルを1行ずつスクロールし、データをフェッチする
			while (rs.next()) {
				//データを取得する
				String a = rs.getString(1);
				String b = rs.getString(2);
				BigDecimal c = rs.getBigDecimal(3);

				//画面に出力する
				System.out.println(a + "\t" + b + "\t" + c);
			}

		//Class.forName()で例外発生の場合
		} catch(ClassNotFoundException e) {
			e.printStackTrace();

		//getConnection,createStatement,executeQueryで例外発生の場合
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//リソースの解放処理を行う
			try {
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				if(cn!=null){
					cn.close();
				}
			} catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
