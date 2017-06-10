package class11heapimplementation;

import java.util.NoSuchElementException;

public class MinHeap {
	private int[] array;
	private int size;//current nodes number in heap
	
	//constructor1: user supplies arbitrary array
	public MinHeap(int[] array) {
		if(array == null || array.length == 0) {
			throw new IllegalArgumentException("Input array cannot be null or empty.");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	
	//constructor2: user only supplies capacity of heap
	public MinHeap(int cap) {
		if(cap <= 0) {
			throw new IllegalArgumentException("capacity cannot be <= 0");
		}
		this.array = new int[cap];
		this.size = 0;
	}
	
	public void heapify() {
		for(int i = (size - 2) / 2; i >= 0; i--) {//from last node which has child node to percolate down;
			percolateDown(i);
		}
	}
	
	private void percolateUp(int index) {
		if(index == 0) {//top of heap cannot be percolated up
			return;
		}
		while(index > 0) {
			int parentIndex = (index - 1) / 2;
			if(array[parentIndex] > array[index]) {
				swap(array,parentIndex,index);
			} else {
				break;//terminate the loop when current index cannot move up 
			}
			index = parentIndex;
		}
	}
	
	private void percolateDown(int index) {
		//check if index if legal
		while(index <= (size - 2) / 2) { // the index of last node which has child node is (size - 2) / 2; index cannot be bigger than that.
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int swapCandidate = leftChildIndex; //not sure right child node exists or not
												//not sure which child node to swap,need to check which one is smaller 
			if(rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
				swapCandidate = rightChildIndex;//if right child node exists and its value <= left child node value
			}
			if(array[index] <= array[swapCandidate]) {
				swap(array,index,swapCandidate);
			} else {
				break;//terminate the loop when current index cannot move down 
			}
			index = swapCandidate;
		}
	}
	   
	public void offer(int element) {
		if(size == array.length) {//if full, resize array of heap
			int[] newArray = new int[(int) (array.length * 1.5)];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		array[size] = element;
		size++;
		percolateUp(size-1);
	}
	
	public int poll() {
		if(size == 0) {
			throw new NoSuchElementException("The heap is alreay empty");
		}
		int head = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return head;
	}
	
	public int peek() {
		if(size == 0) {
			return -1;
		}
		return array[0];
	}
	
	//return original value
	public int update(int index,int value) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("invalid index range");
		}
		int origin = array[index];
		array[index] = value;
		//if origin data > value, it means current value needs percolating up, otherwise percolating down
		if(origin > value) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return origin;
	}
	
	private void swap(int[] array,int a,int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == array.length;
	}
	
	public int size() {
		return this.size;
	}

}
