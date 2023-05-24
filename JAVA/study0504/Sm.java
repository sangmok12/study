package study0504;

import java.util.Arrays;

public class Sm {

	public static void main(String[] args) {
		int[] aa = {10,20,55,66,3};
		System.out.println(arrayBig(aa));
		System.out.println(arraySmall(aa));
		System.out.println(arrayCenter(aa));
	
		
		//소수점 아래 자리수 정하기.
		double a1 = 12.1224235;
		// 2자리 -> d * 100; 324.235
		// 소수점 떨구고 -> 나누기 100
		
		System.out.println(myPoint(a1,2));
		System.out.println(myPoint(a1,3));
		System.out.println(myPoint(a1,4));
	}
	
	
	
	
	
	
	
	public static int arrayBig(int[] a) {
		int max = a[0];
		for (int n : a) {
			max = Math.max(max,n);
		}
		return max;
	}
	public static int arraySmall(int[] a) {
		int min = a[0];
		for (int n : a) {
			min = Math.min(min,n);
		}
		return min;
	}
	public static int arrayCenter(int[] a) {
		Arrays.sort(a);
		int len = a.length;
		int center = len/2;
		int result = 0;
		if (len%2 == 0) {
			result = (a[center-1]+a[center])/2;
		} else {
			result = (a[center]);
		}
		return result;
	}
	public static double myPoint(double a,int b) {
		
		double z = Math.pow(10,b);
		int a2 = (int)(a*z);
		double a3 = a2/z;
		
		
		return a3;
		
	}

}
