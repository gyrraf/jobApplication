package spiele.tictactoe;

import java.util.Scanner;

public class Game {
	//Scanner
	private static Scanner in = new Scanner(System.in);
	
	//Objektvariablen
	private char A1, A2, A3, B1, B2, B3, C1, C2, C3;
	private char Sieger;
	
	//Konstruktor
	public Game() {
		A1 = A2 = A3 = B1 = B2 = B3 = C1 = C2 = C3 = ' ';
		Sieger = ' ';
	}
	
	/**
	 * Ausgabe Spielbrett
	 */
	public void printBoard() {
		System.out.println("\t +---+---+---+");
		System.out.println("\t | " + A1 + " | " + A2 + " | " + A3 + " |");
		System.out.println("\t +---+---+---+");
		System.out.println("\t | " + B1 + " | " + B2 + " | " + B3 + " |");
		System.out.println("\t +---+---+---+");
		System.out.println("\t | " + C1 + " | " + C2 + " | " + C3 + " |");
		System.out.println("\t +---+---+---+");
	}
	
	/**
	 * Ausgabe der Spielanleitung
	 * @param name1
	 * @param name2
	 */
	public void printInstruction(String name1, String name2) {
		System.out.println("Das Spielbrett ist so nummeriert: \n");
		
		System.out.println("\t      1    2    3");
		System.out.println("\t   +----+----+----+");
		System.out.println("\t A | A1 | A2 | A3 |");
		System.out.println("\t   +----+----+----+");
		System.out.println("\t B | B1 | B2 | B3 |");
		System.out.println("\t   +----+----+----+");
		System.out.println("\t C | C1 | C2 | C3 |");
		System.out.println("\t   +----+----+----+ \n");
		
		System.out.println(name1 + " spielt als 'X', " + name2 + " spielt als 'O'");
	}
	
	/**
	 * ausführen des Spielzuges
	 * @param name
	 * @param spielerNr
	 */
	public void Spielzug(String name, int spielerNr) {
		//SpielerNr = 1 --> X
		//SpielerNr = 2 --> O
		
		//Eingabe des Feldes ---- mit überprüfung ob es noch Frei ist und dass es korrekt eingegeben ist.
		String Feld = "";
		//überprüfen ob Feld frei ist
		while (!(((Feld.equals("A1")) && (A1 == ' ')) || ((Feld.equals("A2")) && (A2 == ' ')) || ((Feld.equals("A3")) && (A3 == ' ')) || ((Feld.equals("B1")) && (B1 == ' ')) || ((Feld.equals("B2")) && (B2 == ' ')) || ((Feld.equals("B3")) && (B3 == ' ')) || ((Feld.equals("C1")) && (C1 == ' ')) || ((Feld.equals("C2")) && (C2 == ' ')) || ((Feld.equals("C3")) && (C3 == ' ')))) {
			if (!(Feld.equals(""))) { //Fehlermeldung
				System.out.println("Dieses Feld ist schon besetzt. Bitte wähle ein neues.");
				Feld = "";
			}
			
			//überprüfen dass es richtig eingegeben wird
			while (!((Feld.equals("A1")) || (Feld.equals("A2")) || (Feld.equals("A3")) || (Feld.equals("B1")) || (Feld.equals("B2")) || (Feld.equals("B3")) || (Feld.equals("C1")) || (Feld.equals("C2")) || (Feld.equals("C3")))) {
				if (!(Feld.equals(""))) { //Fehlermeldung
					System.out.println("Dieses Feld gibt es nicht. Geben Sie bitte ein gültiges Feld ein");
				}
				System.out.println(name + ", welches Feld willst du besetzen?");
				Feld = in.nextLine();
			}
		}
		
		//Feld füllen
		if (spielerNr == 1) {
			//X
			if (Feld.equals("A1")) {
				A1 = 'X';
			} else if (Feld.equals("A2")) {
				A2 = 'X';
			} else if (Feld.equals("A3")) {
				A3 = 'X';
			} else if (Feld.equals("B1")) {
				B1 = 'X';
			} else if (Feld.equals("B2")) {
				B2 = 'X';
			} else if (Feld.equals("B3")) {
				B3 = 'X';
			} else if (Feld.equals("C1")) {
				C1 = 'X';
			} else if (Feld.equals("C2")) {
				C2 = 'X';
			} else {
				C3 = 'X';
			}
		} else {
			//O
			if (Feld.equals("A1")) {
				A1 = 'O';
			} else if (Feld.equals("A2")) {
				A2 = 'O';
			} else if (Feld.equals("A3")) {
				A3 = 'O';
			} else if (Feld.equals("B1")) {
				B1 = 'O';
			} else if (Feld.equals("B2")) {
				B2 = 'O';
			} else if (Feld.equals("B3")) {
				B3 = 'O';
			} else if (Feld.equals("C1")) {
				C1 = 'O';
			} else if (Feld.equals("C2")) {
				C2 = 'O';
			} else {
				C3 = 'O';
			}
		} //end of if
	} //end of method
	
	/**
	 * überprüft ob jemand gewonnen hat und gibt zurück ob ein weiterer Zug folgen soll.
	 * @param name1
	 * @param name2
	 * @return
	 */
	public char siegerBestimmen(String name1, String name2) {
		if (((A1 == 'X') && (A2 == 'X') && (A3 == 'X')) || ((A1 == 'O') && (A2 == 'O') && (A3 == 'O'))) {
			//Reihe A
			if (A1 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((B1 == 'X') && (B2 == 'X') && (B3 == 'X')) || ((B1 == 'O') && (B2 == 'O') && (B3 == 'O'))) {
			//Reihe B
			if (B1 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		}  else if (((C1 == 'X') && (C2 == 'X') && (C3 == 'X')) || ((C1 == 'O') && (C2 == 'O') && (C3 == 'O'))) {
			//Reihe C
			if (C1 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((A1 == 'X') && (B1 == 'X') && (C1 == 'X')) || ((A1 == 'O') && (B1 == 'O') && (C1 == 'O'))) {
			//Spalte 1
			if (A1 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((A2 == 'X') && (B2 == 'X') && (C2 == 'X')) || ((A2 == 'O') && (B2 == 'O') && (C2 == 'O'))) {
			//Spalte 2
			if (A2 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((A3 == 'X') && (B3 == 'X') && (C3 == 'X')) || ((A3 == 'O') && (B3 == 'O') && (C3 == 'O'))) {
			//Spalte 3
			if (A3 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((A1 == 'X') && (B2 == 'X') && (C3 == 'X')) || ((A1 == 'O') && (B2 == 'O') && (C3 == 'O'))) {
			//Diagonale A1C3
			if (A1 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else if (((A3 == 'X') && (B2 == 'X') && (C1 == 'X')) || ((A3 == 'O') && (B2 == 'O') && (C1 == 'O'))) {
			//Diagonale A3C1
			if (A3 == 'X') {
				Sieger = 'X';
				System.out.println(name1 + " hat gewonnen.");
				return 's';
			} else {
				Sieger = 'O';
				System.out.println(name2 + " hat gewonnen.");
				return 's';
			}
		} else {
			return 'w';
		} //end of if
	} //end of method
	
	/**
	 * Gibt den Sieger des Spiels zurück
	 * @return
	 */
	public char getSieger() {
		return Sieger;
	}
}