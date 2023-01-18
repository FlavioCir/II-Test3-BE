package Esercizio2;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		
		Random numeriR = new Random();
		List<Integer> l1 = new ArrayList<>(3000);
		
		for(int i = 0; i < 3000; i++) {
			int casuale = numeriR.nextInt();
			l1.add(casuale);
		}
		
		NumeriArray thread1 = new NumeriArray( l1, 0, 1000 );
		Thread t1 = new Thread(thread1);
		NumeriArray thread2 = new NumeriArray( l1, 1000, 2000 );
		Thread t2 = new Thread(thread2);
		NumeriArray thread3 = new NumeriArray( l1, 2000, 3000 );
		Thread t3 = new Thread(thread3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {}
		
		long sommaTotale = thread1.getSommaParziale() + thread2.getSommaParziale() + thread3.getSommaParziale();
		System.out.println( "La somma totale è: " + sommaTotale );
		
	}

}

class NumeriArray implements Runnable {
	
	private List<Integer> l1;
	private int startIndex;
	private int endIndex;
	private long sommaParziale;
	 
	public NumeriArray(List<Integer> l1, int startIndex, int endIndex) {
		this.l1 = l1; 
		this.startIndex = startIndex; 
		this.endIndex = endIndex;
	}
	
	public long getSommaParziale() {
		return sommaParziale;
	}
	
	@Override
	public void run() {
		for(int i = startIndex; i < endIndex; i++) {
			sommaParziale += l1.get(i);
		}
	}
	
}
