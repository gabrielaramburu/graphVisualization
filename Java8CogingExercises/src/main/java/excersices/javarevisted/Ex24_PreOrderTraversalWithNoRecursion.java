package excersices.javarevisted;

import java.util.*;

public class Ex24_PreOrderTraversalWithNoRecursion {
	public static void main(String[] args) {
		new Ex24_PreOrderTraversalWithNoRecursion().traverse();
	}

	void traverse() {
		Node root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
		root.preOrderTraversal(root);
	}
	
	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		void preOrderTraversal(Node root) {
			Deque<Node> stack = new ArrayDeque<Node>();
			stack.addFirst(root);

			while (!stack.isEmpty()) {
				Node current = stack.removeFirst();
				System.out.println(current.val);

				if (current.right != null) {
					stack.addFirst(current.right);
				}

				if (current.left != null) {
					stack.addFirst(current.left);
				}
			}
		}
	}

}