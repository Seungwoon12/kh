package oop.inherit7;

public class Test01 {
	public static void main(String[] args) {
		ZFlip z = new ZFlip();
		z.call();
		z.sms();
		z.camera();
		
		V60 v = new V60();
		v.call();
		v.sms();
		v.camera();
		
		IPhone11 i = new IPhone11();
		i.call();
		i.sms();
		i.camera();
	}
}
