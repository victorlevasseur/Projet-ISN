package ISN;

import org.jsfml.system.Vector2f;

public class Physique {
	
	public static void gererPhysique(float dureeFrame)
	{
		Vector2f positionBalle = Jeu.balle.getPosition();
		
		//Pesanteur
		Jeu.vitesseY += Jeu.g * dureeFrame;
		
		//Collision sur les bords gauche et droit
		if((positionBalle.x - Jeu.rBalle < 0) || (positionBalle.x + Jeu.rBalle > 1024))
		{
			System.out.println("Collision avec les bords");
			Jeu.vitesseX = -Jeu.vitesseX;
		}
		
		//Collision sur le filet
		if((positionBalle.x + Jeu.rBalle > 507) && 
		   (positionBalle.x - Jeu.rBalle < 507 + 10) && 
		   (positionBalle.y + Jeu.rBalle > 638))
		{
			System.out.println("Collision avec le filet");
			
			if(positionBalle.y < 638)
			{
				//La balle tape au-dessus
				Jeu.vitesseY = -Jeu.vitesseY;
			}
			else
			{
				//La balle tape sur les côtés
				Jeu.vitesseX = -Jeu.vitesseX;
			}
		}
		
		//Collisions sur les personnages
		for(int j = 0; j < 2; j++)
		{
			//Passage sur chaque personnage
			Vector2f positionPerso = Jeu.personnages[j].getPosition();
			double distanceCarre = Math.pow(positionBalle.x - positionPerso.x, 2) + Math.pow(positionBalle.y - positionPerso.y, 2);
			
			if(Math.sqrt(distanceCarre) < (Jeu.rPerso + Jeu.rBalle)) //Si la balle est en collision avec le personnage
			{
				//Si la balle a déjà été en contact avec le personnage à la frame
				//précédante, on ne réapplique pas la force
				if(!Jeu.dejaCollision[j])
				{		
					System.out.println("Collision avec le joueur " + (j + 1));
					double angleDeCollision = angleDeCollision(positionPerso, positionBalle);
					double angleIncident = angleIncident(Jeu.vitesseX, Jeu.vitesseY);
					
					double norme = Math.sqrt(Math.pow(Jeu.vitesseX, 2) + Math.pow(Jeu.vitesseY, 2));
					double angleDeRenvoi = (angleDeCollision)/* + (angleDeCollision - angleIncident)*/;
					
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
		
		if(Jeu.balle.getPosition().y > 763)
		{
			Jeu.vitesseX = Jeu.vitesseY = 0;
			
			if(Jeu.balle.getPosition().x < 512)
			{
				Scores.AjouterUnPoint(1);
				Mouvements.LancerNouveauPoint(1);
			}
			else
			{
				Scores.AjouterUnPoint(0);
				Mouvements.LancerNouveauPoint(0);
			}
		}
		
		//Déplacement de la balle
		Jeu.balle.move(Jeu.vitesseX * dureeFrame, Jeu.vitesseY * dureeFrame);
	}
	
	/**
	 * Fonction qui calcule l'angle de segment reliant le centre du perso et le centre de la balle
	 * @param positionJ position du joueur
	 * @param positionB position de la balle
	 * @return angle en radians
	 */
	public static double angleDeCollision(Vector2f positionJ, Vector2f positionB)
	{
		double angleD = 0.d;
		
		double distance = Math.sqrt(Math.pow(positionB.x - positionJ.x, 2) + Math.pow(positionB.y - positionJ.y, 2));
		double adjacent = positionB.x - positionJ.x;
		
		angleD = Math.acos(adjacent / distance);
		
		return angleD;
	}
	
	/**
	 * Calcule l'angle incident selon la vitesse
	 * @param vitesseX vitesse sur X
	 * @param vitesseY vitesse sur Y
	 * @return angle en radians
	 */
	public static double angleIncident(float vitesseX, float vitesseY)
	{
		double vitesse = Math.sqrt(Math.pow(vitesseX, 2) + Math.pow(vitesseY, 2));
		
		return Math.acos(vitesseX / vitesse);
	}
}
