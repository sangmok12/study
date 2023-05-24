package study0510;

public class CarVolMake implements CarVolService{

	
	// CarVolService[interface] 파일에서 가져온 메소드들 만들기.
	// CarVolMake 클래스명에 빨간줄 뜰때 오른쪽 마우스 눌러서 Add
	
	
	private int volLevel = 0;
	private int volLevelTemp = 0;
	
	public int getVolLevel() {
		return volLevel;
	}
	
	@Override
	public void volUp(int level) {
		volLevel += level;
	}

	@Override
	public void volDown(int level) {
		volLevel -= level;
	}

	@Override
	public void volOff() {
		volLevel = 0;
	}

	@Override
	public void volPause() {
		volLevelTemp = volLevel;
		volLevel = 0;
	}

	@Override
	public void volResume() {
		volLevel = volLevelTemp;
	}
	
	
}
