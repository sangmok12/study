package study0515;

public class LstNmChk {
	// 멤버변수, 클래스, 상수변수(재정의불가)
	public static final String[] lastNmArr = {"김","이","박","조","최","송","허","왕","양","나","차"};
	
	// return 없는 메소드, 호출 된 곳에 예외처리의 강제의무 부과
	void checkLastNm(String lastName) throws InvalidNmException {
		if ( !IsLstNm(lastName)) {   //false가 왔을때 예외처리 하겠음      !false (true)
			throw new InvalidNmException();
		}
	}
	// 접근지정자 리턴타입 메소드명(매개변수)
	private boolean IsLstNm(String str) { 
		boolean tf = false;
		for (int i=0;i<lastNmArr.length;i++) {
			if (lastNmArr[i].equals(str)) {
				tf = true;;
				//같은 성이 존재할 경우 true
			}
		}
		// 같은 성이 존재하지 않는 경우, false 를 던진다.
		return tf;

		
	}
	
}
