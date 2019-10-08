import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

class lcaTest {

	@Test
	public void testLowestCommonAncestor() {
		lca<Integer, Integer> lca = new lca<Integer, Integer>();

		assertSame("Testing LCA for null root", null, lca.lowestCommonAncestor(lca.root, 1, 2));

		lca.put(7, 7);  
		lca.put(8, 8);   
		lca.put(3, 3);  
		lca.put(1, 1); 
		lca.put(2, 2);   
		lca.put(6, 6);   
		lca.put(4, 4);   
		lca.put(5, 5);   
		
		assertSame("Test left side", 3, lca.lowestCommonAncestor(lca.root, 2,6));
		assertSame("Test right side", 7, lca.lowestCommonAncestor(lca.root, 8,3));
		assertSame("Test where LCA is one of the nodes", 7, lca.lowestCommonAncestor(lca.root, 7,8));
		
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
		lca<Integer, Integer> lca = new lca<Integer, Integer>();
		assertEquals(0, lca.size());

		lca.put(1, 1); 
		assertEquals(1, lca.size());

		lca.put(2, 2);     
		lca.put(3, 3);       
		lca.put(4, 4);      
		lca.put(5, 5);      
		lca.put(6, 6);       
		lca.put(7, 7);       
		lca.put(8, 8); 
		assertEquals(8, lca.size());
	}
	//From last year's assignment
	@Test	
	public void testDelete() {
		lca<Integer, Integer> lca = new lca<Integer, Integer>();


		lca.put(7, 7);   
		lca.put(8, 8);   
		lca.put(3, 3);   
		lca.put(1, 1);  
		lca.put(2, 2);  
		lca.put(6, 6);   
		lca.put(4, 4);   
		lca.put(5, 5);  

		lca.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", lca.printKeysInOrder());

	}
	//From last year's assignment

}
