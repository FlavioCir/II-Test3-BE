package Esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main3 {

	private static final String ENCODING = "utf-8";
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String fileName = "RegistroPresenze.txt";
		File file = new File(fileName);
		System.out.println( "Avviato caricamento programma......" );
		
		if(file.exists()) {
			System.out.printf("File %s trovato%n", fileName);
			System.out.println( "1 - Aggiungi presenze" );
			System.out.println( "2 - Leggi file" );
			System.out.println( "Scegli la funzionalità da fare" );
			int selezione = scan.nextInt();
			scan.nextLine();
			if( selezione == 1 ) {
				try {
					System.out.println("Scrivi il nome e il cognome dello studente: ");
					String nome = scan.nextLine();
					
					System.out.println("Scrivi i gironi di presenza: ");
					int ggPresenze = scan.nextInt();
					
					Presenza p1 = new Presenza(nome, ggPresenze);
					
					scriviSuFile(file, p1.toString(), true);
					System.out.println("Prezenza aggiunta!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if ( selezione == 2 ) {
				System.out.println("Leggi il file:");
				
				try {
					leggiFile(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println( "La funzionalità inserita non esiste!" );
			}
			
		} else {
			System.out.printf("il file %s non esiste %n", fileName);			
		}
		
		scan.close();

	}
	
	public static void scriviSuFile(File file, String str, boolean aggiungi) throws IOException {
		FileUtils.writeStringToFile(file, str, ENCODING, true);
	}

	public static void leggiFile(File file) throws IOException {
		System.out.println(FileUtils.readFileToString(file, ENCODING));
	}
	
}

class Presenza {

	String nome;
	int numPresenze;
	
	public Presenza(String nome, int numPresenze) {
		this.nome = nome;
		this.numPresenze = numPresenze;
	}
	
	@Override
	public String toString() {
		String s = String.format(this.nome + "@" + this.numPresenze + "#");		
		return s;
	}
	
}
