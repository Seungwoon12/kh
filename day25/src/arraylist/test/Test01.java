package arraylist.test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
			List<Book> booklist = new ArrayList<>();
			
			booklist.add(new Book("자바를 잡아라", 30000));
			booklist.add(new Book("오라클 정복", 35000));
			booklist.add(new Book("웹표준 2.0", 27500));
			booklist.add(new Book("자바 Servlet/JSP", 28000));
			booklist.add(new Book("ajax 사용법", 15000));
			
			for(int i=0; i<booklist.size(); i++) {
				Book b = booklist.get(i);
				System.out.println(b.getName());
				System.out.println(b.getPrice());
			}
	}
}
