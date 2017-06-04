package class9deque;

import java.util.LinkedList;
import java.util.List;

class ListNode {
	int value;
	ListNode next;
	
	public ListNode(int value) {
		this.value = value;
	}
}
/*
 * when define api, if it needs to return special value like null, we'd better use obj(Integer)
 */
public class StackImplementationByLinkedList {
	private ListNode top = new ListNode(0);
	
	public void push(int a) {
		ListNode newNode = new ListNode(a);
		newNode.next = top;
		top = newNode;
	}
	
	public Integer pop() {
		if(top != null) {
			ListNode res = top;
			top = top.next;
			return res.value;
		}
		return null;
	}
	
	public Integer peek() {
		if(top == null) {
			return 0;
		}
		return top.value;
	}
}
