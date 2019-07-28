package javacoursemod5;

public abstract class Shape {

	private int xPos;
	private int yPos;

	public Shape() {

		xPos = 0;
		yPos = 0;
	}

	public Shape(int xPos, int yLoc) {

		this.xPos = xPos;
		yPos = yLoc;
	}

	public final int getX() {

		return xPos;
	}

	public final int getY() {

		return yPos;
	}

	public void moveTo(int newX, int newY) {

		xPos += newX;
		yPos += newY;
	}

	abstract public double getArea();
	
	abstract public double getPerimeter();

	public String toString() {

		return "(X,Y) Position: (" + xPos + "," + yPos + ") \n";
	}

}
