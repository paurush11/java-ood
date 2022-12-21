package finalProject;

public class CodePartA {
	
	int counter = 0;
	int counterSmall = 97;
	int counterBig = 65;

	public void printSmallCharacter() {
		
		synchronized (this) {
			// Print number till the N
			while (counterSmall <= 122) {

				// If count is even then print
				while (counter % 2 == 1) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print((char) counterSmall);

				// Increment counter
				counterSmall++;
				
				counter++;

				// Notify to second thread
				notify();
			}
		}
	}

	public void printBigCharacter() {
		synchronized (this) {
			// Print number till the N
			while (counterBig <= 90) {

				// If count is odd then print
				while (counter % 2 == 0) {

					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Print the number
				System.out.print((char) counterBig);

				// Increment counter
				counterBig++;
				
				counter++;
				// Notify to 2nd thread
				notify();
			}
		}
	}

	public static void main(String[] args) {

		// Create an object of class
		CodePartA mt = new CodePartA();

		// Create thread t1
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mt.printBigCharacter();
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt.printSmallCharacter();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}
