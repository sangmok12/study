package study0509;
/*
 * 아이디 / 암호 / 이름 / 성별 / 생년월일
 * userid    - > 6 ~ 12 아니면 - > 아이디오류
 * pass      - > 4 ~ 20 아니면 - > 암호 오류
 * gender    - > M/F    아니면 - > 성별 오류
 * birthday  - > 2020-12-15 10자리가 아닌경우  생일 오류
 */ 
public class MemberVO {
	private String userid;
	private String pass;
	private String name;
	private String gender;
	private String birthday;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) { 
		userid = userid.trim();
		if (userid.length() < 6 || userid.length() > 12) {
			userid = "아이디 입력 오류";
		}
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) { 
		pass = pass.trim();
		if (pass.length() < 4 || pass.length() > 20) {
			pass = "암호 입력 오류";
		}
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) { 
		if (!gender.equals("M") && !gender.equals("F")) {
			gender = "성별 입력 오류";
		}
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) { 
		if (birthday.length() != 10) {
			birthday = "아이디 입력 오류";
		}
		this.birthday = birthday;
	}
}
