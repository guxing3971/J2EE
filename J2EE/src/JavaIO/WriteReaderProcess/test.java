package JavaIO.WriteReaderProcess;

import java.io.*;

public class test {

	public static void main(String[] args) throws Exception {

		Process p = Runtime.getRuntime().exec("cmd.exe //c ipconfig //all");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				p.getErrorStream()));

		String buff = null;

		while ((buff = br.readLine()) != null) {

			System.out.println(buff);

		}
	}

}




