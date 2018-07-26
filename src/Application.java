import java.util.Scanner;

public class Application
{

	/*
	 * Jeu du Pendu
	 * 
	 * Le but de ce jeu célèbre est de deviner un mot dont les lettres
	 * sont initialement inconnues.
	 * Le joueur doit proposer une lettre , et si celle-ci est dans le
	 * mot, alors toutes les occurences sont dévoilées.
	 * La partie se termine une fois toutes les lettres du mot découvertes.
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
	 * Félicitation, vous avez gagné !!
	 * 
	 * Pour la modélisation de ce jeu un tableau
	 * de caractères sera utilisé pour représenter
	 * le mot.
	 * Par exemple, le tableau ['d', 'e', 'v', 'i', 'n', 'e']
	 * représente le mot "devine".
	 * Pour gérer les lettres qui sont connues, on aura aussi un tableau
	 * de booléens tel que la case i contient true si la i-ème lettre du
	 * mot a été découverte. Par exemple à l'avant-dernière étape de 
	 * l'exemple ci-dessus, on aura le tableau [true, true, false, true, true, true].
	 * Le jeu s'arrête lorsque ce tableau ne contient que des true. 
	 */

	public static void main(String[] args) 
	{
		// Déclarer une instance sc de la classe Scanner
		Scanner sc = new Scanner(System.in);
		
		// Déclarer une instance ga de la classe Game
		Game ga = new Game();
		
		/* stocker dans la variable nommée strIn la saisie clavier de l'utilisateur
		 * récuperer la saisie utilisateur a partir de l'instance Scanner nommée sc 
		 * de la méthode next() de la classe Scanner
		 */
		System.out.print("Saisir le mot a deviner : ");
		String strIn = sc.next();
		strIn = strIn.toLowerCase();
		
		ga.partie(strIn);
	}
}