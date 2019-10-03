


import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class lca<Key extends Comparable<Key>, Value> 
{
	private Node root;             
	private String stringOutput = "";
	private String multiLineOutput = "";
	private String prefix = "";
	/**
	 * Private node class.
	 */
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

	
	public boolean isEmpty() 
	{ 
		return size() == 0; 
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

	
	public boolean contains(Key key) 
	{
		return get(key) != null;
	}

	
	public Value get(Key key) 
	{ 
		return get(root, key); 
	}

	private Value get(Node x, Key keyToFind) 
	{
		if (x == null) 
			return null;

		int cmp = keyToFind.compareTo(x.key);

		if (cmp < 0) 
			return get(x.left, keyToFind);

		else if (cmp > 0) 
			return get(x.right, keyToFind);

		else              
			return x.value;
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


	

	public int height()
	{
		return height(root); 
	}

	private int height(Node x)
	{
		if (x == null)
			return -1; 

		int leftHeight = 0;
		int rightHeight = 0;

		if(x.right != null)
			rightHeight = 1 + height(x.right);

		if(x.left != null)
			leftHeight = 1 + height(x.left);


		return (((leftHeight > rightHeight) ? leftHeight : rightHeight) );

	}


	
	public Key median() 
	{
		if (isEmpty()) 
			return null;

		else
		{
			int median = (size(this.root) - 1)/2; 
			return (median(root, median)).key;
		}
	}

	private Node median(Node x, int d)
	{ 	
		int t = size(x.left);

		if (t > d)
			return median(x.left, d);

		else if (t < d)
			return median(x.right, d-t-1);

		else
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

	
	public String prettyPrintKeys()
	{
		multiLineOutput = "";

		if (this.root == null) 
			return "-null\n";

		else
			return prettyPrintKeys(root, prefix);
	}

	private String prettyPrintKeys(Node x, String prefix)
	{

		if (x == null) 
			return multiLineOutput += (prefix + "-null\n");

		multiLineOutput += (prefix + "-" + x.key + "\n");

		prefix += " |";
		prettyPrintKeys(x.left, prefix);

		prefix = removeLastChar(prefix);
		prefix += " ";

		prettyPrintKeys(x.right, prefix);


		return  this.multiLineOutput; 	
	}

	private static String removeLastChar(String str) 
	{
		return str.substring(0, str.length() - 1);
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

	private Node max(Node x)
	{
		if (x.right == null) 
			return x;

		return max(x.right);
	}
	
	public Key LCA() {
		return null;
	}
}

//Code from BST assignment in second year
