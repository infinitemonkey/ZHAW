package ch.zhaw.canvas;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyCanvas extends Canvas implements ICanvas {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<IObject> objects = new ArrayList<IObject>();
	
	private boolean pause = true;
	
	public MyCanvas() {
		addMouseListener(new Mouse());
	}
	
	public void paint(final Graphics g){
	    super.paint(g);
	    for (IObject obj : objects) {
	    	g.drawOval(obj.getPosX(), obj.getPosY(), obj.getDurchmesser(), obj.getDurchmesser());
	    }
	}
	
	public void start() {
		pause = false;
		Thread t = new Thread(new Step());
		t.start();
	}
	
	public void pause() {
		pause = true;
	}
	
	public void addObject(IObject object) throws NullPointerException {
		if (object == null) {
			throw new NullPointerException();
		}
		objects.add(object);
	}
	
	private void update() {
		this.repaint();
	}

	class Mouse implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent event) {
			if (pause) {
				int x = event.getPoint().x;
				int y = event.getPoint().y;
				for (IObject obj : objects) {
					if ((x > obj.getPosX() && x < obj.getPosX()+obj.getDurchmesser()) && (y > obj.getPosY() && y < obj.getPosY()+obj.getDurchmesser())) {
						((MyObject) obj).onClick(obj);
					}
			    }
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class Step implements Runnable{

		@Override
		public void run() {
			while (!pause) {
				try {
					for (IObject obj : objects) {
						obj.setPosX((int) (obj.getPosX()+Math.round(Math.random()*4)));
						obj.setPosY((int) (obj.getPosY()+Math.round(Math.random()*4)));
				    }
					
					update();
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
