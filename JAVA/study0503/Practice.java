package study0503;

import java.time.LocalDate;

public class Practice {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today.getYear());
		
		LocalDate otherDay = today.withYear(1982);
		System.out.println(otherDay.getYear());

		
		int num1 = 12, num2 = 43;		
		
		System.out.println(num1 +""+ num2);
		
		
		
		byte num3= 127;
		byte num4=-128;
		
		num3++;
		num4--;
		
		System.out.println(num3);
		System.out.println(num4);
	}

}
