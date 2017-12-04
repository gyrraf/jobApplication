package spiele;

import java.util.Scanner;

/**
 * Speichert einen Spieler und die Anzahl gewonnener Spiele dieses Spielers
 * @author Raffael
 */
public class Player {
	private static Scanner in = new Scanner(System.in);
	
	private String name;
	private int siege;
	private int spielerNr;
	
	/**
	 * Konstruktor mit Name und SpielerNr
	 * @param name
	 * @param spielerNr
	 */
	public Player(String name, int spielerNr) {
		setName(name);
		siege = 0;
		this.spielerNr = spielerNr;
	}
	
	/**
	 * Konstruktor ohne Name mit spielerNr
	 * @param spielerNr
	 */
	public Player(int spielerNr) {
		setName("Spieler " + spielerNr);
		siege = 0;
		this.spielerNr = spielerNr;
	}
	
	/**
	 * Konstruktor mit name ohne spielerNr
	 * @param name
	 */
	public Player (String name) {
		setName(name);
		siege = 0;
		spielerNr = 1;
	}
	
	/**
	 * Konstruktor ohne name und ohen spielerNr
	 */
	public Player() {
		setName("name");
		siege = 0;
		spielerNr = 1;
	}
	
	/**
	 * namen setzen
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Spieler umbenennen
	 */
	public void umbenennen() {
		System.out.println("Spieler " + spielerNr + ": Wie möchten Sie genannt werden?");
		
		//Namen eingeben und bestätigen
		String name = "";
		char ok = 'n';
		while (ok != 'j') {
			System.out.println("Bitte geben Sie unten ihren Namen ein:");
			name = in.nextLine();
			System.out.println("Ist dieser name in Ordnung: " + name + " ?");
			System.out.println("'j' für ja, 'n' für nein");
			ok = in.nextLine().charAt(0);
		}
		
		setName(name);
	}
	
	/**
	 * Sieg hinzufügen
	 */
	public void addSieg() {
		siege = siege + 1;
	}
	
	/**
	 * spielerNummer zurückgeben
	 * @return
	 */
	public int getSpielerNr() {
		return spielerNr;
	}
	
	/**
	 * name zurückgeben
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Siege zurückgeben
	 * @return
	 */
	public int getSiege() {
		return siege;
	}
}