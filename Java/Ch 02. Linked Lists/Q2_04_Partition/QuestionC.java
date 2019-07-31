package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

public class QuestionC {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail. */
				tail.next = node;
				tail = node;
			}	
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
		int length = 7;
		LinkedListNode[] nodes = new LinkedListNode[length];
		nodes[0] = new LinkedListNode(3, null, null);
		nodes[1] = new LinkedListNode(5, null, null);
		nodes[2] = new LinkedListNode(8, null, null);
		nodes[3] = new LinkedListNode(5, null, null);
		nodes[4] = new LinkedListNode(10, null, null);
		nodes[5] = new LinkedListNode(2, null, null);
		nodes[6] = new LinkedListNode(1, null, null);
		// for (int i = 0; i < length; i++) {
		// 	nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		// }

		for (int i = 0; i < length - 1; i++) {
			//if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			//}
			// if (i > 0) {
			// 	nodes[i].setPrevious(nodes[i - 1]);
			// }
		}
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 5);
		System.out.println(h.printForward());
	}

}
