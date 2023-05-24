package study0509;

public class MemberWrite {

	public static void main(String[] args) {

		MemberVO vo = new MemberVO();
		vo.setUserid("hong123");
		vo.setPass("12351984");
		vo.setName("홍길동");
		vo.setGender("M");
		vo.setBirthday("2020-12-25");
		
		System.out.println(vo.getUserid());
		System.out.println(vo.getPass());
		System.out.println(vo.getName());
		System.out.println(vo.getGender());
		System.out.println(vo.getBirthday());
	}

}
