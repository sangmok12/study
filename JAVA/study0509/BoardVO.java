package study0509;

/*
 * 일반게시판 : 제목 / 암호 / 이름 / 내용 / 이메일
 */
public class BoardVO {
	private String title;
	private String pass;
	private String name;
	private String content;
	private String email;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) { 
		this.title = title.trim();
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) { 
		this.pass = pass.replace(" ","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) { 
		this.name=name.trim();
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) { 
		this.content=content.trim();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) { 
		if(email.indexOf("@") == -1) {
			email = "";
		}
				this.email=email;
	}

}
