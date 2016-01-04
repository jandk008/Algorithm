package chow.zidane.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProtectorThread implements Runnable {
	
	private static innerClass number = new innerClass();
	
	static class innerClass{
		private  long currentNumber = 0;

		public  long getCurrentNumber() {
			return currentNumber;
		}

		public  void setCurrentNumber(long currentNumber) {
			this.currentNumber = currentNumber;
		}
		
	}
	
	
	@Override
	public void run() {
		while (true){
			try {
				Thread.sleep(2000);
				setCurrentNumber(System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void setCurrentNumber(long i){
		System.out.println(new Date(System.currentTimeMillis()) + " update to " + i);
		number.setCurrentNumber(i);
	}
	
	public static innerClass getNumber(){
		return number;
	}
	
	class OtherRunner implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
//				int number = ProtectorThread.currentNumber;
				Thread.sleep(500);
			while (true) {
				Thread.sleep(500);
				//					Thread.sleep(new Double(Math.random() * 2000).longValue());
				innerClass iClass = ProtectorThread.getNumber();
									System.out.println(Thread.currentThread().getName()
											+ " get number " + iClass.getCurrentNumber());
//									iClass.setCurrentNumber(System.currentTimeMillis());
			}
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(10);
		ProtectorThread protectorThread = new ProtectorThread();
		service.submit(protectorThread);
		for (int i = 0 ; i < 40 ; i ++){
			service.submit(protectorThread.new OtherRunner());
		}
	}
}
