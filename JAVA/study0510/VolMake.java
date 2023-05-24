package study0510;

public class VolMake implements VolService {
	
	private int volLevel;   //  0;
	
	public int getVolLevel() {
		return volLevel;
	}
	
	public VolMake() {    // 생성자
		volLevel = 1;
	}
	public void volUp(int level) {
		volLevel += level;
	}
	public void volDown(int level) {
		volLevel -= level;
	}
	
	
		

}
