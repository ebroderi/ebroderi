import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private final int V;
	private int E;
	private ArrayList<Integer>[] adj; 
	private int[] indegree;
	private boolean visited[]; //take note of the vertices that have been visited
	private boolean cycleExists;//true if a cycle exists
	private boolean stack[];//take note of the order in which the vertices are visited
	//As the graphs must be acyclic, must create function to detect cycles

	
	public DAG(int V){
		if(V<0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V=V;
		this.E=0;
		indegree=new int[V];
		stack=new boolean[V];
		visited=new boolean[V];
		adj=(ArrayList<Integer>[]) new ArrayList[V];
		for(int v=0; v<V; v++)
		{
			adj[v]= new ArrayList<Integer>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
	return E;	
	}
	
	private void validateVertex(int v) {
		if(v<0||v>=V) {
			throw new IllegalArgumentException("vertex"+v+"is not between 0 and "+(V-1));
		}
	}
	
	public void addEdge(int v, int w)
	{
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
	
	public DAG reverse() {
		DAG reverse=new DAG(V);
		for(int v=0; v<V; v++) {
			for(int w:adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}
	
	public boolean cycleExists() {
		return cycleExists;
	}
	
	public void detectCycle(int v) {
		visited[v]=true;
		stack[v]=true;
		
		for(int w:adj(v)) {
			if(!visited[w]) 
			{
				detectCycle(w);
			}
			else if(stack[w]) 
			{
				cycleExists=true;
				return;
			}
		}
		stack[v]=false;
	}
	
	
	//Algorithms and data structures last year 
	public ArrayList<Integer> BFS(int s)
    {
        boolean hasBeenVisited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> order= new ArrayList<Integer>();

        hasBeenVisited[s]=true;
        queue.add(s);


        while (queue.size() != 0)
        {
            s = queue.poll();           
            order.add(s);
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!hasBeenVisited[n])
                {
                    hasBeenVisited[n] = true;
                    queue.add(n);
                }
            }
        }

        return order;

    }
	
	
}
//Using Sedgewick and Wayne's Digraph class 