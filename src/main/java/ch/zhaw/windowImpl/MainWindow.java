package ch.zhaw.windowImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.canvas.ICanvas;
import ch.zhaw.canvas.ObjListener;
import ch.zhaw.log.Logger;
import ch.zhaw.window.IWindow;

public class MainWindow implements IWindow {

	private JFrame frame;
	private JPanel canvasPanel;
	private ICanvas canvas;
	
	public MainWindow(ICanvas canvas) {
		Logger.info("INIT: SimpleWindow");
		this.canvas = canvas;
		drawWindow();
	}
	
	private void drawWindow() {
		frame = new JFrame("Physikalische Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Setzt das Layout vom Frame und vom Panel */
		frame.setLayout(new BorderLayout(800,600));
		canvasPanel = new JPanel();
		canvasPanel.setLayout(new BorderLayout(400,200));
	     
	    /* Hier k�nnen wir dan unser Canvas auf das Panel platzieren */
		canvasPanel.add((Component) canvas, BorderLayout.CENTER);
	    /* und nat�rlich noch das Panel auf das Frame */
	    frame.add(canvasPanel, BorderLayout.CENTER);
	     
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
