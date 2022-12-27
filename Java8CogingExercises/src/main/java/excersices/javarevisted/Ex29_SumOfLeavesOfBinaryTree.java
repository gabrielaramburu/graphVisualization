package excersices.javarevisted;

public class Ex29_SumOfLeavesOfBinaryTree {
	int total = 0;
    public int SumofLeafNodes(Node root)
    {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null)
            total+=root.data;
        
        SumofLeafNodes(root.left);
        SumofLeafNodes(root.right);
        
        return total;
    }
    
    class Node
    {
        int data;
        Node left, right;
        
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
} 


