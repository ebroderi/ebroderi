import java.util.ArrayList;

public class DAG {
	private int V;
	private int E;
	private ArrayList<Integer>[] adj; 
	
	public int V() {
		return V;
	}
	
	public int E() {
	return E;	
	}
	
	public void addEdge(int v, int w)
	{
		
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public DAG reverse() {
		return null;
	}
}
//Functions from https://algs4.cs.princeton.edu/42digraph/ - last year's course book 