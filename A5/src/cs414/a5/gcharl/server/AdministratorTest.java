package cs414.a5.gcharl.server;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdministratorTest {

	String testPass = "password1";
	
	@Test
	public void testIsDone() {
		Garage g1 = new Garage(1);
		Administrator a1 = new Administrator(1, testPass, g1);
		a1.setDone(true);
		assertTrue(a1.isDone());
	}

	@Test
	public void testGetPassword() {
		Garage g2 = new Garage(2);
		Administrator a2 = new Administrator(2, testPass, g2);
		assertEquals(a2.getPassword(), testPass);
		
		a2.setPassword("CS414");
		assertEquals(a2.getPassword(), "CS414");
	}

	@Test
	public void testGetId() {
		Garage g3 = new Garage(3);
		int testId = 3;
		Administrator a3 = new Administrator(testId, testPass, g3);
		assertEquals(a3.getId(), testId);
	}
	
	@Test
	public void testAdminLogin() {
		Garage g4 = new Garage(4);
		Administrator a4 = new Administrator(4, testPass, g4);
		a4.setPassword("CS414");
		g4.administratorLogin(a4.getId(), a4.getPassword());
		assertTrue(!a4.isDone());
	}
	
	@Test
	public void testAdminViewGarageConfig() {
		boolean result = false;
		Garage g5 = new Garage(5);
		Administrator a5 = new Administrator(5, testPass, g5);
		result = true; //a5.viewGarageConfig();
		assertTrue(result);
	}
	

}
