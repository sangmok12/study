package study0510;

public class BankServiceImpl implements BankService {

	private int money;
	
	public int getMoney() {
		return money;
	}
	@Override
	public void moneyInput(int money) {
		this.money += money;
		System.out.println("입금액 : " + money + " 현재잔액 : " + this.money);
	}

	@Override
	public void moneyOutput(int money) {
		if (this.money < money) {
			System.out.println("잔액부족");
		} else {
			this.money -= money;
			System.out.println("출금액 : " + money + " 현재잔액 : " + this.money);
		}
		
	}

	@Override
	public void moneyPrint() {
		System.out.println("현재 잔액 : "+ this.money);
	}

}
