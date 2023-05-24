package study0516;

import java.util.ArrayList;
import java.util.List;

public class ArrayQuiz3 {

	public static void main(String[] args) {
		List<String>list1 = new ArrayList<String>();
		
		// 데이터 넘어올때 다 String 상태로 넘어옴.
		list1.add("50");
		list1.add("60");
		list1.add("70");
		
		int hap = 0;
		
		for (int i=0;i<list1.size();i++) {
			hap += Integer.parseInt(list1.get(i));
		}
		
		int avg = hap/list1.size();
		System.out.println("총점 : "+hap);
		System.out.println("평균 : "+avg);
		

	}

}
