package br.com.ilegra.main;

/**
 * 
 * @author guilherme
 *
 */
public class Main {
	
	public static final int TIME_TO_SLEEP = 10000;
	public static final boolean RUNNING = true;

	/**
	 * Initial system
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Application app = new Application();
			System.out.println("########Starting application########");
			do {
				app.run();
				Thread.sleep(TIME_TO_SLEEP);
			} while(RUNNING);
		} catch (Exception e) {
			System.out.println("########Closing application########");
			System.out.println(e.getMessage());
		}
	}
}
