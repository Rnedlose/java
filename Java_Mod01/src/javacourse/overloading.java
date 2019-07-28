package javacourse;

public class overloading {
	public void test1() {
		System.out.println("This is the first version of the method.");
		
	}
	// here is the same method name, with parameters
	public void test1(int num) {
		System.out.println("This is the " + num + " version of the method.");
	}
}
