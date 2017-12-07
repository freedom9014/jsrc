import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class StandardServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
			
			//クライアントからのrequestに含まれていたデータの
			//文字コードを指定する
			req.setCharacterEncoding("文字コード");
			
			//クライアントからのrequestに含まれていたデータを取り出す
			//getParameter()メソッドの引数にパラメータ名を渡すと、
			//値を取得することができる。
			//URLエンコードされたデータは、
			//ここでURLデコード（＝復元）されて取り出される。
			String xdata=req.getParameter("パラメータ名");
      
      //転送内容をセット
      req.setAttribute("プロパティ名" , instanceName);
      
      //転送先をセット
      RequestDispatcher dispatcher = req.getRequestDispatcher("転送先");
      
      //転送
      dispatcher.forward(req , res);
	}
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
    
    doPost(req , res);  
    
   }
  
}




