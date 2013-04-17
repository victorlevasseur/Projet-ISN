package ISN;

public class Scores {
	public static void AjouterUnPoint(int NumeroJoueur){
		Jeu.scores[NumeroJoueur] += 1;
		System.out.println("Scores : " + Jeu.scores[0] + " " + Jeu.scores[1]);
		Jeu.texte.setString("J1 : " + Jeu.scores[0] + "	J2 : " + Jeu.scores[1]);
		if (Jeu.scores[NumeroJoueur]==7){
			Jeu.finPartie = true;
		}
	}
	
	public static int JoueurGagnant(){
		if(Jeu.scores[0] > Jeu.scores[1])
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}