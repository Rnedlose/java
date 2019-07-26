package javacoursemod5;

import java.util.Scanner;

public class TestShapes {

	public static void main(String[] args) {

		// Need a scanner
		Scanner scan = new Scanner(System.in);

		// Some variables
		int rad, width, height, sideA, sideB, sideC;

		// Exception handling
		try {

			System.out.println("Let's find the area for some different shapes.");
			System.out.println("First up, area of a circle. Please enter the radius of a circle: ");
			rad = scan.nextInt();
			Circle circle = new Circle(1, 1, rad);
			System.out.println(circle.toString());

			System.out.println("Next, the area of a rectangle.");
			System.out.println(" Please enter the width of a rectangle: ");
			width = scan.nextInt();
			System.out.println("Please enter the height of a rectangle: ");
			height = scan.nextInt();
			Rectangle rectangle = new Rectangle(1, 1, width, height);
			System.out.println(rectangle.toString());

			System.out.println("Lastly, let's find the area for a triangle.");
			System.out.println("Please enter the length of side A:");
			sideA = scan.nextInt();
			System.out.println("Please enter the length of side B:");
			sideB = scan.nextInt();
			System.out.println("Please enter the length of side C:");
			sideC = scan.nextInt();
			Triangle triangle = new Triangle(sideA, sideB, sideC);
			System.out.println(triangle.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// Close resources
			scan.close();
		}
	}
}
