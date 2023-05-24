package codingtest;

public class Numn {

	public static void main(String[] args) {
		
		
		/* 정수 리스트 num_list와 정수 n이 주어질 때, 
		 * n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를 
		 * return하도록 solution 함수를 완성해주세요.
		 */
		int[] num_list = {5,2,1,7,5};
		int n = 2;
		int len = num_list.length-n+1;
		int[] aa = new int[len];
		
		for (int i=0;i<len;i++) {
			aa[i] = num_list[n-1+i];
		}
				
		for (int i=0;i<len;i++) {
			System.out.print(aa[i] + " ");;
		}
				
	}

}
