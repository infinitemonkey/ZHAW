package ch.zhaw;

import javax.swing.JFrame;

public class SizeDecorator extends WindowDecorator {
   
	public SizeDecorator (IWindow decoratedWindow) {
        super(decoratedWindow);
        draw();
    }
 
    @Override
    public void draw() {
        decoratedWindow.draw();
        drawSize();
    }
 
    private void drawSize() {
    	Logger.info("SimpleWindow: SizeDecorator: drawSize()");
    	decoratedWindow.getFrame().setBounds(100, 100, 600, 400);
    	decoratedWindow.getFrame().invalidate();
    }
 
    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", + Size";
    }

	@Override
	public JFrame getFrame() {
		return decoratedWindow.getFrame();
	}
}
