package testjava.util;

public class TestString {

	public static void main(String[] args) {
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		String s3 = s1.intern();
		String s4 = s2.intern();
		String s5 = "aaa";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s4 == s3);
		System.out.println(s4 == s5);
		System.out.println(s1 == s5);
		
		String ss1 = new String("1") + new String("1");
		ss1.intern();
		String ss2 = "11";
		String ss3 = "1" + "1";
		System.out.println(ss1 == ss2);
		System.out.println(ss1 == ss3);
		System.out.println(ss2 == ss3);
	}

}
