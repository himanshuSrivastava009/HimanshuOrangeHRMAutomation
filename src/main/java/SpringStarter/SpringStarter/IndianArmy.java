package SpringStarter.SpringStarter;

import org.springframework.context.ApplicationContext;

public class IndianArmy implements Service {

	ApplicationContext ac;
	IndianArmy(ApplicationContext ac){
		
		this.ac = ac;
	}
	@Override
	public void addressPresident() {
		
		 President p = (President)ac.getBean("President");
		System.out.println("I serve President " +p);
		
	}

	
}
