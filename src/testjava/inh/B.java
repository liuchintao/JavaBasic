package testjava.inh;

public class B {
	String name ;
	
	public B(String b) {
		this.name = b;
	}
	public String getName() {
		return name;
	}
	public void demarre() {
		System.out.println(getName()+" demarre ");
	}
}
