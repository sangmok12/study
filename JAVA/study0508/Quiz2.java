package study0508;

public class Quiz2 {          //인스턴스변수
	String movieTitle = "";
	int ticketPrice = 10000;
	
	public Quiz2(String movieTitle) {      //매개변수
		this.movieTitle = movieTitle;
		
	}
	public Quiz2(String movieTitle,int ticketPrice) {
		this.movieTitle = movieTitle;
		this.ticketPrice = ticketPrice;
	}

	public static void main(String[] args) {
		Quiz2 info1 = new Quiz2("미이라");
		Quiz2 info2 = new Quiz2("아마존",15000);
		System.out.println("screen 1의 영화제목은 " + info1.movieTitle );
		System.out.println("screen 2의 영화제목은 " + info2.movieTitle );
		System.out.println("screen 1의 가격은 " + info1.ticketPrice );
		System.out.println("screen 2의 가격은 " + info2.ticketPrice );

	}

}
