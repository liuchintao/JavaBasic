package testjava.lang;

public class TestConstantPool {
	public static void main(String[] args) {
		
		String str3 = new String("123");
		String str4 = str3.intern();
		String str1 = "123";
		String str2 = "123";
		System.out.println(str1 == str2); 
		System.out.println(str4 == str1);
		System.out.println(str1 == str3);
		System.out.println(str3 == str4);
	}
}
