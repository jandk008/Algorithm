package chow.zidane.util;

import java.util.Arrays;


public class Main {
	public static volatile long startTime = System.currentTimeMillis();
	
	public static void main(String[] args){
//		TestInnerClass outerClass = new TestInnerClass();
//		TestInnerClass.InnerClass innerClass = outerClass.new InnerClass();
//		String[] a = {"A"};
//		String[] b = {"B"};
//		System.out.println(Arrays.asList(concatArray(a, b)));
		testVolatileValues();
	}
	
	public static String replaceJreWithJdk(String s){
		int startIndex = s.indexOf("jre",20);
		if (startIndex != -1){
			System.out.println("============\n"+startIndex);
			return s.replace("jre", "jdk");
		}
		return s;
	}
	
	public static void formatDecimal(String s){
		float f = Float.parseFloat(s);
		String left = String.format("%.2f", f);
		System.out.println(left);
	}
	/**
	 * <p> connect two array to one array</p>
	 * @param first first array
	 * @param second second array
	 * @return
	 */
	public static <T> T[] concatArray(T[] first, T[] second) {
		T[] result = java.util.Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static void testVolatileValues() {
		
		class Runner implements Runnable {
			@Override
			public void run() {
				if (System.currentTimeMillis() > startTime){
					synchronized (Main.class) {
						if (System.currentTimeMillis() > startTime){
							System.out.println(Thread.currentThread().getName() + " over" );
							setStartTime();
						} else {
							System.out.println(Thread.currentThread().getName() + " start time is changed, not over ");
						}
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " not over");
				}
			}
		}
		
		for (int i =0 ; i < 10; i++){
			new Thread(new Runner()).start();
		}

	}
	
	public static void setStartTime(){
		System.out.println("current start is " + startTime + "\n add 15s");
		startTime = startTime + 15000;
	}
}
