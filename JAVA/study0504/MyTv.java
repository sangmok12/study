package study0504;

public class MyTv {

	public static void main(String[] args) {
		
		TvControl tv = new TvControl();
		
		
		tv.power();
		tv.channel = 11;
		tv.channelDown();   //10
		
		System.out.println("tv전원 : "+tv.power);
		System.out.println("tv채널 : "+tv.channel);
		
		tv.channelUp();     //11
		tv.channelUp();     //12
		System.out.println("tv전원 : "+tv.power);
		System.out.println("tv채널 : "+tv.channel);
	
		
		tv.power();   //false
		
		System.out.println("tv전원 : "+ tv.power);
		System.out.println("tv채널 : "+ tv.channel);
		
	}

}
