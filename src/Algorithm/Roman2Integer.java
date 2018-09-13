package Algorithm;

public class Roman2Integer {

	public static void main(String[] args) {
		System.out.println(solve("III"));
		System.out.println(solve("LVIII"));
		System.out.println(solve("MCMXCIV"));
		
	}
	
	private static int solve(String s) {
		int n = 0, pre = 0, l = s.length(), sum = 0;
		for(int i = 0; i < l; i ++) {
			switch(s.charAt(i)) {
				case 'I': n = 1;break;
				case 'V': n = 5;break;
				case 'X': n = 10;break;
				case 'L': n = 50;break;
				case 'C': n = 100;break;
				case 'D': n = 500;break;
				case 'M': n = 1000;break;
				default: return 0;
			}
			if(pre < n)
				sum = sum - 2 * pre + n;
			else
				sum += n;
			pre = n;
		}
		return sum;
	}

}
