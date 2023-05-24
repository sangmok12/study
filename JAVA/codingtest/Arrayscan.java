package codingtest;

import java.util.Scanner;

public class Arrayscan {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("명수를 입력하세요 : ");
		String[] names = new String[scn.nextInt()];
		int size = names.length;
		
		
		System.out.print("이름을 입력하세요 : ");
		for(int i=0;i<size;i++) {
			
			names[i] = scn.next();
		}
			for (int a=0;a<size;a++) {
				System.out.println("이름 : "+ names[a]);
			
		}
	}

}
