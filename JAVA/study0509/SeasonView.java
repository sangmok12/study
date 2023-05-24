package study0509;

public class SeasonView extends Season1{
	// 여름의 설정을 바꾼다. (이름 :"Summer", 시작월 : 6,마지막월:8, 평균온도:40)
	// 다형성(오버라이딩) : 상위클래스의 메소드를 같은 이름으로 재구성
	public void summer() {
		name = "Summer";
		firstMonth = 6;
		lastMonth = 8;
		avgTemp = 40;
	}
	

	public static void main(String[] args) {
		SeasonView ss = new SeasonView();
		ss.summer();
		ss.seasonPrint();

	}

}
