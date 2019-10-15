import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	
	@Test
	public void testConstructor() {
		DAG testDAG= new DAG(7);
		testDAG.addEdge(2,4);
		testDAG.addEdge(2,3);
		testDAG.addEdge(3,6);
		testDAG.addEdge(4,6);
		testDAG.addEdge(6,7);
	
		assertEquals("",2,testDAG.indegree(6));
		assertEquals("",1,testDAG.outdegree(4));
		assertEquals("",4,testDAG.E());
		assertEquals("",7,testDAG.V());
	}
	
	
	@Test
	public void testAddEdge() {
		DAG addEdgeTest=new DAG(7);
		addEdgeTest.addEdge(1, 2);
		assertEquals("Testing number of edges equals one", 1, addEdgeTest.E());
		addEdgeTest.addEdge(2, 5);
		assertEquals("Testing number of edges equals two", 2, addEdgeTest.E());
		addEdgeTest.addEdge(-5, -3);
		assertEquals("Testing number of edges equals two", 2, addEdgeTest.E());
		addEdgeTest.addEdge(4, 6);
		assertEquals("Testing number of edges equals three", 3, addEdgeTest.E());
		
	}
	
	@Test
	public void testForCycle() {
		DAG hasCycle=new DAG(10);
		hasCycle.addEdge(2, 4);
		hasCycle.addEdge(4,6);
		hasCycle.addEdge(6,2);
		hasCycle.detectCycle(2);
		assertTrue(hasCycle.cycleExists());
	}
	
	

}
