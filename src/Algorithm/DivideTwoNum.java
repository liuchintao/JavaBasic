package Algorithm;

public class DivideTwoNum {

	public static void main(String[] args) {
		// Input section
		System.out.println(solve("102"));
		System.out.println(solve("123"));
		System.out.println(solve("00011"));
		System.out.println(solve("10234"));
	}
	
	private static int solve(String str) {
		if(str.length() <= 2)
			return 1;
		int ans = 0;
		// ²ð·Ö²¿·Ö
		String part1;
		String part2;
		for(int i = 1; i < str.length(); i++) {
			part1 = str.substring(0, i);
			part2 = str.substring(i);
			ans += checkCouple(part1, part2);
		}
		return ans;
	}

	private static int checkCouple(String part1, String part2) {
		int num = 0;
		if(part1.charAt(0) == '0' && part1.charAt(part1.length() - 1) != '0')
			return check(part2);
		if(part2.charAt(0) == '0' && part2.charAt(part2.length() - 1) != '0')
			return check(part1);
		return check(part1) * check(part2);
	}

	private static int check(String part) {
		if(part.length() == 1)
			return 1;
		if(part.charAt(0) == '0' && part.charAt(part.length() - 1) != '0')
			return 1;
		if(part.charAt(0) != '0') {
			if(part.charAt(part.length() - 1) != '0')
				return part.length();
			else
				return 1;
		}
		return 0;
	}

}
