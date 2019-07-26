import java.io.*;
import java.util.*;

public class Sched {

	public Sched() {
		super();

	}

	public static String[] schedEntry(String[] arr) {

		String userEntry;
		Scanner s = new Scanner(System.in);
		File f = new File("schedule.xlsx");
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			if (!f.exists()) {

				f.createNewFile();
			}

			fw = new FileWriter(f.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			
			System.out.println("What day are you scheduling for?: ");
			userEntry = s.next();
			bw.write(userEntry);
			System.out.println("Is it for the AM or PM shift?: ");
			userEntry = s.next();
			bw.write(" " + userEntry);

			for (int i = 0; i <= arr.length - 1; i++) {
				System.out.println("Schedule a server (Enter a name):");
				arr[i] = s.next();
				bw.write("\n The server is: " + arr[i]);}
			bw.write("\n");

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return arr;
	}

}
