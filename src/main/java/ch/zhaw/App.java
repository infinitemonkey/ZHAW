package ch.zhaw;

import ch.zhaw.LogImpl.NoLog;
import ch.zhaw.LogImpl.SimpleLog;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logger.setLog(new SimpleLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new NoLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    }
}
