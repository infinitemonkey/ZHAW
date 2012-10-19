package ch.zhaw;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class LoginTest {

	Mockery context;
    /** instance under test */
	Login instance;
	/** dependency */
	Datenbank datenbank;
	
    @Before
    public void init() {
    	context = new JUnit4Mockery();
        instance = new Login();
    }

    @After
    public void clear() {
        instance = null;
    }

    @BeforeClass
    public static void beforeEverything() {
    }

    @AfterClass
    public static void cleanUp() {
    }

    @Test
    public void doesLoginExist() {
        assertNotNull(instance);
    }
    
    @Test
    public void setGetDatenbank() {
    	final IFDatenbank datenbank = context.mock(IFDatenbank.class);
    	instance.setDatenbank(datenbank);
    	assertNotNull(instance.getDatenbank());
    	assertSame(datenbank, instance.getDatenbank());
    	instance.setDatenbank(null);
    	assertNull(instance.getDatenbank());
    }
    
    @Test(expected=NullPointerException.class) 
    public void doLoginWithOutDB() {
    	instance.setDatenbank(null);
    	instance.doLogin();
    }
    
    @Test
    public void doLogin() {
    	final IFDatenbank datenbank = context.mock(IFDatenbank.class);
    	context.checking(new Expectations() {{
            one (datenbank).connectDB(); will(returnValue(true));
            one (datenbank).connectDB(); will(returnValue(false));
        }});
    	instance.setDatenbank(datenbank);
    	assertTrue(instance.doLogin());
    	assertFalse(instance.doLogin());
    }
    
    
    

}
