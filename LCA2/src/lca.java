


import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class lca<Key extends Comparable<Key>, Value> 
{
	private Node root;             
	private String stringOutput = "";
	private String multiLineOutput = "";
	private String prefix = "";
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


	public void put(Key key, Value val) 
	{
		if (val == null) 
		{ 
			delete(key); 
			return; 
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key keyToPlaceValIn, Value newValue) 
	{
		if (x == null) 
			return new Node(keyToPlaceValIn, newValue, 1);

		int cmp = keyToPlaceValIn.compareTo(x.key);

		if (cmp < 0) 
			x.left  = put(x.left,  keyToPlaceValIn, newValue);

		else if (cmp > 0) 
			x.right = put(x.right, keyToPlaceValIn, newValue);

		else             
			x.value   = newValue;

		x.N = 1 + size(x.left) + size(x.right);

		return x;
	}

	public int size() 
	{ 
		return size(root); 
	}

	private int size(Node x) 
	{
		if (x == null) 
			return 0;

		else 
			return x.N;  
	}


	private Node max(Node x)
	{
		if (x.right == null) 
			return x;

		return max(x.right);
	}

	public void delete(Key key)
	{ 
		root = delete(root, key); 
	}

	private Node delete(Node x, Key key)
	{
		if (x == null) 
			return null;

		int compare = key.compareTo(x.key);

		if (compare < 0) x.left = delete(x.left, key);

		else if (compare > 0) x.right = delete(x.right, key);

		else
		{
			if (x.right == null) 
				return x.left;

			if (x.left == null) 
				return x.right;

			Node t = x;
			x = max(t.left); 
			x.left = deleteMax(t.left);
			x.right = t.right;
		}

		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	private Node deleteMax(Node x)
	{
		if (x.right == null) 
			return x.left;

		x.right = deleteMax(x.right);

		x.N = size(x.right) + size(x.left) + 1;

		return x;
	}

	public String printKeysInOrder()
	{
		stringOutput = "";

		if (this.root == null) 
			return "()";

		else
			return "(" + printKeysInOrder(this.root) + ")";
	}

	private String printKeysInOrder(Node x)
	{
		if (x == null) 
			return "";

		stringOutput += "(";
		printKeysInOrder(x.left);
		stringOutput += ")";

		stringOutput += (x.key);

		stringOutput += "(";
		printKeysInOrder(x.right);
		stringOutput += ")";

		return stringOutput;
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