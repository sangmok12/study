package codingtest;

public class UpperLower {

	public static void main(String[] args) {
		
		String a = "ESEfiE";
		
		String[] b = a.split("");
		
		for (int i=0;i<b.length;i++) {
			if (Character.isUpperCase(a.charAt(i))) {
				System.out.print(b[i].toLowerCase());
			}
			else {
				b[i].toLowerCase();
			System.out.print(b[i].toUpperCase());
			}
		}
		
			
		
		
	}
}
