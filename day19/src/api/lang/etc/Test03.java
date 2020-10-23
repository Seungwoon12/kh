package api.lang.etc;

import java.io.IOException;
public class Test03 {
	public static void main(String[] args) throws IOException	 {
		Runtime run = Runtime.getRuntime();
		
		run.exec("notepad.exe");
		run.exec("calc.exe");
		run.exec("cmd /c start http://www.google.com");
	}
	

}
