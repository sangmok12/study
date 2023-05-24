package study0516;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map_Quiz {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("이름","홍길동");
		map.put("영어","90");
		map.put("국어","10");
		map.put("수학","70");
		//국어점수 수정
		map.put("국어","80");
		
		int hap = 0;
		String pattern = "^[0-9]+$";
		
		
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {  
			String key = keys.next();		
			String value = map.get(key);
			
//			if (score.matches(pattern)) {
//				hap += Integer.parseInt(value);
//				}
			if (!key.equals("이름")) {
				hap += Integer.parseInt(value);
			}
		}
		int avg = hap/(map.size()-1);
		System.out.println("총점 : " + hap);
		System.out.println("평균 : " + avg);

	}

}
