package Interview.hanwuji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSubset {
/**
n=4 k=3
s = [1 7 2 4]
求s的子集s·，其中每两个元素之和均不能被k整除
 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> group = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i ++) {
            int now = scanner.nextInt();
            int j = 0;
            while(true) {
                if(j >= group.size()) {
                    List<Integer> new_list = new ArrayList<>();
                    new_list.add(now);
                    group.add(new_list);
                    Collections.sort(group, (a, b) -> (b.size() - a.size()));
                    break;
                }
                boolean flag = true;
                for(int num : group.get(j)) {
                    if((num + now) % k == 0) {
                        j ++;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    group.get(j).add(now);
                    Collections.sort(group, (a, b) -> (b.size() - a.size()));
                    break;
                }
            }
        }
        System.out.println(group.get(0).size());
        scanner.close();
    }
}
