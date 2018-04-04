package testjava.inh;

import java.util.HashMap;
import java.util.Map;
//�Ǽ�ʽ������.
//����Spring����ķ�����������ע�ᣬ�´δ�����ֱ�ӻ�ȡ��
public class Test {
    private static Map<String,Test> map = new HashMap<String,Test>();
    static{
        Test single = new Test();
        map.put(single.getClass().getName(), single);
    }
    //������Ĭ�Ϲ�����
    protected Test(){}
    //��̬��������,��������Ωһ��ʵ��
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
    //һ��ʾ���Ե���ҵ����
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