package study0516;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayQuiz {

	public static void main(String[] args) {
			
		Map<String,Integer>map = new HashMap<String,Integer>();
	
		map.put("영어",50);
		map.put("국어",40);
		map.put("수학",70);
	
		int hap = 0;
		int cnt = 0;
		List<String>list = new ArrayList<String>();
		Iterator<String> keys = map.keySet().iterator();
		
		//keys.hasNext()[다음값이 있으니 true로 while 진행, 없으면false로 끝.
		while (keys.hasNext()) {  
			String key = keys.next();
			hap += map.get(key);
			cnt++;
			
			if (map.get(key)<60) list.add(key);

		}
		double avg = (double)(int)(((double)hap/cnt)*10)/10;
		
		System.out.println("총점 : "+hap);
		System.out.println("평균 : "+avg);
		System.out.println("낙제과목 : "+list);
	
		System.out.print("낙제과목 : ");
		System.out.print(list.get(0));
		for(int i=1;i<list.size();i++) {
			System.out.print(","+list.get(i));
		}	
		
	}

}
