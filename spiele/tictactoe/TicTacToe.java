package spiele.tictactoe;

import spiele.Player;
import java.util.Scanner;

public class TicTacToe {
	private static Scanner in = new Scanner(System.in); //Scanner
	
	private static Game spiel; //Spiel objekt
	private static Player spieler1, spieler2; //Spieler Objekte
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		//Spieler objekte erstellen
		spieler1 = new Player(1);
		spieler2 = new Player(2);
		
		spieler1.umbenennen();
		spieler2.umbenennen();
		
		//Variablen ausserhalb der Schlaufe
		char again = 'w';
		char umbenennen1 = 'n';
		char umbenennen2 = 'n';
		
		//loop um erneut zu spielen
		while (again == 'w') {
			spiel = new Game(); //spiel objekt erstellen
			
			//bei erneutem spielen umbenennen
			if (umbenennen1 == 'j') {
				spieler1 = null;
				spieler1 = new Player(1);
				spieler1.umbenennen();
			}
			if (umbenennen2 == 'j') {
				spieler2 = null;
				spieler2 = new Player(2);
				spieler2.umbenennen();
			}
			
			//Einleitung ausgeben
			spiel.printInstruction(spieler1.getName(), spieler2.getName());
			
			//warten
			in.nextLine();
			
			//spielbrett ausgeben
			spiel.printBoard();
			
			//variablen die länger existieren müssen als die schlaufe
			char wiederholen = 'w';
			int counter = 1;
			//schlaufe bis Spiel fertig ist
			while ((wiederholen == 'w') && (counter <= 9)) {
				if ((counter == 1) || (counter == 3) || (counter == 5) || (counter == 7) || (counter == 9)) {
					spiel.Spielzug(spieler1.getName(), 1);
				} else {
					spiel.Spielzug(spieler2.getName(), 2);
				}
				spiel.printBoard();
				wiederholen = spiel.siegerBestimmen(spieler1.getName(), spieler2.getName());
				counter++;
			} //end of while
			if (wiederholen == 'w') { //für unentschieden
				System.out.println("Unentschieden. Kein Gewinner");
			}
			
			//Sieg zum spieler hinzufügen
			if (spiel.getSieger() == 'X') {
				spieler1.addSieg();
			} else {
				spieler2.addSieg();
			}
			
			//option um anzahl siege anzuzeigen
			char vergleich = 'n';
			System.out.println("Möchtet ihr eure Siege vergleichen? 'j' für ja, belibige Taste für nein.");
			vergleich = in.nextLine().charAt(0);
			if (vergleich == 'j') {
				System.out.println(spieler1.getName() + " hat " + spieler1.getSiege() + " Siege.");
				System.out.println(spieler2.getName() + " hat " + spieler2.getSiege() + " Siege.");
				int temp = 0;
				if (spieler1.getSiege() >= spieler2.getSiege()) {
					temp = spieler1.getSiege() - spieler2.getSiege();
					System.out.println(spieler1.getName() + " hat " + temp + " Siege mehr als " + spieler2.getName());
				} else {
					temp = spieler2.getSiege() - spieler1.getSiege();
					System.out.println(spieler2.getName() + " hat " + temp + " Siege mehr als " + spieler1.getName());
				}
			} //end of if
			
			//again variable setzen
			System.out.println("Wollt ihr erneut spielen? 'w' für widerholen, beliebige Taste für beenden.");
			again = in.nextLine().charAt(0);
			
			if (again == 'w') {
				//umbenennen1 + 2 variable setzen
				System.out.println("wird jemand anderes als Spieler 1 weiter spielen? 'j' für ja, beliebige Taste für nein.");
				umbenennen1 = in.nextLine().charAt(0);
				
				System.out.println("wird jemand anderes als Spieler 2 weiter spielen? 'j' für ja, beliebige Taste für nein.");
				umbenennen2 = in.nextLine().charAt(0);
			}
		} //end of while
	} //end of main
}