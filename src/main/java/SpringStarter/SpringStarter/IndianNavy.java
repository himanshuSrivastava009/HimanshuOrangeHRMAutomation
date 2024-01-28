package SpringStarter.SpringStarter;

import org.springframework.context.ApplicationContext;

public class IndianNavy implements Service {

	ApplicationContext ac;
	IndianNavy(ApplicationContext ac){
		
		this.ac = ac;
	}
	@Override
	public void addressPresident() {
		
		 President p = (President)ac.getBean("President");
		System.out.println("I serve President " +p);
		
	}

	
}
