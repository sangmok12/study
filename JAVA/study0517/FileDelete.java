package study0517;

import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		String path = "c:/lsm/개발자/member_info444.txt";
		File file = new File(path);
		//exists() : 존재여부
		//file.delete() : 파일 및 폴더 삭제
		//file.mkdir() : 폴더 생성
		if(file.exists()) {
			file.delete();
			System.out.println("삭제 성공");
		} else {
			System.out.println("파일 존재 x");
		}


	}

}
