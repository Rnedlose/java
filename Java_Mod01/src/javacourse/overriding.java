package javacourse;

public class overriding {
	public void test2() {
		System.out.println("Override me.");
	}

public class overridden extends overriding{
	public void test2() {
		System.out.println("Overridden.");
	}
}
}
