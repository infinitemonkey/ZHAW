package ch.zhaw;

import ch.zhaw.canvas.IObject;
import ch.zhaw.canvas.MyObject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MyObjectTest extends TestCase {
   
    public MyObjectTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( MyObjectTest.class );
    }

    public void testPosX() {
    	IObject obj = new MyObject();
        obj.setPosX(99);
        
        assertEquals(99, obj.getPosX());
    }
    
    public void testPosY() {
    	IObject obj = new MyObject();
        obj.setPosY(99);
        
        assertEquals(99, obj.getPosY());
    }
    
    public void testDurchmesser() {
    	IObject obj = new MyObject();
        obj.setDurchmesser(10);
        
        assertEquals(10, obj.getDurchmesser());
    }
    
    public void testObjectConstructor()
    {
    	IObject obj = new MyObject(10, 20, 30);
    	
    	assertEquals(10, obj.getPosX());
    	assertEquals(20, obj.getPosY());
    	assertEquals(30, obj.getDurchmesser());
    }
    
}
