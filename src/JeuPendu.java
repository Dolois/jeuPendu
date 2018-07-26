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
		 * tant que le mot saisi à la console n'a pas au moins cinq caractères alors le
		 * maitre du jeu recommence sa saisie d'un mot d'au moins cinq caractères à la
		 * console
		 */
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Saisir un mot de cinq caractères : ");
			String strIn = sc.next();

			/*
			 * si le mot est supérieur à cinq lettres alors :
			 * 
			 * 1) le mot est tronqué à cinq caractères 
			 * 2) le mot de cinq lettres est convertie en majuscules 
			 * 3) le mot de cinq lettres est affiché
			 * 4) le mot est masqué par 8 sauts de ligne
			 * 
			 */

			strIn = strIn.substring(0, 5);
			// longueur du mot saisi
			lngIn = strIn.length();
			strIn = strIn.toUpperCase();
			System.out.println("Le mot mystère " + strIn + " longueur " + lngIn);

			int points = 500;
			int essais = 10;
			char trait = '-';
			strOut = "-----";
			boolean trouve = true;
			
			System.out.println("Vous avez 500 points avant de débuter le jeu du pendu");
			System.out.println("Vous avez 10 essais pour trouver le mot mystère");

			// boucle tant que (essais n'est pas à zéro ou que le mot n'est pas trouvé) 
			while (essais > 0 || trouve == false) {
				trouve = (strOut.indexOf(trait) != -1);
				// if (strOut.contains("-"))

				sc = new Scanner(System.in);
				System.out.print("Saisir un caractère : ");
				String strRc = sc.next();
				strRc = strRc.toUpperCase();
				
				char charRc = strRc.charAt(0);				// caractère recherché

				// boucle for sur les cinq caractères du mot mystère
				for (int i = 0; i < 5; i++) {
					char[] charOut = strOut.toCharArray();
					char charIn = strIn.charAt(i);			// caractère du mot mystère
				
					if (charRc == charIn) {
						charOut[i] = charRc;
				// position = i
				//		strOut = replaceCharAt(strOut, position, charRc);
					} else {
						points = points - 10;
					}
				}
				System.out.println(strOut);					// affiche le résultat du mot trouvé
				essais--;
				System.out.println("Il vous reste " + essais + " essais pour trouver le mot mystère");
			}
		} while (lngIn < 5);
	}
}