package Interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class CheckGraphDegree {
	/**
	 * �������������һ�������޻�ͼ���������и����ڵ�Ķ����У��ж���������ж�Ӧ�����˽ṹ�Ƿ���һ�������޻�ͼ��
	 * ����Havel-Hakimi����isValidGraph()�����ж��Ƿ���һ��ͼ��
	 * 
	 * input:
	 * 2
	 * 6
	 * 1 1 1 4 2 1
	 * 4
	 * 1 2 2 3
	 * Output:
	 * Yes
	 * No
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		for(int time = 0; time < n; time++) {
			int len = scanner.nextInt();
			long[] degrees = new long[len];
			for(int i = 0; i < len; i++) {
				degrees[i] = scanner.nextLong();
			}
			Arrays.sort(degrees);
			if(isValidTree(degrees))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	private static boolean isValidTree(long[] degrees) {
		if(degrees.length == 1)
			if(degrees[0] == 0)
				return true;
			else
				return false;
		long sum = 0, max = degrees[0];
		for(int i = 0; i < degrees.length; i++) {
			sum += degrees[i];
			max = degrees[i] > max ? degrees[i]: max;
		}
		if(sum % 2 != 0 || max >= degrees.length)
			return false;
		if(isValidWithTree(degrees, degrees.length - 1))
			return true;
		return false;
	}

	private static boolean isValidWithTree(long[] degrees, int i) {
		if(i == 1)
			if(degrees[0] - 1 == 0)
			    return true;
			else
				return false;
		long len = degrees[i];
		int idx = i - 1;
		for(int j = 0; j < len; j++) {
			if(idx < 0)
				return false;
			degrees[idx--]--;
		}
		Arrays.sort(degrees);
		if(degrees[0] == 0 && degrees[1] != 0)
			return false;
		long[] tmp = new long[i];
		for(int x = 0; x < i; x++) {
			if(degrees[x] < 0)
				return false;
			tmp[x] = degrees[x];
		}
		if(isValidWithTree(tmp, tmp.length - 1))
			return true;
		return false;
	}

	private static boolean isValidGraph(int[] degrees, int i) {
		//i=degrees.length - 1
		//���ַ������������ж϶������Ƿ���ͼ�����ǲ����ж��ܷ�����޻�ͼ������
		if(i == 1 && degrees[0] >= 0)
			return true;
		int len = degrees[i], idx = i - 1;
		for(int j = 0; j < len; j++) {
			if(idx < 0)
				return false;
			degrees[idx--]--;
		}
		Arrays.sort(degrees);
		int[] tmp = new int[i];
		for(int x = 0; x < i; x++) {
			if(degrees[x] < 0)
				return false;
			tmp[x] = degrees[x];
		}
		if(isValidGraph(tmp, tmp.length - 1))
			return true;
		return false;
	}

}
