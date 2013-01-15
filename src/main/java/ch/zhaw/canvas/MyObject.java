package ch.zhaw.canvas;

public class MyObject implements IObject, ObjClickListener {

	private ObjListener objListener;
	
	private int posX = 5;
	private int posY = 5;
	
	private int charge = 1000;
	
	private int durchmesser = 10;

	public MyObject() {
		
	}
	
	public MyObject(int posX, int posY, int durchmesser, int charge) {
		this.posX = posX;
		this.posY = posY;
		this.durchmesser = durchmesser;
		this.charge = charge;
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

	public int getDurchmesser() {
		return durchmesser;
	}

	public void setDurchmesser(int durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	public void setObjClickListener(ObjListener objListener) {
		this.objListener = objListener;
	}

	@Override
	public void onClick(IObject obj) {
		if (objListener != null) {
			objListener.onClick(obj);
		}
	}

	@Override
	public int getCharge() {
		return this.charge;
	}

	@Override
	public void setCharge(int charge) {
		this.charge = charge;
	}
	
}
