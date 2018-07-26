import java.util.Scanner;

public class Game
{	
	// Déclarer une instance sc de la classe Scanner
	static Scanner sc = new Scanner(System.in);
	
	//-------------------------------------------
	// 1ere méthode : char[] motVersTab(String s)
	//-------------------------------------------
	//
	// Mot à deviner à stocker dans un tableau de caractères
	//
	public static char[] motVersTab(String s)
	{
		// Déclarer un tableau de caractères
		int taille = s.length();
		char[] tabChar = new char[taille];
		
		/* stocker la chaine de caractères mot 
		 * dans un tableau de caractères tabChar
		 */
		
		for (int i = 0; i < taille; i++)
		{
			// charAt est une méthode de la classe String
      		// qui permet de stocker une chaine de caractères
      		// dans un tableau de caractères 
      		tabChar[i] = s.charAt(i);
      	}
     
		/* ou bien
		 * 
		 * stocker la chaine de caractères mot 
		 * dans un tableau de caractères tabChar
		 *
		 * tabChar = s.toCharArray();
		 */

		for (int i = 0; i < taille; i++)
		{
			if (i < taille - 1)
				if (i == 0)
					System.out.print("['" + tabChar[i] + "'");
				else
					System.out.print(", '" + tabChar[i] + "'");
			else
				System.out.println(", '" + tabChar[i] + "']");
		}
		System.out.println();
		return tabChar;
	}
	
	//------------------------------------------------------
	// 2ème méthode : void affiche(char[] mot, boolean[] vu)
	//-----------------------------------------------------
	//
	// Afficher les lettres trouvées du mot a deviner
	// et mettre un caractère "?" pour lettres non trouvées
	// a partir du tableau de booléens
	//
	public static void affiche(char[] mot, boolean[] vu)
	{
		for (int i = 0; i < mot.length; i++)
		{
			if (vu[i] == true)
				System.out.print(mot[i]);
			else
				System.out.print("?");
		}
	}
	
	//--------------------------------------------------------------------
	// 3ème méthode : boolean[] metAJour(char[] mot, boolean[] vu, char c)
	//--------------------------------------------------------------------
	//
	// Mise à jour du tableau de booléens vu
	// a partir du caractère saisie c en le comparant avec
	// chaque lettre du tableau mot
	//--------------------------------------------------
	public static boolean[] metAJour(char[] mot, boolean[] vu, char c)
	{
		for (int i = 0; i < mot.length; i++)
		{
			if (mot[i] == c)
			{
				mot[i] = c;
				vu[i] = true;
			}
			else
			{
				if (vu[i] != true) 
					vu[i] = false;
			}
		}
		return vu;
	}
	
	//-------------------------------------------------
	// 4ème méthode : boolean partieFinie(boolean vu[])
	//-------------------------------------------------
	//
	// retourne un boolean true si le tableau vu ne
	// contient que des true et revoit un false sinon
	//-------------------------------------------------
	public static boolean partieFinie(boolean vu[])
	{
		for (int i = 0; i < vu.length; i++)
		{
			if (vu[i] == false)
				return false;
		}
		return true;
	}
	
	// 5ème méthode - partie
	public static void partie(String mot)
	{
		char[] tabch = motVersTab(mot);
		
		boolean[] vu1 = new boolean[mot.length()];
	
		while (!partieFinie(vu1))
		{
			System.out.print("Lettre minuscule ? ");
			char c = sc.nextLine().charAt(0);
			boolean[] vu2 = metAJour(tabch, vu1, c);
			affiche(tabch, vu2);
			System.out.println();
		}
		System.out.println("Félicitation, vous avez gagné !!");
	}
}