package ch.zhaw;

public abstract class WindowDecorator implements IWindow {

	protected IWindow decoratedWindow;
	 
    public WindowDecorator (IWindow decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }
    
    public void draw() {
        decoratedWindow.draw();
    }
    
    public String getDescription() {
        return decoratedWindow.getDescription();
    }
}
