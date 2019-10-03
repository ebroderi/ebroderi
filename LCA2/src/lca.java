


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

	
	public Key LCA() {
		return null;
	}
}

//Code from BST assignment in second year
//Removed unnecessary functions