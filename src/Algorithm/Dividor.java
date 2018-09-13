package Algorithm;

public class Dividor {

	public static void main(String[] args) {
//		System.out.println(divide(-2, -2));
//		System.out.println(divide(-2, 1));
//		System.out.println(divide(2, -1));
//		System.out.println(divide(2, -11));
		System.out.println(divide(7, -3));
		System.out.println(divide(7, -1));
		System.out.println(divide(10, 1));
		System.out.println(divide(10, 3));
		System.out.println(divide(10, 4));
		System.out.println(divide(-2147483648, -1));
		System.out.println(divide(-2147483648, -2));
		System.out.println(divide(-2147483648, -3));
	}

	private static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		int fd, fr;
		fd = dividend > 0 ? 1 : -1;
		fr = divisor > 0 ? 1 : -1;
		long ldividend = (long) dividend * fd;
		long ldivisor = (long) divisor * fr;
		if (ldivisor == 1)
			return ldividend * fd * fr > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ldividend * fd * fr;
		if(ldivisor == 2)
			return (int)(ldividend >> 1) * fd * fr;
		if (ldividend < ldivisor)
			return 0;
		return ldivide(ldividend, ldivisor) * fd * fr;
	}

	private static int ldivide(long ldividend, long ldivisor) {
		if(ldividend < ldivisor) return 0;
		long sum = ldivisor;
		int multi = 1;
		while((sum + sum) < ldividend) {
			sum += sum;
			multi += multi;
		}		
		return multi + ldivide(ldividend - sum, ldivisor);
	}

}
