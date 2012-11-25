package ch.zhaw.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

import ch.zhaw.log.Logger;

public class CustomCanvas extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private boolean stop = false;
	private ArrayList<DrawObject> objects = new ArrayList<DrawObject>();
	
	public CustomCanvas() {
		for (int i = 0; i < 10; i++) {
			objects.add(new DrawObject());
		}
		Thread t = new Thread(new Step());
		t.start();
	}
	
	public void paint(final Graphics g){
	    super.paint(g);
	    Logger.info("paint g="+g);
	    for (DrawObject obj : objects) {
	    	g.drawOval(obj.getPosX(), obj.getPosY(), obj.getRadius(), obj.getRadius());
	    }
	}
	
	private void update() {
		this.repaint();
	}
	
	class Step implements Runnable{

		@Override
		public void run() {
			while (!stop) {
				try {
					for (DrawObject obj : objects) {
						obj.setPosX((int) (obj.getPosX()+Math.round(Math.random()*4)));
						obj.setPosY((int) (obj.getPosY()+Math.round(Math.random()*4)));
				    }
					
					update();
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
