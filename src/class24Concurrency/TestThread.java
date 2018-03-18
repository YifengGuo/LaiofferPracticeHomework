package class24Concurrency;

public class TestThread {
	/*
	 * concurrency: means tasks run simultaneously which is only on semantics that
	 * we or system could not tell which task run first and which run next
	 * 
	 * parallel: multiple tasks run physically simultaneously
	 */
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("Hello1");
			}
		};
		t.start();
		System.out.println("Hello2"); // could not tell Hello1 and Hello2 which one printed first
	}
}
