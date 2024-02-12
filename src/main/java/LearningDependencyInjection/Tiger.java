package LearningDependencyInjection;

public class Tiger implements Animal {

	String name;
	String type;

	Tiger(String name , String type) {

		this.name = name;
		this.type = type;
	}

	@Override
	public void makeNoise() {

		System.out.println("Roaring...... " +name);
		System.out.println("Roaring...... " +type);

	}

}
