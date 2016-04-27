package app;


public class Main {

	public static void main(String[] args) {
		
		Thread appThread = new Thread(new AppThread());
		appThread.start();
		

	}

}
