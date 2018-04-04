package testjava.lang;

public class TestTryFinally {
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	private static int test() {
		Integer i = new Integer(0);
		try {
//			int x = 1/0;
			return i;
		}catch(Exception e) {
			e.printStackTrace();
			i = new Integer(2);
//			return i;
		}finally {
			i= new Integer(3);
		}
		return i;
	}
}
