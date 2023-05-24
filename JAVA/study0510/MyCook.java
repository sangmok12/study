package study0510;

public class MyCook implements Cookie{
	@Override
	public void makeCookie() {
		System.out.println("내가 만든 과자");
	}
	@Override
	public void makeSalad() {
		System.out.println("내가 만든 샐러드");
	}

}
