import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			//JDBC�h���C�o�̓o�^
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//�T�[�o�[�A���[�U�[�̎w��
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			Connection conn = DriverManager.getConnection(url,"scott", "tiger");
			//ユーザー名はＳｃｏｔｔでパスワードはタイガー
			//パスワードまちがえてびっくり

			//�X�g�A�h�v���V�[�W���̖��O���w��
			CallableStatement cstmt = conn.prepareCall("{call insert_emp()}");

			//�X�g�A�h�v���O���������s
			cstmt.execute();

			//���͎��s���ʂ̊m�F�B���x�́A�R�[������v���O�����ł͂Ȃ��A
			//select���Ȃ̂ŋL�q���Ⴂ�܂��B
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *  FROM emp");
			while (rs.next()) {
				//�S����o���B������w����@��ς��Ă��܂��B
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
