package spiele.rps;

import java.util.Scanner;

public class Game {
	private static Scanner in = new Scanner(System.in);
	
	//Objektvariablen
	private String sieger;
	
	/**
	 * Konstruktor
	 */
	public Game() {
		sieger = " ";
	}
	
	/**
	 * Anleitung ausgeben
	 * @param name1
	 * @param name2
	 */
	public void printInstructions(String name1, String name2) {
		System.out.println(name1 + " spielt zuerst und dann spielt " + name2);
		System.out.println("die Abk�rzungen kommen vom Englischen:");
		System.out.println("Stein = R");
		System.out.println("Papier = P");
		System.out.println("Schere = S");
		System.out.println("Stein besiegt Schere, Schere besiegt Papier und Papier besiegt Stein.");
	}
	
	/**
	 * Spielen und sieger bestimmen
	 * @param name1
	 * @param name2
	 */
	public void spielen(String name1, String name2) {
		//Spielzug spieler1
		System.out.println(name1 + ", dein Zug.");
		char auswahl1 = 'E';
		while (!((auswahl1 == 'S') || (auswahl1 == 'R') || (auswahl1 == 'P'))) {
			if (auswahl1 != 'E') {
				System.out.println("Ung�ltige Auswahl. Was w�hlst du?");
			} else {
				System.out.println("Was w�hlst du?");
			}
			auswahl1 = in.nextLine().charAt(0);
		}
		
		//Abstand schaffen
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
		
		//Spielzug spieler1
		System.out.println(name2 + ", dein Zug.");
		char auswahl2 = 'E';
		while (!((auswahl2 == 'S') || (auswahl2 == 'R') || (auswahl2 == 'P'))) {
			if (auswahl2 != 'E') {
				System.out.println("Ung�ltige Auswahl. Was w�hlst du?");
			} else {
				System.out.println("Was w�hlst du?");
			}
			auswahl2 = in.nextLine().charAt(0);
		}
		
		//Sieger bestimmen
		if (auswahl1 == 'R') {
			if (auswahl2 == 'R') {
				//unentschieden
				System.out.println("Unentschieden. Keiner hat gewonnen.");
				sieger = "keiner";
			} else if (auswahl2 == 'P') {
				//Spieler2 hat gewonnen
				System.out.println("Papier schl�gt Stein. " + name2 + " hat gewonnen.");
				sieger = "Spieler 2";
			} else {
				//Spieler1 hat gewonnen
				System.out.println("Stein schl�gt Schere. " + name1 + " hat gewonnen.");
				sieger = "Spieler 1";
			}
		} else if (auswahl1 == 'P') {
			if (auswahl2 == 'R') {
				//Spieler1 hat gewonnen
				System.out.println("Papier schl�gt Stein. " + name1 + " hat gewonnen.");
				sieger = "Spieler 1";
			} else if (auswahl2 == 'P') {
				//unentschieden
				System.out.println("Unentschieden. Keiner hat gewonnen.");
				sieger = "keiner";
			} else {
				//Spieler2 hat gewonnen
				System.out.println("Schere schl�gt Papier. " + name2 + " hat gewonnen.");
				sieger = "Spieler 2";
			}
		} else {
			if (auswahl2 == 'R') {
				//Spieler2 hat gewonnen
				System.out.println("Stein schl�gt Schere. " + name2 + " hat gewonnen.");
				sieger = "Spieler 2";
			} else if (auswahl2 == 'P') {
				//Spieler1 hat gewonnen
				System.out.println("Schere schl�gt Stein. " + name1 + " hat gewonnen.");
				sieger = "Spieler 1";
			} else {
				//unentschieden
				System.out.println("Unentschieden. Keiner hat gewonnen.");
				sieger = "keiner";
			}
		} // else of if
	} // else of method
	
	/**
	 * Sieger zur�ckgeben
	 * @return
	 */
	public String getSieger() {
		return sieger;
	}
}