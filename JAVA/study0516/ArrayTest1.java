package study0516;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayTest1 {

	public static void main(String[] args) {
		//배열
		//ArrayList, HashMap

		List<String> list1 = new ArrayList<String>(); //인스턴스생성
		list1.add("50");    //index : 0 
		list1.add("80");	//index : 1 


		List<Integer> list2 = new ArrayList<Integer>(); //인스턴스생성
		list2.add(70);      //index : 0 
		list2.add(100);  	//index : 1 


		List<Double> list3 = new ArrayList<Double>(); //인스턴스생성
		list3.add(70.4);    //index : 0 
		list3.add(80.12);  	//index : 1 

		System.out.println(list3);            //전체출력  [대괄호]
		System.out.println(list3.get(0));     //(해당)인덱스출력
		System.out.println(list3.size());     //리스트 갯수 출력
		System.out.println();

		String[] a1 = {"aa","bb","cc"};

		System.out.println(a1);            //전체출력  (안됨)
		System.out.println(a1[0]);         //(해당)인덱스출력
		System.out.println(a1.length);     //리스트 갯수 출력
		System.out.println();


		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("0","aa");
		map1.put("1","bb");
		map1.put("2","cc");
		System.out.println(map1);             //전체출력 {중괄호} (키값포함)
		System.out.println(map1.get("1"));    //(해당)인덱스출력
		System.out.println(map1.size());      //리스트 갯수 출력

		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("userid","tset123");
		map2.put("pass","123456");
		map2.put("birthday","2020-12-25");
		System.out.println(map2);             //전체출력 {중괄호} (키값포함)
		System.out.println(map2.get("pass"));    //(해당)인덱스출력
		System.out.println(map2.size());      //리스트 갯수 출력
		System.out.println();

		//ArrayList (반복문)출력
		//인덱스번호를 이용한 출력
		for(int i=0; i<list1.size(); i++) {
			System.out.println("list["+i+"] : " +list1.get(i));
		}
		// 배열 (반복문)출력
		// 인덱스번호를 이용한 출력
		for(int i=0; i<a1.length; i++) {
			System.out.println("a1["+i+"] : " +a1[i]);
		}
		System.out.println();



		//Map (반복문)출력    
		Iterator<String> keys = map2.keySet().iterator();
		// keys = {"userid","pass","birthday"};   :: 순서가 없음.
		while( keys.hasNext()) { // (다음)존재유무
		String key = keys.next();  //키값을 가져옴
			System.out.println( key + " : " + map2.get(key) );
		}

	}

}
