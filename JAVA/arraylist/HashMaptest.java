package arraylist;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;


public class HashMaptest {

	public static void main(String[] args) {
		Map<String, String>map1 = new HashMap<String, String>();
		map1.put("pass","1234");     // put(key,value); put(column,value);
		map1.put("title","첫글입니다.");
		map1.put("name","홍길동");
		
		System.out.println(map1);
		System.out.println(map1.get("pass"));
		System.out.println(map1.get("title"));
		System.out.println(map1.get("name"));
		
		Map<String,Integer>map2 = new HashMap<String,Integer>();
		map2.put("a",11);
		map2.put("b",22);
		map2.put("c",33);
		
		System.out.println(map2);
		System.out.println(map2.get("a"));
		System.out.println(map2.get("b"));
		System.out.println(map2.get("c"));
		
		Map<Integer,String>map3 = new HashMap<Integer,String>();
		map3.put(5,"11");
		map3.put(11,"22");
		map3.put(17,"33");
		
		System.out.println(map3);
		System.out.println(map3.get(5));
		System.out.println(map3.get(11));
		System.out.println(map3.get(17));
		
		String key = "";
		String value = "";
		
		
		Iterator<String> keys = map1.keySet().iterator();
		// keys => {"pass","title","name"}
		while(keys.hasNext()) {    //(다음출력할 내용) 존재유무
			key = keys.next();     //출력할 내용을 추출
			value = map1.get(key);
			System.out.println(key+":"+value);
		}
	}

}
