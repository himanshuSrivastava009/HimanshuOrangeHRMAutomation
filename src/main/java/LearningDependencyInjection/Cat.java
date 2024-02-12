package LearningDependencyInjection;

public class Cat implements Animal{

	String name;
	String type;
	
	Cat(String name , String type){
		
		this.name = name;
		this.type = type;
	}
	@Override
	public void makeNoise() {
		
		System.out.println("Meeeeaaaaaaw " + name);
		System.out.println("Roaring...... " +type);

		
	}

	
}
