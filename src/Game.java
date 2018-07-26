import java.util.Scanner;

public class Game
{	
	// D�clarer une instance sc de la classe Scanner
	static Scanner sc = new Scanner(System.in);
	
	//-------------------------------------------
	// 1ere m�thode : char[] motVersTab(String s)
	//-------------------------------------------
	//
	// Mot � deviner � stocker dans un tableau de caract�res
	//
	public static char[] motVersTab(String s)
	{
		// D�clarer un tableau de caract�res
		int taille = s.length();
		char[] tabChar = new char[taille];
		
		/* stocker la chaine de caract�res mot 
		 * dans un tableau de caract�res tabChar
		 */
		
		for (int i = 0; i < taille; i++)
		{
			// charAt est une m�thode de la classe String
      		// qui permet de stocker une chaine de caract�res
      		// dans un tableau de caract�res 
      		tabChar[i] = s.charAt(i);
      	}
     
		/* ou bien
		 * 
		 * stocker la chaine de caract�res mot 
		 * dans un tableau de caract�res tabChar
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
	// 2�me m�thode : void affiche(char[] mot, boolean[] vu)
	//-----------------------------------------------------
	//
	// Afficher les lettres trouv�es du mot a deviner
	// et mettre un caract�re "?" pour lettres non trouv�es
	// a partir du tableau de bool�ens
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
	// 3�me m�thode : boolean[] metAJour(char[] mot, boolean[] vu, char c)
	//--------------------------------------------------------------------
	//
	// Mise � jour du tableau de bool�ens vu
	// a partir du caract�re saisie c en le comparant avec
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
	// 4�me m�thode : boolean partieFinie(boolean vu[])
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
	
	// 5�me m�thode - partie
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
		System.out.println("F�licitation, vous avez gagn� !!");
	}
}