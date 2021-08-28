package excersices.javarevisted;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex26_InOrderTraveralWhithoutRecursion {
	 public static void  main(String args[]) {
	        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4, null, new TreeNode(10)), new TreeNode(5)),
	        new TreeNode(3,new TreeNode(6), new TreeNode(7, new TreeNode(8, null, new TreeNode(15)), new TreeNode(9))));
	        root.inOrderTraversal(root);
	    }
	}

	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    
	    TreeNode (int val) {
	        this.val = val;
	    }
	    
	    TreeNode (int val, TreeNode l, TreeNode r){
	        this.val = val;
	        this.left = l;
	        this.right = r;
	    }
	    
	    void inOrderTraversal(TreeNode root) {
	        TreeNode current = root;
	        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	        while (current !=null || !stack.isEmpty()) {
	            if (current != null) {
	                stack.addFirst(current);
	                current = current.left;
	            } else {
	                TreeNode aux = stack.removeFirst();
	                System.out.println(aux.val);
	                current = aux.right;
	            }
	        }
	    }
}
