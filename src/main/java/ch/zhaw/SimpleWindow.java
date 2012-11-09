package ch.zhaw;

import javax.swing.JFrame;

public class SimpleWindow implements IWindow {

	private JFrame frame;
	
	public SimpleWindow() {
		Logger.info("INIT: SimpleWindow");
		frame = new JFrame("Physikalische Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void draw() {
	}

	@Override
	public String getDescription() {
		return "SimpleWindow";
	}

	@Override
	public JFrame getFrame() {
		Logger.info("SimpleWindow: getFrame()");
		return frame;
	}

}
