package extratest2;

public abstract class Phone {
	protected String number;
	protected int price;
	
	public Phone(String number) {
		this.setNumber(number);
		this.setPrice(price);
	}
//	public Phone(String number, int price) {
//		this.setNumber(number);
//		this.setPrice(price);
//	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract void call();
	public abstract void text();
	
	
	
	
}
