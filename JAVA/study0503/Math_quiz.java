package study0503;

public class Math_quiz {

	public static void main(String[] args) {
		
		
		int n1 = 1000;
		int n2 = 1200;
		System.out.println("max : "+Math.max(n1, n2)+
						   " / min : "+Math.min(n1, n2));
		
		
		System.out.println("-----풀어보기1-----");
		
		
		int[] a1 = {90,80,-40};
		int hap = 0;
		for (int i=0; i<a1.length;i++) {
			hap += Math.abs(a1[i]);
		}
		
		int avg = hap/a1.length;
		System.out.println("총합 : "+hap+" / 평균 : "+avg);
		
		
		System.out.println("-----풀어보기2-----");
		
		int[] a2 = {5,45,23,2,34,21};
		int max = a2[0];
		int min = a2[0];
		for (int i=0;i<a2.length-1;i++) {
			max = Math.max(max,a2[i]);
			min = Math.min(min,a2[i]);
		}
		System.out.println("최대 값 : "+max+" / 최소 값 : "+min);
		
		
		
		
		System.out.println("-----풀어보기3-----");
		
		for (int i=0;i<6;i++) {
				System.out.println((int)(Math.random()*45)+1);							
		}
		System.out.println("-----중복안되게 6자리-----");
		
		
		int[] lotto = new int[6];
		// int[] lotto = {0,0,0,0,0,0};
		int idx = 0;
		while(true) {
			boolean b1 = false;
			int number = (int)(Math.random()*45+1);
			for (int i=0; i<6; i++) {
				if(number == lotto[i]) b1 = true;
			}
			if (b1 == false) { //동일한 값이 없는경우 배열함수에 추가. 마지막에 idx값 증가해서 차례로 추가됨.
				lotto[idx] = number;
			} else {
				continue;  //반복문 다시 실행(위로 올려버림)
			}
			idx++;
			if(idx==6) break;
		}
		
		for (int i : lotto) {
			System.out.print(i + " ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* 바로 앞 숫자와 중복은 안되지만 6개가 다 다르진 않음.
		  int l = 0;
		int lot = 0;
		while(l<6) {
			int lo = ((int)(Math.random()*45)+1);
			
			if (lo!=lot) {
				System.out.println(lo);
				lot = lo; 
				l++;
			}
			else if (lo==lot) {
			}
		}*/
		

	}

}
