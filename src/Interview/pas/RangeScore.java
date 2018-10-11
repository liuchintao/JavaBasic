package Interview.pas;

import java.util.*;

public class RangeScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while(scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] temp_array = temp.split(" ");
            int sum = 0;
            for(int i = 1; i < temp_array.length; i ++) {
                sum += Integer.parseInt(temp_array[i]);
            }
            map.put(temp_array[0], Math.round((float)(sum) / (float)(temp_array.length - 1)));
        }
//        String[] input = new String[] {"Bob 95 95","Ally 100 90 95","Li 92 86","Cat 98 99","Wang 99"};
//        for(String temp : input) {
//            String[] temp_array = temp.split(" ");
//            int sum = 0;
//            for(int i = 1; i < temp_array.length; i ++) {
//                sum += Integer.parseInt(temp_array[i]);
//            }
//            map.put(temp_array[0], sum / (temp_array.length - 1));
//        }
        sb(map);
        scanner.close();
    }

    public static void sb(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, (a, b) -> (b.getValue() - a.getValue()));
        for(int i = 0; i < list.size() - 1; i ++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
        System.out.print(list.get(list.size() - 1).getKey() + " " + list.get(list.size() - 1).getValue());
    }
}