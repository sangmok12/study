package bogang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class IOtest2 {

	public static void main(String[] args) throws Exception {
		
		// 개강년도 2020-12-25     2020/12/25 로 바꿔서 덮어쓰기
		String path = "C:/lsm/a2.txt";
		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String rowData = "";
		String saveData = "";
		while(true) {
			rowData=br.readLine();
			if( rowData != null ) {
				rowData = rowData.replace("-","/");
				saveData += rowData+"\n";
			} else {
				break;
			}
		}
		File file = new File(path);
		FileWriter fw = new FileWriter(file,false);
		fw.write(saveData);
		fw.close();
		System.out.println("변경완료");
	}

}
