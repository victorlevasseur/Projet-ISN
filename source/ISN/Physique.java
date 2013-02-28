package ISN;

import org.jsfml.system.*;
import org.jsfml.graphics.*;
import java.lang.*;

public class Physique {
	public static void gererPhysique(float dureeFrame)
	{
		Vector2f positionBalle = Jeu.balle.getPosition();
		
		Jeu.vitesseY += Jeu.g * dureeFrame;
		
		for(int j = 0; j < 2; j++)
		{
			Vector2f positionPerso = Jeu.personnages[j].getPosition();
			double distanceCarre = Math.pow(positionBalle.x - positionPerso.x, 2) + Math.pow(positionBalle.y - positionPerso.y, 2);
			
			if(Math.sqrt(distanceCarre) < (Jeu.rPerso + Jeu.rBalle))
			{
				if(!Jeu.dejaCollision[j])
				{
					Jeu.vitesseY = -Jeu.vitesseY;
				}
				Jeu.dejaCollision[j] = true;
			}
			else
			{
				Jeu.dejaCollision[j] = false;
			}
		}
		
		Jeu.balle.move(Jeu.vitesseX * dureeFrame, Jeu.vitesseY * dureeFrame);
	}
}
