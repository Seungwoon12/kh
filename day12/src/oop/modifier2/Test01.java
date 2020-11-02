package oop.modifier2;

public class Test01 {
	public static void main(String[] args) {
		Account ac = new Account();
		ac.info("생애최초 주택마련 적금", 2.2f, 0.5f, 1000000, 100);
		ac.print();
	}
}