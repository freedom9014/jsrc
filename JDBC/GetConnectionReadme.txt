手順図

OracleにSystemで接続して、接続ユーザーを確認（On SQL*Plus）

SQL> select sid,username,osuser from v$session
  2  where username is not null;

       SID USERNAME                       OSUSER
---------- ------------------------------ ------------------------------
       131 SYSTEM                         TERA4069783\WP
       138 DBSNMP                         NT AUTHORITY\SYSTEM
       141 DBSNMP                         NT AUTHORITY\SYSTEM
       142 SYSMAN                         TERA4069783$
       143 SYSMAN                         TERA4069783$
       146 SYSMAN                         TERA4069783$
       147 SYSMAN                         TERA4069783$

7行が選択されました。



途中で止まってくれるJDBC接続プログラムを実行（On Java）

c:\Jsample\1001\JDBC>java GetCon
接続完了
ただいま接続中


 
止まってる隙にもう一度接続チェック（On SQL*Plus）
SQL> /

       SID USERNAME                       OSUSER
---------- ------------------------------ ------------------------------
       131 SYSTEM                         TERA4069783\WP
       133 SCOTT
       138 DBSNMP                         NT AUTHORITY\SYSTEM
       141 DBSNMP                         NT AUTHORITY\SYSTEM
       142 SYSMAN                         TERA4069783$
       143 SYSMAN                         TERA4069783$
       146 SYSMAN                         TERA4069783$
       147 SYSMAN                         TERA4069783$

8行が選択されました。

今度はscottがいるはず。

とめていたJavaプログラムを実行。何か文字列を入れてEnterを押せばプログラム再開。
c:\Jsample\1001\JDBC>java GetCon
接続完了
ただいま接続中
kurekure
入力 = kurekure
長さ = 8文字
切断完了


 
切断完了したので、接続を再度チェック。（On SQL*Plus）
SQL> /

       SID USERNAME                       OSUSER
---------- ------------------------------ ------------------------------
       131 SYSTEM                         TERA4069783\WP
       138 DBSNMP                         NT AUTHORITY\SYSTEM
       141 DBSNMP                         NT AUTHORITY\SYSTEM
       142 SYSMAN                         TERA4069783$
       143 SYSMAN                         TERA4069783$
       146 SYSMAN                         TERA4069783$
       147 SYSMAN                         TERA4069783$

7行が選択されました。

きれいにscottが消えている。

 
作成のヒント

今回の練習はポイントが二つ。
一つ目はプログラムを止めておくこと。二つ目は、接続状況を確認することです。

Javaのプログラムを止めるために、以下の記述を使用します。
	BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("ただいま接続中");
				String b = a.readLine();
				System.out.printf("入力 = %s%n長さ = %d文字%n", b, b.length());
			} catch(IOException b) {
				System.out.println("入力エラー");
			}


BufferedReaderもInputStreamReaderもすでに使用したことのあるクラスですが、引数にSystem.inを利用してます。これは、システムからの入力を引数としますので、コマンドラインの画面で、入力を行わない限りプログラムが先に進行しません。

この記述をOracleへの接続プログラムの適切な位置に記述してください。

接続状況の確認には、v$sessionを参照します。これは現在の接続状況を参照できるビューになります。上の実行例で入力したSQLは以下のようになります。

select sid,username,osuser from v$session
where username is not null;

使用している列の説明は以下のとおりです。

列名	説明
SID	セッションを区別するためのユニークなID
USERNAME	Oracleのユーザー名
OSUSER	OSでのユーザー名

 
