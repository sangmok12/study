package bogang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class IOtest3 {

	public static void main(String[] args) throws Exception {

		// 개강년도 2020-12-25     2020/12/25 로 바꿔서 덮어쓰기
		String path = "C:/lsm/a2.txt";

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String rowData = "";
		String saveData = "";
		String allData = "";
		while(true) {
			rowData=br.readLine();
			if( rowData != null ) {
				if(rowData.indexOf("개강2") > -1) {
					// 개강2:2023/07/10
					String[] str = rowData.split(":");
					str[1] = "2023/07/15";
					saveData = str[0]+":"+str[1];
				} else {
					allData += rowData+"\n";
				}
				
			} else {
				break;
			}
		}
		
		allData += saveData;
		
		
		File file = new File(path);
		FileWriter fw = new FileWriter(file,false);
		fw.write(allData);
		fw.close();
		System.out.println("변경완료");
	}
}
