package Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CaptureBiggestShape {
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Integer, ArrayList<Point>> readData(){
        Scanner s = new Scanner(System.in);
        String input = null;
        Map<Integer, ArrayList<Point>> pts = new HashMap<Integer, ArrayList<Point>>();
        
        input = s.nextLine();
        
//        if(s.hasNext()){
//            input = s.nextLine();
//        }

        StringTokenizer st = new StringTokenizer(input, ", ");
        while(st.hasMoreTokens()){
            Integer x = Integer.parseInt(st.nextToken());
            Integer y = Integer.parseInt(st.nextToken());
            ArrayList<Point> v = pts.get(x) == null ? new ArrayList<Point>() : pts.get(x);            
            v.add(new Point(x, y));
            pts.put(x, v);
        }
        int key = 0;
        Map<Integer, ArrayList<Point>> indexPts = new HashMap<Integer, ArrayList<Point>>();
        for(Entry entry : pts.entrySet()){
            indexPts.put(key, (ArrayList<Point>)entry.getValue());
            key++;
        }
        
        return indexPts;
    }

    public static void main(String[] args) {
        ArrayList<Point> ptOkList = new ArrayList<Point>();
        Map<Integer, ArrayList<Point>> pts = readData();
        
        int i = 0;
        Point startUp = pts.get(0).get(0);
        Point startBottom = pts.get(0).get(0);
        Point endUp = pts.get(pts.size() - 1).get(0);
        Point endBottom = pts.get(pts.size() - 1).get(0);
        for(i = 0; i < pts.get(0).size(); i++){    
            if(pts.get(0).get(i).y > startUp.y){
                startUp = pts.get(0).get(i);
            }
            if(pts.get(0).get(i).y < startBottom.y){
                startBottom = pts.get(0).get(i);
            }
        }
        for(i = 0; i < pts.get(pts.size() - 1).size(); i++){    
            if(pts.get(pts.size() - 1).get(i).y > startUp.y){
                endUp = pts.get(pts.size() - 1).get(i);
            }
            if(pts.get(pts.size() - 1).get(i).y < startBottom.y){
                endBottom = pts.get(pts.size() - 1).get(i);
            }
        }
        
        Point startPt = startUp;
        int index = 0;
        Point p = startUp;
        while(true){
            float k = -Float.MAX_VALUE;            
            for(i = index + 1; i < pts.size(); i++){        
                //int index_ = index;
                for(int j = 0; j < pts.get(i).size(); j++){                
                    Point temp = pts.get(i).get(j);
                    float kk = (temp.y - startPt.y) / (temp.x - startPt.x);
                    if(kk > k){
                        p = temp;
                        k = kk;
                        index = i;
                    }
                }
            }

            startPt = p;
            if(startPt == endUp){
                break;
            }
            ptOkList.add(startPt);
        }
        
        startPt = endBottom;
        index = pts.size() - 1;
        p = endBottom;
        while(true){
            float k = -Float.MAX_VALUE;
            for(i = index - 1; i >= 0; i--){   
                //int index_ = index;
                for(int j = 0; j < pts.get(i).size(); j++){                
                    Point temp = pts.get(i).get(j);
                    float kk = (temp.y - startPt.y) / (temp.x - startPt.x);
                    if(kk >= k){
                        p = temp;
                        k = kk;
                        index = i;
                    }
                }
            }

            startPt = p;
            if(startPt == startBottom){
                break;
            }
            ptOkList.add(startPt);
        }
        ptOkList.add(endBottom);
        ptOkList.add(startPt);
        
        int sum = 0;
        int len = ptOkList.size();
        for(i = 0; i < len; i++) {
        	int x1 = ptOkList.get(i).x;
        	int y1 = ptOkList.get(i).y;
        	int x2 = ptOkList.get((i+1)%len).x;
        	int y2 = ptOkList.get((i+1)%len).y;
        	sum += (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); 
        }
        System.out.println(sum);
//        for(i = 0; i < pts.get(0).size(); i++){
//            ptOkList.add(pts.get(0).get(i));
//        }
//        for(i = 0; i < pts.get(pts.size() - 1).size(); i++){
//            ptOkList.add(pts.get(pts.size() - 1).get(i));
//        }
//        
//        System.out.print(ptOkList.size());
//        for(i = 0; i < ptOkList.size(); i++){
//            System.out.print(";" + ptOkList.get(i).x + "," + ptOkList.get(i).y);
//        }
        //-1 -1,1 1,1 3,2 2,2 1,3 1,4 -1
    }
}
