package com.selenium.webelements.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Phone implements Serializable{

	private String osName;
	private String phoneBrand;
	private String ramAvailable;
	private int price;

	public Phone(String osName, String phoneBrand, String ramAvailable, int price) {
		super();
		this.osName = osName;
		this.phoneBrand = phoneBrand;
		this.ramAvailable = ramAvailable;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [osName=" + osName + ", phoneBrand=" + phoneBrand + ", ramAvailable=" + ramAvailable + ", price="
				+ price + "]";
	}
	
	

}

class PhoneBuilder {

	private String osName;
	private String phoneBrand;
	private String ramAvailable;
	private int price;

	public PhoneBuilder setOsName(String osName) {
		this.osName = osName;
		return this;
	}

	public PhoneBuilder setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
		return this;
	}

	public PhoneBuilder setRamAvailable(String ramAvailable) {
		this.ramAvailable = ramAvailable;
		return this;
	}

	public PhoneBuilder setPrice(int price) {
		this.price = price;
		return this;
	}

	public Phone getPhone() {

		return new Phone(osName, phoneBrand, ramAvailable, price);
	}

}

public class SerializationAndDesirealization {

	static PhoneBuilder phoneBuilder = new PhoneBuilder();

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Phone p = phoneBuilder.setPrice(50000).setPhoneBrand("one Plus").setOsName("Android").setRamAvailable("6GB")
				.getPhone();
		
		//System.out.println(p);
		
		FileOutputStream fos = new FileOutputStream(new File("SerDer.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p);
		
		FileInputStream fis = new FileInputStream("SerDer.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		 Phone ph = (Phone)ois.readObject();
		 System.out.println("Der output is ==== " +ph);
	}
}
