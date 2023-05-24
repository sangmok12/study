package study0510;

public class BankController {

	public static void main(String[] args) {
		BankServiceImpl b = new BankServiceImpl();
		
		b.moneyPrint();
		b.moneyInput(50000);
		b.moneyOutput(30000);
		b.moneyPrint();
		b.moneyInput(50000);
		b.moneyInput(500000);
		b.moneyPrint();

	}

}
