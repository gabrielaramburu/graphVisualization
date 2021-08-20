package excersices.javarevisted;

public class Ex22_FindingMiddleElementLinkedList {
	
	public ListNode middleNode(ListNode head) {
		int i = 1;
		int j = 0;
		ListNode current = head;
		while (current != null) {
			if (i % 2 == 0) {
				j++;
			}
			current = current.next;
			i++;
		}
		i = 0;
		ListNode result = new ListNode();
		buildResponse(head, result, j, 0);
		return result;
	}

	public void buildResponse(ListNode head, ListNode result, int j, int i) {
		if (head == null)
			return;

		if (i >= j) {
			result.val = head.val;
			if (head.next != null)
				result.next = new ListNode();
			buildResponse(head.next, result.next, j, i + 1);

		} else
			buildResponse(head.next, result, j, i + 1);

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
