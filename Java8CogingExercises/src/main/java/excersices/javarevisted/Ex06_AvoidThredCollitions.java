package excersices.javarevisted;

public class Ex06_AvoidThredCollitions {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = () -> {
			synchronized(lock1) {
				System.out.println("Excecuting b1");
				
				try { Thread.sleep(1000); } catch (InterruptedException e){}	
				synchronized (lock2) {
					System.out.println("Excecuting b2");
				}
			}
		};
		
		Runnable r2 = () -> {
			synchronized(lock1) {
				System.out.println("Excecuting b3");
				try { Thread.sleep(500); } catch (InterruptedException e){}
				synchronized(lock2) {
					System.out.println("Excecuting b4");
				}
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);	

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("End");
	}

	

}

