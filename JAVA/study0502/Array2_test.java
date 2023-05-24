package study0502;

public class Array2_test {

	public static void main(String[] args) {
		int [][] classA = { {90,80,70},{50,100,100} };
		
		
		int[] hap = new int[2]; // int[] hap = { 0 , 0}
		
		//for(int i=0; i<2; i++) -->0,1
		for ( int i=0; i<classA.length; i++) {
			for (int j=0; j<classA[i].length; j++) {  // 0,1,2
				System.out.println( classA[i][j]);
				hap[i] += classA[i][j];
			}
		}
		
		int len1=classA[0].length;
		int len2=classA[1].length;
		System.out.println("1반 총점:" +hap[0]+"점/평균:" + hap[0]/len1+"점");
		System.out.println("2반 총첨:" +hap[1]+"점/평균:" + hap[1]/len2+"점");
		System.out.println("전체평균" + (hap[0]+hap[1])/(len1+len2) + "점");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int hap1 = 0;
		int hap2 = 0;
		
		
			for (int i=0; i<classA[0].length; i++) {
				hap1 = hap1 + classA[0][i];
			}
			for (int i=0; i<classA[1].length; i++) {
				hap2 = hap2 + classA[1][i];
			}
		
		int avg1 = hap1/classA[0].length;
		int avg2 = hap2/classA[1].length;
		
		System.out.println("1반 총점:" + hap1 +"점/평균:"+avg1+"점");
		System.out.println("2반 총점:" + hap2 +"점/평균:"+avg2+"점");
		System.out.println("전체평균:"+((avg1+avg2)/classA.length)+"점"); */
		
		
		//System.out.println(classA[1].length);
		
		
		
		

	}

}
