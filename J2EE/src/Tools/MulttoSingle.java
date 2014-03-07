package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class MulttoSingle {

	public static void main(String[] args) throws FileNotFoundException {
		String path ="C:\\Users\\Administrator\\Desktop\\2.xml";
	  	BufferedReader br = null;
	  	StringBuffer temp = new StringBuffer();
		try {
			File file = new File(path);
			if (!file.exists()) {
				return;
			}
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) {
					temp.append(line);
				}
			}
		} catch (Exception e) {
			
		} finally {
			System.out.println(temp.toString().replaceAll("\r\n", "").replaceAll("\t", "").replace("\b", "").replace(" ", "").replace("\"", "\\\""));
		}
		
	}

}
