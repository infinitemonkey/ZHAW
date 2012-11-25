package ch.zhaw.window;

import javax.swing.JFrame;

public interface IWindow {

	public void draw();
	
	public String getDescription();
	
	public JFrame getFrame();
	
}
