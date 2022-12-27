package binarytree;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class TreeGenerator {
	private BinaryTree tree;

	public TreeGenerator() {
		this.tree = new BinaryTree();
	}

	
	public BinaryTree getTree() {
		return tree;
	}


	public BinaryTree generate(int minValue, int maxValue, int numberOfNodes) {
		Random random = new Random();
		IntStream numbers = random.ints(numberOfNodes, minValue, maxValue + 1);
		addNodes(numbers);
		
		return tree;
	}
	
	public BinaryTree generate(List<Integer> listOfNumbers) {
		addNodes(listOfNumbers.stream().mapToInt(Integer::intValue));
		return tree;
	}
	
	private void addNodes(IntStream numbers) {
		numbers.forEach((num) -> {
			addNodeToTree(num);
		});
	}

	private void addNodeToTree(int num) {
		System.out.println("New node value=" + num);
		Node newNode = new Node (num);
		tree.addNode(newNode);
	}

}
