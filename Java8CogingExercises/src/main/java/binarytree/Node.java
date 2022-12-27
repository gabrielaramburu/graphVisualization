package binarytree;

class Node {
	private int value;
	private int count;

	private Node leftChild;
	private Node rightChild;
	private Node parent;

	Node(int value) {
		this.value = value;
		this.count = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void addChild(Node newChild) {
		if (newChild.value > this.value) {
			this.rightChild = newChild;
			log(newChild);
		}
		if (newChild.value < this.value) {
			this.leftChild = newChild;
			log(newChild);
		} else {
			this.count++;
		}
	}

	public Node child(int nodeValue) {
		return (nodeValue > this.value) ? this.rightChild 
				: (nodeValue < this.value) ? this.leftChild 
				: null;
	}


	private void log(Node newNode) {
		System.out.println("nuevo nodo: [" + newNode.value + "]");
	}

}
