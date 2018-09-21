package Interview.baicizhan;

import java.util.Scanner;
import java.util.Stack;

public class BCONKVMatch {
	/*
		 有形如
		 {
		   "k1"->"v1";
		   "k2"->{
		       "k21"->"v21"
		   }
		 }
		 的BCON格式
		 输入：
		第一行：{"k2"->"v1";"k1"->{"k1"->"v21";"k12"->{"k121"->"v121"}};"k3"-"v3"}
		第二行：k2.k21
		输出：
		"v21" 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String bcon = scanner.nextLine();
		String[] keys = scanner.nextLine().split("\\.");
		int pre = 0;
		for(int i = 0; i < keys.length; i++) {
			String key = keys[i];
			int idx = bcon.indexOf(key, pre);
			if(idx < 0) {
				System.out.println("NULL");
				return;
			}
			int valstart = idx+key.length()+3;
			pre = valstart;
			if(valstart < bcon.length() && bcon.charAt(valstart)=='\"' && i == keys.length - 1) {
				int valend = bcon.indexOf('\"', valstart + 1);
				String val = bcon.substring(valstart+1, valend);
				System.out.println("\"" + val + "\"");
				return;
			}else if(valstart < bcon.length() && bcon.charAt(valstart)=='{' && i == keys.length - 1) {
				
				Stack<Character> braces = new Stack<>();
				braces.push('{');
				int len = bcon.indexOf('>', valstart);
				boolean f = true;
				while(braces.size() != 0 && valstart + len < bcon.length()) {
					len++;
					char c = bcon.charAt(valstart + len); 
					if(c == '\"')
						f = !f;
					if(c == '{' && !f) 
						braces.push('{');
					else if(bcon.charAt(valstart + len) == '}' && !f)
						braces.pop();
				}
				String val = bcon.substring(valstart, valstart + len + 1);
				System.out.println(val);
				return;
			}
		}
		System.out.println("NULL");
	}

}
