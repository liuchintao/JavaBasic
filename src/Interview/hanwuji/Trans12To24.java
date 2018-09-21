package Interview.hanwuji;

import java.util.Scanner;

public class Trans12To24 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String timeTwelve = scanner.nextLine();
		int first = timeTwelve.indexOf(":");
		int len = timeTwelve.length();
		String hour = timeTwelve.substring(0, first);
		String other= timeTwelve.substring(first + 1, len - 2);
		String xm = timeTwelve.substring(len - 2);
		if(xm.equals("PM")) {
			if(!hour.equals("12"))
				hour = String.valueOf(Integer.parseInt(hour) + 12);
		}else {
			if(hour.equals("12"))
				hour = "00";
		}
		System.out.println(hour + ":" + other);
	}

}
