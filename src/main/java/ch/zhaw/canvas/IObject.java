package ch.zhaw.canvas;

public interface IObject {
	public void setPosX(int posX);
	public int getPosX();

	public void setPosY(int posY);
	public int getPosY();

	public void setDurchmesser(int durchmesser);
	public int getDurchmesser();

	public void setObjClickListener(ObjListener objListener);
}
