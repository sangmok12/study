package study0516;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BoardListMap {
	
	// static 없으면 객체처리하고 사용해야하고,  static 있으면 그냥 사용가능
	public static void test1(List<Map> list1) {
		
		int hap = 0;
		for(int i=0;i<list1.size();i++) {
			
			//String은 맞지만 Map안에 있는 배열형식이라 String으로 형변환 해줌
			String rdate = (String)list1.get(i).get("rdate");
			String hit = (String)list1.get(i).get("hit");
			
			rdate = rdate.replace("-","");
			list1.get(i).put("rdate",rdate);
			
			int hit2 = Integer.parseInt(hit)+100;
			list1.get(i).put("hit", hit2);
			hap += hit2;	
		}
		int avg = hap/list1.size();
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		System.out.println("총합 : "+hap);
		System.out.println("평균 : "+avg);
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		List<Map> list1 = new ArrayList<Map>();
		Map<String,String> map1 = new HashMap<String,String>();
		
		map1.put("no","1");
		map1.put("hit","35");
		map1.put("rdate","2021-05-01");
		map1.put("name","홍길동");
		map1.put("title","공지사항1");
		list1.add(map1);
		
		map1 = new HashMap<String,String>();
		
		map1.put("no","2");
		map1.put("hit","3");
		map1.put("rdate","2021-05-05");
		map1.put("name","제임스");
		map1.put("title","공지사항2");
		list1.add(map1);
		
		test1(list1);
	
		

		
	}

}
