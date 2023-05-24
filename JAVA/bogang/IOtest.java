package bogang;

import java.io.BufferedReader;
import java.io.FileReader;

public class IOtest {

	public static void main(String[] args) throws Exception {
		
		//생년월일에서 년도 추출 후 나이계산
		
		String path = "c:/lsm/a1.txt";
		// 물리적인 위치의 인식		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String rowData = "";
		while(true) {
			if(  (rowData=br.readLine()) != null) {
				int year = Integer.parseInt(rowData.substring(0,4));
				int age = 2023 - year;
				System.out.println(age);
			} else {
				break;
			}
		}	
	}

}
