package multi.threading.project.example;

public class MultithreadingExample  {

	public static void main(String[] args) {

		
		Runnable run = new Runnable() {
			
			@Override
			 public void run() {
				
				for(int i=0;i<10;i++) {
					System.out.println("Value is= " +i +" Thread name is= " +Thread.currentThread().getName());
				}
				
			}
		};
		
		Thread th1 = new Thread(run);
		Thread th2 = new Thread(run);
		th1.start();
		th2.start();
	}

}
