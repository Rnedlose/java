package javacoursemod4;

import java.util.*;
import java.io.*;

public class CrimeRecords {
	
	// This program takes the given csv file
	// reads it, analyzes the data from it
	// then totals the number of each specific crime
	// and sends the data back out to a new csv file

	public static void main(String[] args) {
		
		// Variable to hold our file name
		String fileName = "mod04_dataset.csv";
		
		// Create file objects we will be using
		File fileIn = new File(fileName);
		File fileOut = new File("Crime_Totals.csv");
		
		// This is an arraylist of objects of type Record
		// We make the class Record below
		ArrayList<Record> records = new ArrayList<>();
		
		// Scanner to read in our csv file
		Scanner scan;
		
		// Try catch to attempt to read file
		try {

			scan = new Scanner(fileIn);

			while (scan.hasNext()) {
				String line = scan.nextLine();

				String[] values = line.split(",");

				String year = values[0];
				String cenTract = values[1];
				String crimeType = values[2];
				String yearTotal = values[3];
				
				// Create an object each iteration of the loop and save it in the arraylist
				Record record = new Record(year, cenTract, crimeType, yearTotal);

				records.add(record);
			}

			scan.close();
		
		// Exception handling
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		// Another try catch block, this time for analyzing the data from the
		// csv file and then attempting to write the file out to a new csv file
		try {

			int t1 = 0;
			int t2 = 0;
			int t3 = 0;
			int t4 = 0;
			int t5 = 0;
			int t6 = 0;
			int t7 = 0;
			int t8 = 0;
			int t9 = 0;
			int t10 = 0;
			
			// loop through the arraylist
			for (int i = 0; i < records.size(); i++) {
				
				// If statements to tally running totals
				if (records.get(i).getCrimeType().equals("Aggravated Assault")) {
					t1 = t1 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Homicide")) {
					t2 = t2 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("NonResidential Burglary")) {
					t3 = t3 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Property Crimes Total")) {
					t4 = t4 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Rape")) {
					t5 = t5 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Residential Burglary")) {
					t6 = t6 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Robbery")) {
					t7 = t7 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Theft")) {
					t8 = t8 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Vehicle Theft")) {
					t9 = t9 + Integer.parseInt(records.get(i).getReportYearTotal());

				} else if (records.get(i).getCrimeType().equals("Violent Crimes Total")) {
					t10 = t10 + Integer.parseInt(records.get(i).getReportYearTotal());

				}

			}
			
			// Create our filewriter to write to a file
			// Variables
			// Then append the data we want to the new file
			
			final String FILE_HEADER = "Crime Type, Total";
			final String COMMA_DELIMITER = ",";
			final String NEW_LINE_SEPARATOR = "\n";
			final String A = "Aggravated Assault";
			final String B = "Homicide";
			final String C = "NonResidential Burglary";
			final String D = "Property Crimes Total";
			final String E = "Rape";
			final String F = "Residential Burglary";
			final String G = "Robbery";
			final String H = "Theft";
			final String I = "Vehicle Theft";
			final String J = "Violent Crimes Total";

			FileWriter fw = new FileWriter(fileOut);
			fw.append(FILE_HEADER.toString());
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(A.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t1));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(B.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t2));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(C.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t3));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(D.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t4));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(E.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t5));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(F.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t6));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(G.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t7));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(H.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t8));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(I.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t9));
			fw.append(NEW_LINE_SEPARATOR);
			fw.append(J.toString());
			fw.append(COMMA_DELIMITER);
			fw.append(String.valueOf(t10));

			fw.flush();
			fw.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	// Here is our Record class
	public static class Record {

		private String reportYear;
		private String censusTract;
		private String crimeType;
		private String reportYearTotal;

		public Record(String reportYear, String censusTract, String crimeType, String reportYearTotal) {
			super();
			this.reportYear = reportYear;
			this.censusTract = censusTract;
			this.crimeType = crimeType;
			this.reportYearTotal = reportYearTotal;
		}

		public String getReportYear() {
			return reportYear;
		}

		public void setReportYear(String reportYear) {
			this.reportYear = reportYear;
		}

		public String getCensusTract() {
			return censusTract;
		}

		public void setCensusTract(String censusTract) {
			this.censusTract = censusTract;
		}

		public String getCrimeType() {
			return crimeType;
		}

		public void setCrimeType(String crimeType) {
			this.crimeType = crimeType;
		}

		public String getReportYearTotal() {
			return reportYearTotal;
		}

		public void setReportYearTotal(String reportYearTotal) {
			this.reportYearTotal = reportYearTotal;
		}

	}
}
