package javacoursemod2;

import java.util.*;

public class Sort {

	public static void SortArray(int toSort[]) {
		Arrays.sort(toSort);
		System.out.printf("Here is the sorted Array of Integers : %s" ,
				Arrays.toString(toSort));
	}
}
