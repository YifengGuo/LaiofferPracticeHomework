package class24Concurrency;
/**
 * 
 * @author yifengguo
 * Synchronization in java is to impose order on concurrent events
 * 
 * implementation of Synchronization in Java:
 *     1. Locks(synchronized)  <-- mutual exclusion
 *     2. concurrent data structure (ConcurrentHashMap)
 *     3. wait/notify (condition synchronization)
 *     4. volatile
 *     
 * Use case if Synchronization:
 * 	Write a file simultaneously would possibly cause problem   ----> data race  <-- 1. two or more operations conflict with each other if they
 *                                                                                     operate on the same memory location
 *                                                                                  2. at least one of them is a write 
 *                                                                                  3. at least two of those operations are concurrent
 *
 * Mutual exclusion, critical section and locks:
 *     No two concurrent processes are in their critical section at the same time
 *     And a critical section can be defined as:
 *         A part of a multi-process program that may not be concurrently executed by more than one of the program's processes/threads
 *     
 *     Critical Section: the code that requires mutual exclusion
 *     
 * Why not make the whole program as a big critical section?
 *     1. Performance: by requiring mutual exclusion, we lose concurrency (one at a time)
 *     2. We also do not want to slow operations occupy critical section (like IO)   
 *     
 *       
 * Mutual Exclusion in Java:
 *  1. synchronized keyword:
 *     In fact, every object in Java has a lock when it was initialized
 *     when synchronized invokes, synchronized(xxx) means lock xxx by its lock
 *                                                                 
 */
public class Synchronization {
	/*
	 * for non-static variable (method), the lock is to lock a instance of this class
	 */
	class Counter {
		private int value;
		
		public Counter(int value) {
			this.value = value;
		}
		
		public void increase() {
			synchronized(this) {
				value++;
			}
		}
		
		public synchronized void decrease() {   // synchronized method means when program run into this method, 
			                                    // the lock of the method's corresponding object instance is on
			                                    // and increase() and decrease() is the same due to synchronized use
			value--;
		}
		
		public synchronized int getValue() {    // for increase() or decrease() and getValue() are concurrent, so getValue()
			                                    // must be with synchronized    (recall data race definition, one write and concurrent condition)
			return this.value;
		}
	}
}

/*
 * for static variable (method), the lock is to lock the class
 * but this lock is not to clock all the instances of this class !!!!!
 * because each instance of this class has its own lock, we need to use that lock to lock the instance
 */
class Counter2 {
	private static int value = 0;

	public Counter2(int value) {
		this.value = value;
	}

	public static void increase() {
		synchronized (Counter2.class) {
			value++;
		}
	}

	public static void decrease() {
		synchronized(Counter2.class) {
			value--;
		}
	}

	public static int getValue() {
		synchronized(Counter2.class) {
			return value;
		}
	}
}
