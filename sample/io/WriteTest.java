import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

class Test{
	public static void main(String args[]){
		DataWriter data=new DataWriter();
		data.writeFile(args[0]);
	}
}
class DataWriter{
	public void writeFile(String data){
		
		try{
			//�@
			File file=new File("today.xml");
			
			//ファイルが存在しなければファイルを作成する
			file.createNewFile();//必要かどうか
			
			
			//�A
			FileOutputStream out=new FileOutputStream(file);
			
			//�B
			OutputStreamWriter writer=new OutputStreamWriter(out,"UTF-8");
			
			//�C
			BufferedWriter buff=new BufferedWriter(writer);
			
			//�D
			buff.write("<?xml version='1.0' encoding='UTF-8'?>");
			
			//�E
			buff.newLine();

			buff.write(data);
			buff.newLine();
			buff.write("\t<kaiin>田中</kaiin>");
			buff.newLine();
			buff.write("\t<kaiin>鈴木</kaiin>");
			buff.newLine();
			buff.write("\t<kaiin>吉田</kaiin>");
			buff.newLine();
			buff.write("</meibo>");
			
			//�F
			buff.flush();
			
			//�G
			buff.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
