package chow.zidane.util;

public class Foo extends Thread {
	private String name;
	private String val;

	public Foo(String name, String v) {
		this.name = name;
		val = v;
	}

	public void printVal() {
		synchronized (val) {
			while (true) {
				System.out.println(name + val);
			}
		}
	}

	public void run() {
		printVal();
	}

	public static void main(String[] args) {
		Foo f1 = new Foo("Foo 1:", "printVal");
		f1.start();
		Foo f2 = new Foo("Foo 2:", "printVal");
		f2.start();
	}
}