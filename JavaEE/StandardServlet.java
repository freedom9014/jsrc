Skip to content
This repository
Search
Pull requests
Issues
Marketplace
Explore
 @freedom9014
 Sign out
 Unwatch 2
  Star 0  Fork 0 freedom9014/jsrc
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Insights  Settings
Branch: master Find file Copy pathjsrc/StandardServlet.java
d2d01a3  13 minutes ago
@freedom9014 freedom9014 Create StandardServlet.java
1 contributor
RawBlameHistory     
45 lines (30 sloc)  1.34 KB
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
