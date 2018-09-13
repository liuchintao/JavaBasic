package testjava.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 0);
		map.put("b", 0);
		Thread t1 = new Thread(()->{
			for(int i = 0; i < 1000; i++) {
			int a = map.get("a");
//			System.out.println("a: " + a);
			map.put("a", ++a);
			}
		});
		Thread t2 = new Thread(()->{
			for(int i = 0; i < 1000; i++) {
			int b = map.get("b");
//			System.out.println("b: " + b);
			map.put("b", ++b);
			}
		});
		t2.start();
		t1.start();
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Entry<String, Integer> kv: map.entrySet()) {
			System.out.println("key: " + kv.getKey() + " value: " + kv.getValue());
		}
	}
}
