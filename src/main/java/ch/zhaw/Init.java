package ch.zhaw;

import ch.zhaw.canvas.CustomCanvas;
import ch.zhaw.log.Logger;
import ch.zhaw.logImpl.ErrorLog;
import ch.zhaw.logImpl.NoLog;
import ch.zhaw.logImpl.SimpleLog;
import ch.zhaw.window.IWindow;
import ch.zhaw.windowImpl.MenuBarDecorator;
import ch.zhaw.windowImpl.MainWindow;
import ch.zhaw.windowImpl.SizeDecorator;

public class Init {

	private IWindow decoratedWindow;
	private CustomCanvas canvas;
	
	public Init() {
		Logger.setLog(new SimpleLog());
		canvas = new CustomCanvas();
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new NoLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new ErrorLog());
    	Logger.info("Dies ist ein Infotext");
    	Logger.error("Dies ist ein Errortext");
    	Logger.setLog(new SimpleLog());
		decoratedWindow = new SizeDecorator(new MenuBarDecorator(new MainWindow(canvas)));
		Logger.info(decoratedWindow.getDescription());
		decoratedWindow.getFrame().setVisible(true);
	}
	
	public void closeWindow() {
		decoratedWindow.getFrame().setVisible(false);
		decoratedWindow.getFrame().dispose();
	}
	
}
