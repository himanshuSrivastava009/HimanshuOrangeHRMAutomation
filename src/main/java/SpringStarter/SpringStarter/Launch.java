package SpringStarter.SpringStarter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
		

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		IndianAirforce iaf = new IndianAirforce(ac);
		IndianNavy inv = new IndianNavy(ac);
		IndianArmy iar = new IndianArmy(ac);
		
		iaf.addressPresident();
		inv.addressPresident();
		iar.addressPresident();

	}

}
