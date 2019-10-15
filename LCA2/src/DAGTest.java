import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	@Test
	public void testAddEdge() {
		DAG addEdgeTest=new DAG(7);
		addEdgeTest.addEdge(1, 2);
		assertEquals("Testing number of egdes equals one", 1, addEdgeTest.E());
		addEdgeTest.addEdge(2, 5);
		assertEquals("Testing number of egdes equals two", 2, addEdgeTest.E());
		addEdgeTest.addEdge(-5, -3);
		assertEquals("Testing number of egdes equals two", 2, addEdgeTest.E());
	}

}
