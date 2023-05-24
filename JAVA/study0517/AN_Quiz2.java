package study0517;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AN_Quiz2 {

	public static void main(String[] args) throws Exception{
		String inputFile = "C:/lsm/AN2.txt";
		
		File file100 = new File(inputFile);
		if(file100.exists()) {
			System.out.println("이미 생성된 파일입니다.");
			return;   //메소드 종료
		} else {
		
		String path = "C:/20141125";
		// 변수 값으로 설정된 폴더경로를 물리적으로 인식시킴
		File file = new File(path);
		// 인식된 폴더내의 파일관련 정보를 가져옴
		File[] names = file.listFiles();
		
		for(int i=0;i<names.length;i++ ) {
			// 폴더 내의 파일관련 정보에서 파일명을 가져옴
			String filename = names[i].getName();
			// 변수 값으로 정의된 파일명을 실제 물리적인 파일로 인식시킴
			FileReader file1 = new FileReader(path+"/"+filename);
			// 물리적인 파일을 위치시켜 내용을 읽어들일 수 있는 클래스를 정의함
			BufferedReader buffer = new BufferedReader(file1);
			String rowData = "";
			int cnt = 0;
			while(true) {
				if ((rowData = buffer.readLine())!=null) {
					cnt++;
					if (cnt==5) {
						String[] str = rowData.split("/");
						System.out.println(str[1]);
						File file3 = new File(inputFile);
						FileWriter fw = new FileWriter(file3,true);
						fw.write(str[1]+"\n");
						fw.close();
					}
				} else {
					break;
				}
				
			}
		}
		System.out.println("생성완료");
		}
	}

}
