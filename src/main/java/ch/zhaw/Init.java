package ch.zhaw;

import ch.zhaw.canvas.MyCanvas;
import ch.zhaw.canvas.IObject;
import ch.zhaw.canvas.MyObject;
import ch.zhaw.canvas.ICanvas;
import ch.zhaw.canvas.ObjListener;
import ch.zhaw.log.Logger;
import ch.zhaw.logImpl.ErrorLog;
import ch.zhaw.logImpl.NoLog;
import ch.zhaw.logImpl.SimpleLog;
import ch.zhaw.window.IWindow;
import ch.zhaw.windowImpl.MenuBarDecorator;
import ch.zhaw.windowImpl.MainWindow;
import ch.zhaw.windowImpl.SizeDecorator;

public class Init implements ObjListener{

	private IWindow decoratedWindow;
	private ICanvas canvas;
	
	public Init() {
		Logger.setLog(new SimpleLog());
		canvas = new MyCanvas();
		
		IObject obj = new MyObject();
		obj.setObjClickListener(this);
		canvas.addObject(obj);
		
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
		
		
		//canvas.start();
	}
	
	public void closeWindow() {
		decoratedWindow.getFrame().setVisible(false);
		decoratedWindow.getFrame().dispose();
	}

	@Override
	public void onClick(IObject obj) {
		Logger.info("Klick auf Object obj="+obj);
	}
	
}
