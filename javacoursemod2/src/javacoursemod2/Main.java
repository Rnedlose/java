package javacoursemod2;

//Need to import java.util
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
	
		// Scanner
		Scanner scan = new Scanner(System.in);
	
		// Variables used later
		int sum = 0;
		int average = 0;
		int userInput = -1;
		
		try {
			// Array initialized with indexes 0-999 (1000)
			int[] numbers = new int[1000];
		
			// For loop to populate array with random integers between 1 and 10000
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = (int)(Math.random()*9999 + 1);
			}
		
			// Get user input to choose an index in the array to see the value in that index
		
			while(userInput == -1) {
				try {
					System.out.println("Please choose a number between 1-999");
					userInput = scan.nextInt();
					System.out.println(numbers[userInput]); 
				}	
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Array index out of bounds.");
					userInput = -1;
					continue;
				}
			}
			// Sort the array
			Arrays.sort(numbers);
		
			// Print out the max and min values in the array
			System.out.println("Min number is: " + numbers[0]);
			System.out.println("Max number is: " + numbers[999]);
		
			// Print out the array average
			for(int i = 0; i < numbers.length; i++) {
			
				// Add up all values in the array
				sum = sum + numbers[i];
			}
			
			// Get average
			average = sum / numbers.length;
			
			System.out.println("The average is: " + average + ".");
			
		}
		finally {
			scan.close();
		}
	}
}