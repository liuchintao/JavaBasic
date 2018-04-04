package testjava.inh;

public class C extends B{
	String name;
	
	public C(String c) {
		super("B");
		this.name=c;
	}
	public String getName() {
		return name;
	}
	public void demarreWithSuper() {
		System.out.println(super.getName() + " demarre ");
	}
	public void demarreNoSuper() {
		System.out.println(getName() + " demarre ");
	}
}
