package com.insurance;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); // Scanner used to get input from User

		String firstName = "";
		String lastName = "";
		String birthDate = "";
		String contactFirst = "";
		String contactLast = "";
		String userChoice = "y";

		double weight = 0;
		double height = 0;

		Queue<String> names = new LinkedList<>();

		try {

			// Enter the information for all patients
			// The program will loop through many different entries
			// Will prompt User to enter Y or y to enter a new patient, q to quit

			while (userChoice.equals("y") || userChoice.equals("Y")) {

				String userEntry = "";

				System.out.println("Please enter Y or y to begin entering new applicants.");

				System.out.println("(Or press q to exit.)");

				userEntry = scan.next();

				if (userEntry.equals("Y") || userEntry.equals("y")) {

					System.out.println("Enter information for the new insurance applicant."); // Program purpose

					while (firstName.isEmpty()) { // The isEmpty method will make sure that there is user input, if
													// there is
													// none, the field is empty, while loop loops back until string is
													// entered
						System.out.println("Please enter the applicants first name: ");
						firstName = scan.next();
					}

					while (lastName.isEmpty()) {
						System.out.println("Please enter the applicants last name: ");
						lastName = scan.next();
					}

					while (birthDate.isEmpty()) {
						try {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							System.out.println("Please enter the applicants birthdate as format MM/dd/yyyy: ");
							birthDate = scan.next();
							formatter.parse(birthDate);
						} catch (Exception e) {
							birthDate = ""; // If invalid input, reset birthDate variable to access our loop condition
											// again
						}
					}

					while (weight <= 0) {
						try {
							System.out.println("Please enter the applicants weight in pounds: ");
							weight = Double.parseDouble(scan.next());
						} catch (InputMismatchException e) {
							scan.next();
							weight = 0;
						}
					}

					while (height <= 0) {
						try {
							System.out.println("Please enter the applicants height in inches: ");
							height = Double.parseDouble(scan.next());
						} catch (InputMismatchException e) {
							scan.next();
							height = 0;
						}
						while (contactFirst.isEmpty()) {
							System.out.println("Please enter the applicants Emergency Contact First Name: ");
							contactFirst = scan.next();
						}
						while (contactLast.isEmpty()) {
							System.out.println("Please enter the applicants Emergency Contact Last Name: ");
							contactLast = scan.next();
						}

					}

					Person person = new Person(firstName, lastName, contactFirst, contactLast, birthDate, weight,
							height); // Create
					// our
					// person
					// object

					// Add Names to our Queue
					names.add(firstName + " " + lastName);

					CalcBmi calcBmi = new CalcBmi(weight = person.getWeight(), height = person.getHeight()); // Create
																												// our
																												// CalcBmi
																												// object

					// Our File Writer objects
					BufferedWriter bw = null;
					FileWriter fw = null;

					try {

						// The file we are going to create, or append to if the file already exists
						File file = new File("Applicants.txt");

						// If the file doesn't exist, create it
						if (!file.exists()) {

							file.createNewFile();
						}

						// Instantiate our file writer objects
						fw = new FileWriter(file.getAbsoluteFile(), true);
						bw = new BufferedWriter(fw);

						calcBmi.setBmi(); // Set's the bmi of the entered person

						// Print out to console and to the file

						bw.write("\n" + "Patient ID number: " + person.setPatientID() + ".");
						bw.write("\n" + "Applicants First Name: " + person.getFirstName() + ".");
						bw.write("\n" + "Applicants Last Name: " + person.getLastName() + ".");
						bw.write("\n" + "Applicants Emergency Contact Name: " + person.setEmergencyContact() + ".");
						bw.write("\n" + "Birthdate is: " + person.getBirthdate() + ".");
						bw.write("\n" + "Height is: " + person.getHeight() + " inches.");
						bw.write("\n" + "Weight is: " + person.getWeight() + " pounds.");
						bw.write("\n" + "BMI is: " + (calcBmi.getBmi()) + ".");
						bw.write("\n" + "BMI Category is: " + (calcBmi.getBmiCategory()));
						bw.write("\n" + "Insurance Premium Category is: " + (calcBmi.getInsPremCate()) + "\n");

					} catch (IOException e) {

						e.printStackTrace();

					} catch (NoSuchElementException e) {

						e.printStackTrace();

					} finally {

						// close out our resources

						try {
							if (bw != null)
								bw.close();

							if (fw != null)
								fw.close();

						} catch (IOException e) {

							e.printStackTrace();
						}

					}

					// Reset variables before the next loop
					firstName = "";
					lastName = "";
					birthDate = "";
					contactFirst = "";
					contactLast = "";
					userEntry = "";
					weight = 0;
					height = 0;

				} else if (userEntry.equals("q")) { // This exits the program

					// Using our queue, the program will print each name added to the file
					// out to the console, and then remove all names from the queue
					System.out.println("Exiting program.  The following applicants were added to the file: ");

					try {
						names.forEach(name -> {
							System.out.println(name);
						});
						names.removeAll(names);

					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				} else // If the user enters anything other than y, Y, or q, then the program just
						// repeats from the beginning
					continue;

			}

		}

		finally { // close our scanner object
			scan.close();
		}

	}

}
