package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
		List<String>list1 = new ArrayList<String>();
		list1.add("50");
		list1.add("60");
		list1.add("70");
		
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		System.out.println("list1 저장된 객체 수 : " + list1.size());
		
		//리스트의 첫번째(0)값을 지우면서 다시 순서는[0,1]로 ([1,2] 남은거아님) 배열 맞춰짐
		list1.remove(0);                  
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		
		System.out.println("list1 저장된 객체 수 : " + list1.size());
		
		
		
		
		List<String>list2 = new ArrayList<String>();
		list2.add("80");
		list2.add("90");
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		System.out.println("list2 저장된 객체 수 : " + list2.size());
		
		list2.remove(0);
		System.out.println(list2.get(0));
		System.out.println("list2 저장된 객체 수 : " + list2.size());
		
		List<String>list3 = new ArrayList<String>();
		list3.add(0,"10");
		list3.add(1,"20");
		list3.add(2,"30");
		
		
		System.out.println(list3.get(0));
		System.out.println(list3.get(1));
		System.out.println(list3.get(2));
		
		for(int i=0;i<list3.size();i++) {
			System.out.println(i + ":" + list3.get(i));
	 	}
	}

}
