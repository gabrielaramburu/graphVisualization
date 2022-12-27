package binarytree;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

	
	void testNewGraph() {
		TreeGenerator randomValueTree = new TreeGenerator();
		randomValueTree.generate(1, 10, 9);
	}
	
	@Test
	void testFindNode() {
		TreeGenerator binaryTreeGenerator = new TreeGenerator();
		Integer numbers[] = {3,4,5,7,8,9};
		binaryTreeGenerator.generate(Arrays.asList(numbers));
		
		BinaryTree tree = binaryTreeGenerator.getTree();
		
		assertNull("The node:0 does not exits in tree.",tree.findNode(0));
		
		assertEquals(3,tree.findNode(3).getValue(), "The node 3 exist.");
		assertEquals(9,tree.findNode(9).getValue(), "The node 9 exist.");
		
		assertNull("The node:6 does not exits in tree.",tree.findNode(6));
		tree.addNode(new Node(6));
		assertEquals(6,tree.findNode(6).getValue(), "The node 6 exist.");
	}
}
