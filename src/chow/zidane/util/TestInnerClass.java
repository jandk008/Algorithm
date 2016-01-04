package chow.zidane.util;

public class TestInnerClass {
	String s = "outerClass";
	void displayString(){
		System.out.println(s);
	}
	
	class InnerClass{
		String s = "innerClass";
		void displayString(){
			System.out.println(s);
		}
	}
}
