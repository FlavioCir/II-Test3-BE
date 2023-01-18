package Esercizio1;

public class Main1 {

	public static void main(String[] args) {
		
		Simboli s1 = new Simboli("*");
		Simboli s2 = new Simboli("#");
		
		Thread t1 = new Thread( s1, "Thread-s1" );
		Thread t2 = new Thread( s2, "Thread-s2" );
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
	}

}

class Simboli extends Thread {
	
	private String simbolo;
	
	public Simboli(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println( i + " " + Thread.currentThread().getName() + ": " + simbolo ); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
}
