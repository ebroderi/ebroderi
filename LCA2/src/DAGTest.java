import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

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
		hasCycle.addEdge(2,6);
		hasCycle.detectCycle(2);
		assertTrue(hasCycle.cycleExists());
	}

}
