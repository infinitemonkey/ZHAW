package ch.zhaw;

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
        MyObject obj = new MyObject();
        obj.setPosX(99);
        assertEquals(99, obj.getPosX());
    }
    
    public void testPosY() {
        MyObject obj = new MyObject();
        obj.setPosY(99);
        assertEquals(99, obj.getPosY());
    }
    
    public void testDurchmesser() {
        MyObject obj = new MyObject();
        obj.setDurchmesser(10);
        assertEquals(10, obj.getDurchmesser());
    }
    
}
