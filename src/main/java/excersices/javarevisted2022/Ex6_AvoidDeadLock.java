public class Ex6_AvoidDeadLock {
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String[] args) throws InterruptedException{
		
		Runnable t1 = () -> {
			synchronized (lock1){
				System.out.println("Execution t1 a");
				try {Thread.sleep(5000);} catch (InterruptedException e){}
				
				synchronized(lock2) {
					System.out.println("Execution t1 b");
					try {Thread.sleep(5000);} catch (InterruptedException e){}
				}		
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized(lock2){
					System.out.println("Execution t2 a");
					try {Thread.sleep(4000);} catch(InterruptedException e){}
					synchronized(lock1){
						System.out.println("Execution t2 b");
						try {Thread.sleep(4000);}catch(InterruptedException e){}
					}	
				}
				
			}
		};
		
		Thread t11 = new Thread(t1);
		
		t11.start();
		t2.start();
		t11.join();
		t2.join();
		System.out.println("End");
	}
}
