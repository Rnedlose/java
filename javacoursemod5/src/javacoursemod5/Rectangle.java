package javacoursemod5;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle() {

		super();
		width = height = 0;
	}

	public Rectangle(int xLoc, int yLoc, int width, int height) {

		super(xLoc, yLoc);
		this.width = width;
		this.height = height;
	}

	public double getArea() {

		return width * height;
	}

	public double getPerimeter() {

		return 2 * (width + height);
	}

	public String toString() {

		String str = "RECTANGLE \n" + super.toString() + "Width & Height: " + width + " " + height + "\n" + "Area: "
				+ getArea();
		return str;
	}
}
