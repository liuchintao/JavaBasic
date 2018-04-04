package testjava.singleton;

public class Test {
	public static void main(String[] args) {
		Singleton.print();
//		Singleton instance = new Singleton();
//		Singleton.print();
		Singleton instance1 = Singleton.getInstance();
		Singleton.print();
		Singleton instance2 = Singleton.getInstance();
		Singleton.print();
//		System.out.println(instance == instance1);
//		System.out.println(instance == instance2);
		System.out.println(instance1 == instance2);
	}
}
