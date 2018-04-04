package testjava.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializableSingleton {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("Output.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));  
		Person p = Person.getInstance();
		oos.writeObject(p);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object newP = ois.readObject();
		ois.close();
		System.out.println(newP);
		System.out.println(newP == p);
	}
}
