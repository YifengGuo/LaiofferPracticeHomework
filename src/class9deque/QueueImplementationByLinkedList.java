package class9deque;

//class ListNode {
//	int value;
//	ListNode next;
//	
//	public ListNode(int value) {
//		this.value = value;
//	}
//}

/*
 * offer at the tail, poll at the head
 * the reason is if you poll at the tail, you have 
 * no way to get back to the previous node of tail
 */
public class QueueImplementationByLinkedList {
	private ListNode head;
	private ListNode tail;
	public QueueImplementationByLinkedList() {
		head = tail = null;
	}
	public void offer(int a) {
		if(head == null) {
			ListNode newNode = new ListNode(a);
			head = newNode;
			tail = head;
		} else {
			tail.next = new ListNode(a);
			tail = tail.next;
		}
	}
	
	public Integer poll() {
		if(head == null) {
			return null;
		}
		ListNode node = head;
		head = head.next;
		node.next = null; //separate the polled node from the LinkedList
		return node.value;
	}
	
	public Integer peek() {
		if(head == null) {
			return null;
		}
		return head.value;
	}
}
