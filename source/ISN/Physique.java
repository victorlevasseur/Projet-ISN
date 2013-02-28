package ISN;

import org.jsfml.system.*;
import org.jsfml.graphics.*;
import java.lang.*;

public class Physique {
	
	public static void gererPhysique(float dureeFrame)
	{
		Vector2f positionBalle = Jeu.balle.getPosition();
		
		Jeu.vitesseY += Jeu.g * dureeFrame;
		
		if((positionBalle.x - Jeu.rBalle < 0) || (positionBalle.x + Jeu.rBalle > 1024))
		{
			Jeu.vitesseX = -Jeu.vitesseX;
		}
		
		for(int j = 0; j < 2; j++)
		{
			Vector2f positionPerso = Jeu.personnages[j].getPosition();
			double distanceCarre = Math.pow(positionBalle.x - positionPerso.x, 2) + Math.pow(positionBalle.y - positionPerso.y, 2);
			
			if(Math.sqrt(distanceCarre) < (Jeu.rPerso + Jeu.rBalle))
			{
				if(!Jeu.dejaCollision[j])
				{					
					double angleDeCollision = angleDeCollision(positionPerso, positionBalle);
					double angleIncident = angleIncident(Jeu.vitesseX, Jeu.vitesseY);
					
					double norme = Math.sqrt(Math.pow(Jeu.vitesseX, 2) + Math.pow(Jeu.vitesseY, 2));
					double angleDeRenvoi = (angleDeCollision) - (angleIncident - Math.PI / 2);;
					
					Jeu.vitesseX = (float) (norme * Math.cos(angleDeRenvoi));
					Jeu.vitesseY = (float) (-norme * Math.sin(angleDeRenvoi));
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
	
	public static double angleDeCollision(Vector2f positionJ, Vector2f positionB)
	{
		double angleD = 0.d;
		
		double distance = Math.sqrt(Math.pow(positionB.x - positionJ.x, 2) + Math.pow(positionB.y - positionJ.y, 2));
		double adjacent = positionB.x - positionJ.x;
		
		angleD = Math.acos(adjacent / distance);
		
		return angleD;
	}
	
	public static double angleIncident(float vitesseX, float vitesseY)
	{
		double vitesse = Math.sqrt(Math.pow(vitesseX, 2) + Math.pow(vitesseY, 2));
		
		return Math.acos(vitesseX / vitesse);
	}
}
