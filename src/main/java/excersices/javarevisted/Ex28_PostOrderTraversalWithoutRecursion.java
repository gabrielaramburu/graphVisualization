package excersices.javarevisted;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex28_PostOrderTraversalWithoutRecursion {

	public static void main(String[] args) {
		new Ex28_PostOrderTraversalWithoutRecursion().traverse();
	}
	
	void traverse() {
		Node root = new Node(55, new Node(35, new Node(25, new Node(15), null), new Node(45)),
				new Node(65, null, new Node(75, new Node(87), new Node(98))));
		
		root.postOrderTraversal(root);
	}
	
	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}

		Node(int val, Node l, Node r) {
			this.val = val;
			this.left = l;
			this.right = r;
		}

		void postOrderTraversal(Node root) {
			Deque<Node> stack1 = new ArrayDeque<Node>();
			Deque<Node> stack2 = new ArrayDeque<Node>();
			stack1.addFirst(root);
			while (!stack1.isEmpty()) {
				Node aux = stack1.removeFirst();
				stack2.addFirst(aux);

				if (aux.left != null) {
					stack1.addFirst(aux.left);
				}
				if (aux.right != null) {
					stack1.addFirst(aux.right);
				}
			}

			stack2.stream().mapToInt(v -> v.val).forEach(v -> System.out.println(v));
		}
	}
}
