


import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class lca<Key extends Comparable<Key>, Value> 
{
	
	private class Node 
	{
		private Key key;          
		private Value value;         
		private Node left;
		private Node right;  	   
		private int N;             

		public Node(Key key, Value val, int N) 
		{
			this.key = key;
			this.value = val;
			this.N = N;
		}
	}

	
	public Key lowestCommonAncestor(Node node, Key key1, Key key2) {
		if (node == null)
            return null;
		if (node.key == key1) {
			return node.key;
		}
		if (node.key == key2) {
			return node.key;
		}
		int cmp1 = node.key.compareTo(key1);
		int cmp2 = node.key.compareTo(key2);
		
        if (cmp1 >= 0 && cmp2 >= 0)
            return lowestCommonAncestor(node.left, key1, key2);
  
        if (cmp1 <= 0 && cmp2 <= 0)
            return lowestCommonAncestor(node.right, key1, key2);
  
        return node.key;
	}
}

//Code from BST assignment in second year
//Removed unnecessary functions
//Consulted code from geeksforgeeks.org