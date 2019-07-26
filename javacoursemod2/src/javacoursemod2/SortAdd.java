package javacoursemod2;

public class SortAdd extends Sort {

	public static void AddNums(int toSort[]) {
		int sum = 0;
		for (int i : toSort)
			sum += i;
		System.out.println("The total of the Integers entered is : " + sum);
	}

}
