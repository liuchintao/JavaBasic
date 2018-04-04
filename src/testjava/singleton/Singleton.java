package testjava.singleton;

public class Singleton {
	private static Singleton instance = null;
	private static String str;
	private Singleton() {
		str = "str";
	}
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public static void print() {
		System.out.println(str);
	}
}
