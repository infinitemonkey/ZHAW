package ch.zhaw.windowImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

import ch.zhaw.canvas.ICanvas;
import ch.zhaw.canvas.ObjListener;
import ch.zhaw.log.Logger;
import ch.zhaw.window.IWindow;

public class MainWindow implements IWindow {

	private JFrame frame;
	private JPanel canvasPanel;
	private ICanvas canvas;
	private JTextArea infoTextArea;
	
	public MainWindow(ICanvas canvas) {
		Logger.info("INIT: SimpleWindow");
		this.canvas = canvas;
		drawWindow();
	}
	
	private void drawWindow() {
		frame = new JFrame("Physikalische Simulation");
		frame.setSize(500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		canvasPanel = new JPanel();
		canvasPanel.setLayout(new BorderLayout());
		canvasPanel.setSize(500, 500);
		canvasPanel.setBackground(Color.CYAN);
		canvasPanel.add((Component) canvas, BorderLayout.CENTER);
		
		infoTextArea = new JTextArea();
		infoTextArea.setSize(500, 200);
		
	    frame.add(canvasPanel, BorderLayout.CENTER);
	    frame.add(infoTextArea, BorderLayout.SOUTH);     
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
