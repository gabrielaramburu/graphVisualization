package binarytree;

public class BinaryTree {
	static final String SAME_NODE_FOUND = "A node with the same value was found";
	static final String PARENT_NODE_FOUND = "The parent node was found";
	static final String NEW_ROOT_NODE = "A new root node was added";

	private String lastOperationSatus;
	private Node root;

	public BinaryTree() {

	}

	public BinaryTree(int initilValue) {
		this.root = new Node(initilValue);
	}

	public BinaryTree(Node rootNode) {
		this.root = rootNode;
	}

	public void addNode(Node newNode) {
		if (root == null) {
			this.root = newNode;
			log(NEW_ROOT_NODE);
		} else {
			Node parent = findParentNode(root, newNode);
			newNode.setParent(parent);
			parent.addChild(newNode);
		}
	}
	
	public Node findNode(int value) {
		return findNode(root,value);
	}

	public void deleteNode(int value) {
		Node nodotoDelete = findNode(root, value);
		if (nodotoDelete != null) {
			log("Nodo to delete does not exists");
		} else {
			//parent.
		}
		
	}
	
	
	private Node findNode(Node node, int value) {
		if (node == null) {
			return null;
		}
		if (node.getValue() == value) {
			return node;
		}
		Node child = node.child(value);
		return findNode(child, value);
	}

	private Node findParentNode(Node currentNode, Node node) {
		if (currentNode.getValue() == node.getValue()) {
			log(SAME_NODE_FOUND);
			return currentNode;
		}
		Node child = currentNode.child(node.getValue());
		if (child == null) {
			log(PARENT_NODE_FOUND);
			return currentNode;
		}

		return findParentNode(child, node);

	}

	private void log(String info) {
		System.out.println(info);
		this.lastOperationSatus = info;

	}

}
