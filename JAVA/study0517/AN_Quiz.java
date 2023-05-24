package study0517;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AN_Quiz {

	public static void main(String[] args) throws Exception {

		File dir = new File("c://20141125");

	

		//특정 디렉토리(폴더)의 정보들을 가져옴
		File[] names = dir.listFiles();

		String rowData="";
		String air = "";
		for( int i=0;i<names.length;i++) {

			FileReader file = new FileReader (names[i]);
			BufferedReader buffer = new BufferedReader(file);

			while (true) {
				if((rowData = buffer.readLine()) !=null) {
					if (rowData.indexOf("AN") != -1) {
						String[] a = rowData.split("/");
						
						air += a[1]+"\n";
					}
				} else {
					break;
				}
			}
			file.close();
		}

		String filename = "c://lsm/AN.txt";
		File f1 = new File(filename);
		FileWriter fw = new FileWriter(f1,false);
		fw.write(air);
		System.out.println("input success");
		fw.close();
	}

}
