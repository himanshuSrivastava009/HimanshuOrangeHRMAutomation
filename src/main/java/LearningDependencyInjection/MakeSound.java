package LearningDependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MakeSound {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Animal cat = (Animal)ac.getBean("cat");
		Animal tiger = (Animal)ac.getBean("tiger");
		cat.makeNoise();
		tiger.makeNoise();
	}
}
