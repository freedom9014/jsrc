import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			//JDBCドライバの登録
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//サーバー、ユーザーの指定
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			Connection conn = DriverManager.getConnection(url,"scott", "tiger");
						
			//ストアドプロシージャの名前を指定
			CallableStatement cstmt = conn.prepareCall("{call insert_emp()}");
						
			//ストアドプログラムを実行
			cstmt.execute();
			
			//次は実行結果の確認。今度は、コールするプログラムではなく、
			//select文なので記述が違います。
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *  FROM emp");
			while (rs.next()) {
				//全列取り出し。一つだけ指定方法を変えています。
				int empno = rs.getInt(1);
				String ename = rs.getString("ename");
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				String hiredate = rs.getString(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(
					empno + " : " + ename + " : " + job + " : " + mgr + " : " +
					hiredate + " : " + sal + " : " + comm + " : " + deptno);
			}
			conn.commit();
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
