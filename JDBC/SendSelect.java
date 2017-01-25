import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;


class SendSelect{
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"gogo","nono");
			System.out.println("接続完了");
			
			//select文
			String sql=" SELECT SNO, HNAME, PRICE FROM SYOHIN";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			rs.next();
			String sno=rs.getString (1);	//1列目のデータを取得
			String hname=rs.getString(2);	//2列目のデータを取得
			BigDecimal price=rs.getBigDecimal(3);	//3列目のデータを取得
			
			System.out.println("SNO"+"\t"+"HNAME"+"\t"+"PRICE");
			System.out.println(sno+"\t"+hname+"\t"+price);
			

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

