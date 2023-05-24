package study0515;

public class LstNameChkTest {

	public static void main(String[] args) {
		String str = "김";
		LstNmChk lstNm = new LstNmChk();
		try {
			lstNm.checkLastNm(str);
			System.out.println("올바름");
		} catch (InvalidNmException e) {
			System.out.println(e.toString());
		}
	}

}
