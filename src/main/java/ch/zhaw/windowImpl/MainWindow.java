package ch.zhaw.windowImpl;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.canvas.CustomCanvas;
import ch.zhaw.log.Logger;
import ch.zhaw.window.IWindow;

public class MainWindow implements IWindow {

	private JFrame frame;
	private JPanel canvasPanel;
	private CustomCanvas canvas;
	
	public MainWindow(CustomCanvas canvas) {
		Logger.info("INIT: SimpleWindow");
		this.canvas = canvas;
		drawWindow();
		drawCanvas();
	}
	
	private void drawWindow() {
		frame = new JFrame("Physikalische Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Setzt das Layout vom Frame und vom Panel */
		frame.setLayout(new BorderLayout(800,600));
		canvasPanel = new JPanel();
		canvasPanel.setLayout(new BorderLayout(400,200));
	     
	    /* Hier können wir dan unser Canvas auf das Panel platzieren */
		canvasPanel.add(canvas, BorderLayout.CENTER);
	    /* und natürlich noch das Panel auf das Frame */
	    frame.add(canvasPanel, BorderLayout.CENTER);
	     
	}
	
	private void drawCanvas() {
		canvas = new CustomCanvas();
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
