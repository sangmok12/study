package study0429;

public class Array {

	public static void main(String[] args) {
		// var color = ["","",""];
		// 문자열 타입의 배열, 숫자타입의 배열
		String[] colors = {"blue","yellow","green"};
		
	    byte[] a1 = {50,60,70};
		short[] a2 = {60,70,80};
		int[] a3 = {98,88,92};
		long[] a4 = {2543L,4530L,301L};
		
		System.out.println(a1);    //정상출력 x
		System.out.println(a1[0] + "," + a1[1] + "," + a1[2]);
		System.out.println("long : " + a4[0]);
		//System.out.println("long : " + a4[5]);    //Index 5는 없다고 출력 됨.
		
		float[] f1 = {2.124f,13.2f,124.23f};  //소수점이 되려면 f 붙어야함.
		double[] d1 = {2.41,3.3331,1.111};
		double d2 = 12;
		
		
		System.out.println("float : " + f1[0]);
		System.out.println("double : "+ d1[1]);
		System.out.println("double d2 : " + d2);
		//String[] str = {"aa","bb",77};  //혼합 사용 안됨
		
		int[] score = {90,80,88,10,30,80,76};
		int result = 0;
		result += score[0];
		result += score[1];
		result += score[2];
		result += score[3];
		result += score[4];
		result += score[5];
		result += score[6];
		
		System.out.println("점수 합계는 " + result);
		System.out.println("점수 평균은 " + result/score.length);
	}   

}
