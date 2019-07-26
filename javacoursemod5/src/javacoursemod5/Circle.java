package javacoursemod5;

public class Circle extends Shape {

	private int radius;

	public Circle() {

		super();
		radius = 1;
	}

	public Circle(int xLoc, int yLoc, int radius) {

		super(xLoc, yLoc);
		this.radius = radius;
	}

	public int getRadius() {

		return radius;
	}

	public double getArea() {

		return Math.PI * radius * radius;
	}

	public double getPerimeter() {

		return 2 * Math.PI * radius;
	}

	public String toString() {

		String str = "CIRCLE \n" + super.toString() + "Radius: " + radius + "\n" + "Area: " + getArea();
		return str;
	}

}
