package ch.zhaw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.zhaw.canvas.IObject;
import ch.zhaw.canvas.MyObject;
import ch.zhaw.simplePhysics.PhysicsHelper;

public class PhysicsHelpterTest {

	IObject obj = new MyObject();
	
	@Before
	public void setUp() throws Exception {
		obj.setPosX(100);
		obj.setPosY(100);
	}

	@Test
	public void testNewXPositionEven() {
		int actual = PhysicsHelper.calculateNewXPosition(obj.getPosX());
		
		assertEquals(105, actual);
	}

	@Test
	public void testNewYPositionEven() {
		int actual = PhysicsHelper.calculateNewYPosition(obj.getPosY());
		
		assertEquals(103, actual);
	}
	
	@Test
	public void testNewXPositionOdd() {
		obj.setPosX(PhysicsHelper.calculateNewXPosition(obj.getPosX()));
		int actual = PhysicsHelper.calculateNewXPosition(obj.getPosX());
		
		assertEquals(108, actual);
	}

	@Test
	public void testNewYPositionOdd() {
		obj.setPosY(PhysicsHelper.calculateNewYPosition(obj.getPosY()));
		int actual = PhysicsHelper.calculateNewYPosition(obj.getPosY());
		
		assertEquals(108, actual);
	}
	
	public void testForceCalculation() {
		obj.setCharge(100);
		IObject obj2 = new MyObject();
		obj2.setCharge(20);
		
		int actual = PhysicsHelper.calculateForce(obj.getCharge(), obj2.getCharge());
		
		assertEquals(1000, actual);
	}
}
