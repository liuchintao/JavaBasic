package testjava.inh;

public class D {

	public int j = print("j");
	
	{
		print("Constructor block.");
	}
	
	static {
		A a3 = new A("a3");
	}
	
	static A a1 = new A("a1");
	
	public A a2 = new A("a2");
	
	public D() {
		a2 = new A("a4");
	}
	
	public static int print(String s) {
		System.out.println(s);
		return 0;
	}
}
