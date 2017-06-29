package ood.design_pattern.Singleton;

public class Singleton {
	private static Singleton INSTANCE = new Singleton();//make sure only one instance in the class Singleton
	
	private Singleton() {}//explicitly declare constructor which is private to prohibit other constructors 
	
	public static Singleton getInstance() { // always return the only existed instance INSTANCE which is shared by 
											//all the instances of this class
		return INSTANCE;
	}
	
}
