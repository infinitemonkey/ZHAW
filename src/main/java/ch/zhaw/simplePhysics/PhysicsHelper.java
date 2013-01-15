package ch.zhaw.simplePhysics;

public class PhysicsHelper {
	
	public static int calculateNewXPosition(int oldPosition)
	{
		int offset = oldPosition % 2 == 0 ? 5 : 3;
		return (int) (oldPosition + offset);
	}
	
	public static int calculateNewYPosition(int oldPosition)
	{
		int offset = oldPosition % 2 == 0 ? 3 : 5;
		return (int) (oldPosition + offset);
	}
}
