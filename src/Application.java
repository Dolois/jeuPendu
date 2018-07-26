import java.util.Scanner;

public class Application
{

	/*
	 * Jeu du Pendu
	 * 
	 * Le but de ce jeu c�l�bre est de deviner un mot dont les lettres
	 * sont initialement inconnues.
	 * Le joueur doit proposer une lettre , et si celle-ci est dans le
	 * mot, alors toutes les occurences sont d�voil�es.
	 * La partie se termine une fois toutes les lettres du mot d�couvertes.
	 * 
	 * Voici une exemple de partie :
	 * 
	 * ? ? ? ? ? ? ? ? ?
	 * Lettre : e
	 * ? ? ? ? ? e ? ? ?
	 * Lettre : u
	 * ? u ? u ? e ? ? u
	 * Lettre : a
	 * ? u ? u ? e ? ? u
	 * Lettre : l
	 * ? u l u ? e ? l u
	 * Lettre : r
	 * ? u l u ? e r l u
	 * Lettre : b
	 * ? u l u b e r l u
	 * Lettre : h
	 * h u l u b e r l u
	 * 
	 * F�licitation, vous avez gagn� !!
	 * 
	 * Pour la mod�lisation de ce jeu un tableau
	 * de caract�res sera utilis� pour repr�senter
	 * le mot.
	 * Par exemple, le tableau ['d', 'e', 'v', 'i', 'n', 'e']
	 * repr�sente le mot "devine".
	 * Pour g�rer les lettres qui sont connues, on aura aussi un tableau
	 * de bool�ens tel que la case i contient true si la i-�me lettre du
	 * mot a �t� d�couverte. Par exemple � l'avant-derni�re �tape de 
	 * l'exemple ci-dessus, on aura le tableau [true, true, false, true, true, true].
	 * Le jeu s'arr�te lorsque ce tableau ne contient que des true. 
	 */

	public static void main(String[] args) 
	{
		// D�clarer une instance sc de la classe Scanner
		Scanner sc = new Scanner(System.in);
		
		// D�clarer une instance ga de la classe Game
		Game ga = new Game();
		
		/* stocker dans la variable nomm�e strIn la saisie clavier de l'utilisateur
		 * r�cuperer la saisie utilisateur a partir de l'instance Scanner nomm�e sc 
		 * de la m�thode next() de la classe Scanner
		 */
		System.out.print("Saisir le mot a deviner : ");
		String strIn = sc.next();
		strIn = strIn.toLowerCase();
		
		ga.partie(strIn);
	}
}