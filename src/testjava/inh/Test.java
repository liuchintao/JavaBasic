package testjava.inh;

import java.util.HashMap;
import java.util.Map;
//登记式单例类.
//类似Spring里面的方法，将类名注册，下次从里面直接获取。
public class Test {
    private static Map<String,Test> map = new HashMap<String,Test>();
    static{
        Test single = new Test();
        map.put(single.getClass().getName(), single);
    }
    //保护的默认构造子
    protected Test(){}
    //静态工厂方法,返还此类惟一的实例
    public static Test getInstance(String name) {
        if(name == null) {
            name = Test.class.getName();
            System.out.println("name == null"+"--->name="+name);
        }
        if(map.get(name) == null) {
            try {
                map.put(name, (Test) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    //一个示意性的商业方法
    public String about() {    
        return "Hello, I am RegSingleton.";    
    }    
    public static void main(String[] args) {
        Test single1 = Test.getInstance(null);
        Test single2 = Test.getInstance("testjava.inh.Test");
        System.out.println(single1.about());
        System.out.println(single2.about());
        System.out.println(single1 == single2);
    }
}