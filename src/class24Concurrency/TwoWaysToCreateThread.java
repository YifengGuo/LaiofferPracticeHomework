package class24Concurrency;

public class TwoWaysToCreateThread {
	// method 1: extends
	static class MyThread1 extends Thread {
		@Override
		public void run() {
			System.out.println("Create thread by extends from super class");
		}
	}
	
	static class MyThread2 implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println("Create thread from interface");
		}
	}
	
	public static void main(String[] args) {
		new MyThread1().start();
		

		Thread mt2 = new Thread(new MyThread2());
		mt2.start();
//		mt2.interrupt();
//		mt2.join();
		
	}
}
