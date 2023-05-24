package study0518;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Guri1 {
	
	//구리시 자료만 추출해서 파일로 만들기.
	
	public static void main(String[] args) throws Exception {
		String path = "C:/lsm/post1.csv";
		String savefile = "C:/lsm/guri.txt";
		String guri = "";
		FileReader fr = new FileReader (path);
		BufferedReader br = new BufferedReader(fr);
		
		String rowData = "";
		
		while(true) {
			if( (rowData = br.readLine()) != null) {
				if(rowData.indexOf("구리시") > -1) {	
					guri += rowData+"\n";
				}
			} else 	break;   //while문 종료
		}
		File file = new File(savefile);
		//덮어쓰기 용도로 클래스를 사용가능 상태로 만듦
		FileWriter fw = new FileWriter(file,false);
		fw.write(guri);
		fw.close();
		br.close();
		System.out.println("저장완료");
	}

}
