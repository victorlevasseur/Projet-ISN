package ISN;
import org.jsfml.system.*;
import org.jsfml.window.Keyboard;

public class Mouvements {
	public static void deplacements(float dureeFrame){
		Vector2f positionJ1 = Jeu.personnages[0].getPosition();
		if (positionJ1.x - Jeu.rPerso>0 && Keyboard.isKeyPressed(Keyboard.Key.Q)) {		
			
			Jeu.personnages[0].move(-200*dureeFrame, 0);
		}
		if (positionJ1.x + Jeu.rPerso<507 && Keyboard.isKeyPressed(Keyboard.Key.D)) {		
			
			Jeu.personnages[0].move(+200*dureeFrame, 0);
		}
		Vector2f positionJ2 = Jeu.personnages[1].getPosition();
		if (positionJ2.x - Jeu.rPerso>517 && Keyboard.isKeyPressed(Keyboard.Key.LEFT)) {		
			
			Jeu.personnages[1].move(-200*dureeFrame, 0);
		}
		if (positionJ2.x + Jeu.rPerso<1024 && Keyboard.isKeyPressed(Keyboard.Key.RIGHT)) {		
			
			Jeu.personnages[1].move(+200*dureeFrame, 0);
		}			
	}
	
	public static void LancerNouveauPoint(int NumeroJoueur)
	{
		Jeu.personnages[0].setPosition(256, 763);
		Jeu.personnages[1].setPosition(256 + 512, 763);
		
		if(NumeroJoueur == 0)
		{
			Jeu.balle.setPosition(256, 200);
		}
		else
		{
			Jeu.balle.setPosition(256 + 512, 200);
		}
	}
}
