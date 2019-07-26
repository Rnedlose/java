package javacoursemod5;

public class Triangle extends Shape {

	private int sideA, sideB, sideC;

	public Triangle() {

		super();
		sideA = sideB = sideC = 1;
	}

	public Triangle(int sideA, int sideB, int sideC) {

		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public double getPerimeter() {

		return sideA + sideB + sideC;
	}

	public double getArea() {

		double x = getPerimeter() / 2;
		return Math.sqrt(x * (x - sideA) * (x - sideB) * (x - sideC));
	}

	public String toString() {

		String str = "TRIANGLE \n" + super.toString() + "Side A: " + sideA + "Side B: " + sideB + "Side C: " + sideC
				+ "\n" + "Area: " + getArea();
		return str;
	}

}
