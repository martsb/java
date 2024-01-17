package td;

public class kas extends Thread{
	int sleepTime;
	String name;
	
	kas(int sleepTime, String name) {
		this.sleepTime = sleepTime;
		this.name = name;
	}
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println("Go, " +this.name);
			try {
				sleep(this.sleepTime);
			} catch (Exception e) {
				System.err.println("Problems with sleep!");
			}
		}
		System.out.println("End of story for " +this.name);
	}
}
