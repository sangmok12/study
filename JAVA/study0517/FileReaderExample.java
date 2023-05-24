package study0517;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderExample {

	public static void main(String[] args) throws Exception{
		
		//특정 파일을 인지하는 클래스
		FileReader file = new FileReader ("c:/lsm/개발자/진도.txt");
		//파일안의 텍스트를 읽어들이는 클래스
		BufferedReader buffer = new BufferedReader(file);
		String rowData="";
		while (true) {
			if((rowData = buffer.readLine()) !=null) {
				System.out.println(rowData);
			} else {
				break;
			}
		}
		file.close();
	}

}
