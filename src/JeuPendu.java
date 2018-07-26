import java.util.Scanner;

public class JeuPendu {

	/*
	 * le joueur doit trouver le mot de cinq lettres saisi par le maitre du jeu en
	 * dix fois.
	 */

	private static Scanner sc;
	
	private static String strIn;
	private static String strOut;
	private static String strRc;
	
	private static int lngIn = 0;
	private static int lngOut = 0;
	private static int lngRc = 0;
	
	public static void main(String[] args) {

		/*
		 * tant que le mot saisi � la console n'a pas au moins cinq caract�res alors le
		 * maitre du jeu recommence sa saisie d'un mot d'au moins cinq caract�res � la
		 * console
		 */
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Saisir un mot de cinq caract�res : ");
			String strIn = sc.next();

			/*
			 * si le mot est sup�rieur � cinq lettres alors :
			 * 
			 * 1) le mot est tronqu� � cinq caract�res 
			 * 2) le mot de cinq lettres est convertie en majuscules 
			 * 3) le mot de cinq lettres est affich�
			 * 4) le mot est masqu� par 8 sauts de ligne
			 * 
			 */

			strIn = strIn.substring(0, 5);
			// longueur du mot saisi
			lngIn = strIn.length();
			strIn = strIn.toUpperCase();
			System.out.println("Le mot myst�re " + strIn + " longueur " + lngIn);

			int points = 500;
			int essais = 10;
			char trait = '-';
			strOut = "-----";
			boolean trouve = true;
			
			System.out.println("Vous avez 500 points avant de d�buter le jeu du pendu");
			System.out.println("Vous avez 10 essais pour trouver le mot myst�re");

			// boucle tant que (essais n'est pas � z�ro ou que le mot n'est pas trouv�) 
			while (essais > 0 || trouve == false) {
				trouve = (strOut.indexOf(trait) != -1);
				// if (strOut.contains("-"))

				sc = new Scanner(System.in);
				System.out.print("Saisir un caract�re : ");
				String strRc = sc.next();
				strRc = strRc.toUpperCase();
				
				char charRc = strRc.charAt(0);				// caract�re recherch�

				// boucle for sur les cinq caract�res du mot myst�re
				for (int i = 0; i < 5; i++) {
					char[] charOut = strOut.toCharArray();
					char charIn = strIn.charAt(i);			// caract�re du mot myst�re
				
					if (charRc == charIn) {
						charOut[i] = charRc;
				// position = i
				//		strOut = replaceCharAt(strOut, position, charRc);
					} else {
						points = points - 10;
					}
				}
				System.out.println(strOut);					// affiche le r�sultat du mot trouv�
				essais--;
				System.out.println("Il vous reste " + essais + " essais pour trouver le mot myst�re");
			}
		} while (lngIn < 5);
	}
}