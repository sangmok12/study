package study0515;

//  사용자익셉션 클래스 생성
public class InvalidNmException extends Exception{
	public String toString() {
		return "올바른 성이 아닙니다.";
	}
}
