package excersices.javarevisted;

public class Ex23_BinaryTreeTraversal {

	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
		root.preOrderTraversal(root);
		System.out.println();
		root.postOrderTraversal(root);
		System.out.println();
		root.inOrderTraversal(root);
	}
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

	void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.println(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	void postOrderTraversal(Node root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.val);
	}

	void inOrderTraversal(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}

}
