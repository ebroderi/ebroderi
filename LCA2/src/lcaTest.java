import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lcaTest {

	@Test
	public void testLowestCommonAncestor() {

	}

	@Test
	public void testPut() {
		lca<Integer, Integer> lca = new lca<Integer, Integer>();

		lca.put(5, null);
		lca.put(7, 7);
		lca.put(8, 8);     
		lca.put(3, 3);       
		lca.put(1, 1);      
		lca.put(2, 2);      
		lca.put(6, 6);       
		lca.put(4, 4);       
		lca.put(5, 5); 
		lca.put(5, 5); 

		assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", lca.printKeysInOrder());
	}
//From last year's assignment 
	@Test
	public void testSize() {

	}

	@Test	
	public void testDelete() {

	}

}
