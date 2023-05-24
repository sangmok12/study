package study0516;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayQuiz2 {

	public static void main(String[] args) {

		Map<String,Integer>map = new HashMap<String,Integer>();

		map.put("영어",50);
		map.put("국어",40);
		map.put("수학",70);

		int hap = 0;

		String str = "";
		Iterator<String> keys = map.keySet().iterator();

		//keys.hasNext()[다음값이 있으니 true로 while 진행, 없으면false로 끝.
		while (keys.hasNext()) {  
			String key = keys.next();
			int value = map.get(key);
			hap += value;


			if ( value < 60) {
				str += key+",";  // 연결 -> str = "영어,";

			}
		}
		double avg =  (double)hap/(double)(map.size() );
		
		String avg1 = avg+"";
		String[] avg2 = avg1.split("\\.");
		// avg2[0] = "53";  avg2[1] = "33333333336";
		String avg3 = avg2[0]+"."+avg2[1].substring(0,1);
		
		
		
		int str_len = str.length();
		str = str.substring(0,str_len-1);
		
		System.out.println("총점 : "+hap);
		System.out.println("평균 : "+avg3);
		System.out.println("낙제과목 : "+str);



	}
}
