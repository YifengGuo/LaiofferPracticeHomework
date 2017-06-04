package class9deque;

/**
 * 
 * @author @Yifeng
 *  make array look like a circle
 *  assume the array is bounded
 *  
 *  step1: if use primitive array
 *       1 2 3 4 5 6 7 8 9 10
 *       head points to first node in queue   poll() head++
 *       tail points next available insertion position in queue offer() tail++
 *       
 *       so if tail reaches at array.length - 1, and we invoke poll() to remove several elements, then we invoke offer()?
 *       we will find the previous several positions are wasted because tail is at position
 *       which shows the list is full but actually it isn't.   to solve this: CircularArray
 *       
 *  step2: import concept of circular array, making the array look like a circle
 *         head = head + 1 == array.length ? 0 : head + 1  or head = (head + 1) % array.length
 *         tail = tail + 1 == array.length ? 0 : tail + 1  or tail = (tail + 1) % array.length
 *         to keep head(tail) position from out of bound  
 *  
 *  step3: how to judge the Array is empty or not? 
 *  	   because at this step head == tail array can be empty and also can be full
 *  
 *  step4: two solutions:
 *  			1.maintain a variable called size to record the current element number in the array
 *  			2.head + 1 == tail -> empty (it means at the very beginning the tail is one position preceding by the head )
 *  			  head == tail -> full  
 *  			  This sulution's drawback is the first position of array cannot hold element, instead it becomes a flag bit 
 *  	          to judge the array is full or empty
 *       
 */

/*
 * solution 1: 
 */
//public class QueueImplementationByCircularArray {
//	int size;
//	int head;
//	int tail;
//	Integer[] array;
//	//constructor
//	public QueueImplementationByCircularArray(int cap) {
//		array = new Integer[cap];
//		size = head = tail = 0;
//	}
//	
//	public boolean offer(int ele) {
//		if(size == array.length) {
//			return false;
//		}
//		array[tail] = ele;
//		tail = (tail + 1 == array.length) ? 0 : tail + 1;
//		size++;
//		return true;
//	}
//	
//	public Integer poll() {
//		if(size == 0) {
//			return null;
//		}
//		Integer res = array[head];
//		//array[head] = null;
//		head = (head + 1 == array.length) ? 0 : head + 1;
//		size--;
//		return res;
//	}
//	
//	public Integer peek() {
//		if(size == 0) {
//			return null;
//		}
//		return array[head];
//	}
//	
//}

/*
 * Solution 2
 */
public class QueueImplementationByCircularArray {
	int head;
	int tail;
	Integer[] array;
	
	public QueueImplementationByCircularArray(int cap) {
		array = new Integer[cap];
		head = 0;
		tail = 1;
	}
	
	public boolean offer(int ele) {
		if(head == tail) {
			return false;
		}
		array[tail] = ele;
		tail = (tail + 1 == array.length) ? 0 : tail + 1;
		return true;
		
	}
	
	public Integer poll() {
		if(head == 0 && tail == 1) {
			return null;
		}
		Integer res = array[head];
		//array[head] = null;
		head = head + 1 == array.length ? 0 : head + 1;
		return res;
	}
	
	public Integer peek() {
		if(head == 0 && tail == 1) {
			return null;
		}
		return array[head];
	}
	
	
}


