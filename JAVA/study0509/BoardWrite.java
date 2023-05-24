package study0509;

public class BoardWrite {

	public static void main(String[] args) {

		
		BoardVO vo = new BoardVO();
		vo.setTitle(" 제 목업 음");
		vo.setPass("  33 5   235     ");
		vo.setName("홍길동");
		vo.setContent("  2nwn  352");
		vo.setEmail("423@3525");
		
		System.out.println(vo.getTitle());
		System.out.println(vo.getPass());
		System.out.println(vo.getName());
		System.out.println(vo.getContent());
		System.out.println(vo.getEmail());
		                   
	}

}
