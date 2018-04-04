package testjava.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {  
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 6195396035807623436L;

	private static class InstanceHolder {  
        private static final Person instatnce = new Person("John", 31, Gender.MALE);  
    }  
 
    public static Person getInstance() {  
        return InstanceHolder.instatnce;  
    }  
 
    private String name = null;  
 
    private Integer age = null;  
 
    private Gender gender = null;  
    
    private static String test = "sss";
 
    private Person() {  
        System.out.println("none-arg constructor");  
    }  
 
    private Person(String name, Integer age, Gender gender) {  
        System.out.println("arg constructor");  
        this.name = name;  
        this.age = age;  
        this.gender = gender;  
    }  
 
    private Object readResolve() throws ObjectStreamException {  
        return InstanceHolder.instatnce;  
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
} 
