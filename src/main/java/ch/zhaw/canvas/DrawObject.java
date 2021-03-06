package ch.zhaw.canvas;

public class DrawObject {

	private int posX = 5;
	private int posY = 5;
	
	private int radius = 10;

	public DrawObject(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString()
	{
		return String.format("posX = {0}, posY = {1}, radius = {2}", posX, posY, radius);
	}
	
}
