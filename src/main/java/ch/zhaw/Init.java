package ch.zhaw;

import ch.zhaw.LogImpl.ErrorLog;
import ch.zhaw.LogImpl.NoLog;
import ch.zhaw.LogImpl.SimpleLog;

public class Init {

	private IWindow decoratedWindow;
	
	public Init() {
		Logger.setLog(new SimpleLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new NoLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new ErrorLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new SimpleLog());
		decoratedWindow = new SizeDecorator(new MenuBarDecorator(new SimpleWindow()));
		Logger.info(decoratedWindow.getDescription());
		decoratedWindow.getFrame().setVisible(true);
	}
	
	public void closeWindow() {
		decoratedWindow.getFrame().setVisible(false);
		decoratedWindow.getFrame().dispose();
	}
	
}
