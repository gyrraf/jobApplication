package spiele.rps;

import spiele.Player;
import java.util.Scanner;

public class RPS {
	private static Scanner in = new Scanner(System.in);
	
	private static Game spiel;
	private static Player spieler1, spieler2;
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		char wiederholen = 'j';
		char umbenennen1 = 'j', umbenennen2 = 'j';
		
		while (wiederholen == 'j') {
			spiel = new Game();
			//umbenennen
			if (umbenennen1 == 'j') {
				spieler1 = null;
				spieler1 = new Player();
				spieler1.umbenennen();
			}
			if (umbenennen2 == 'j') {
				spieler2 = null;
				spieler2 = new Player();
				spieler2.umbenennen();
			}
			
			//Einleitung ausgeben
			spiel.printInstructions(spieler1.getName(), spieler2.getName());
			in.nextLine();
			
			//spielen
			spiel.spielen(spieler1.getName(), spieler2.getName());
			
			//Sieg hinzufügen
			if (spiel.getSieger().equals("Spieler 1")) {
				spieler1.addSieg();
			} else if (spiel.getSieger().equals("Spieler 2")) {
				spieler2.addSieg();
			}
			
			//Siege vergleichen
			System.out.println("Wollt ihr eure Siege vergleichen? 'j' für ja, beliebige Taste für nein.");
			char vergleichen = in.nextLine().charAt(0);
			if (vergleichen == 'j') {
				System.out.println(spieler1.getName() + " hat " + spieler1.getSiege() + " Siege.");
				System.out.println(spieler2.getName() + " hat " + spieler2.getSiege() + " Siege.");
				if (spieler1.getSiege() >= spieler2.getSiege()) {
					int temp = spieler1.getSiege() - spieler2.getSiege();
					System.out.println(spieler1.getName() + " hat " + temp + " mehr Siege als " + spieler2.getName());
				} else {
					int temp = spieler2.getSiege() - spieler1.getSiege();
					System.out.println(spieler2.getName() + " hat " + temp + " mehr Siege als " + spieler1.getName());
				}
			}
			
			//fragen ob wiederholt werden soll
			System.out.println("Wollt ihr erneut spielen? 'j' für ja, beliebige Taste für nein.");
			wiederholen = in.nextLine().charAt(0);
			
			//fragen wer sich umbenennen will
			if (wiederholen == 'j') {
				System.out.println("Wird jemand anderes als Spieler1 weiterspielen? wenn ja, werden die Siege mitgelöscht. 'j' für ja, beliebige Taste für nein.");
				umbenennen1 = in.nextLine().charAt(0);
				System.out.println("Wird jemand anderes als Spieler2 weiterspielen? wenn ja, werden die Siege mitgelöscht. 'j' für ja, beliebige Taste für nein.");
				umbenennen2 = in.nextLine().charAt(0);
			}
			
			spiel = null;
		} // end of while
		
		spiel = null;
		spieler1 = null;
		spieler2 = null;
	} //end of main
}