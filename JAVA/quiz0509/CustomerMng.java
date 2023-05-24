package quiz0509;

class Customer1VO {
	private String name;
	private int year;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
class Customer2VO extends Customer1VO {
	
	private String phone;
	private int age;
	private String address;
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	
}
public class CustomerMng {
	public static void main(String[] args) {
		Customer2VO c = new Customer2VO();
		c.setName("이방인");
		c.setPhone("010-111-2222");
		c.setAge(30);
		c.setAddress("서울 강남");
		System.out.println(c.getName());
		System.out.println(c.getPhone());
		System.out.println(c.getAge());
		System.out.println(c.getAddress());

	}

}
