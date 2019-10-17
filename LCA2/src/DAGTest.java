import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	
	@Test
	public void testConstructor() {
		DAG testDAG= new DAG(8);
		testDAG.addEdge(2,4);
		testDAG.addEdge(2,3);
		testDAG.addEdge(3,6);
		testDAG.addEdge(4,6);
		testDAG.addEdge(6,7);
	
		assertEquals("",2,testDAG.indegree(6));
		assertEquals("",1,testDAG.outdegree(4));
		assertEquals("",5,testDAG.E());
		assertEquals("",8,testDAG.V());
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
		
		DAG noCycle=new DAG(10);
		noCycle.addEdge(2, 4);
		noCycle.addEdge(4, 6);
		noCycle.addEdge(5, 6);
		noCycle.detectCycle(2);
		assertFalse(noCycle.cycleExists());
		
		
	}
	
	@Test 
	public void testLCA() {
		DAG lca=new DAG(10);
		 lca.addEdge(0, 1);
		 lca.addEdge(0, 2);
		 lca.addEdge(1, 3);
		 lca.addEdge(2, 4);
		 lca.addEdge(3, 5);
		 lca.addEdge(4, 5);
		 lca.addEdge(5, 6);
		 lca.addEdge(5, 7);
		 lca.addEdge(6, 8);
		 lca.addEdge(7, 8);
		 lca.addEdge(8, 9);
		 
		 assertEquals("LCA for 1 and 2", 0, lca.findLCA(1, 2));
		 assertEquals("LCA for 6 and 7", 5, lca.findLCA(6, 7));
		 assertEquals("LCA for 3 and 4", 0, lca.findLCA(3,4));
		 assertEquals("LCA for 8 and 9", 8, lca.findLCA(8, 9));
		 assertEquals("LCA for 5 and 9", 5, lca.findLCA(5, 9));
		 
	}
	
	public void noCommonAncestorsTest() {
		DAG lca=new DAG(8);
		lca.addEdge(0, 1);
		lca.addEdge(0, 2);
		lca.addEdge(1, 3);
		lca.addEdge(3, 4);
		lca.addEdge(3, 5);
		lca.addEdge(4, 6);
		lca.addEdge(5, 6);
		
		assertEquals("LCA for 1 and 2", 0, lca.findLCA(1, 2));
		assertEquals("LCA for 3 and 4", 1, lca.findLCA(3, 4));
		assertEquals("LCA when node doesn't exist", -1, lca.findLCA(5, 7));
	}

}
