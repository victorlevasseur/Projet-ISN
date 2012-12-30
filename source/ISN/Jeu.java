package ISN;

import java.io.File;
import java.io.IOException;

import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class Jeu {
	
	//Mettre ici toutes les variables qui doivent être conservée tout au long de l'exécution
	//du jeu (ex : position des perso, vitesse balle...)

	public static void main(String[] args) {
		
		RenderWindow fenetre = new RenderWindow();
		fenetre.create(new VideoMode(1024, 768, 32), "Jeu ISN");
		
		Clock clock = new Clock();
		
		Texture maTexture = new Texture();
		try {
			//Essai de chargement de la texture
			maTexture.loadFromFile(new File("IMAGE/boite_dragees_lila_bk_boitedrageeslila13.jpg"));
			} catch(IOException ex) {
			//Cette partie s'exécute si un problème a eu lieu pendant le chargement de l'image
			ex.printStackTrace();
			}
		Sprite monSprite = new Sprite();
		monSprite.setTexture(maTexture);
		
		while(fenetre.isOpen()){
			
			//Boucle pour récupérer chaque événement (clic de souris, touche clavier) reçu par la fenêtre
			for(Event event : fenetre.pollEvents()){
				
				//event représente l'événement qui sera traité.
				//event.type donne le type d'événement (clic de souris, clavier...)
				//Selon le type de l'événement, il faut utiliser event.asBLABLA() pour récupérer les
				//informations relatives à l'événement (touche du clavier, bouton de souris, position du clic).
				
				if(event.type == Event.Type.CLOSED) {
		            		//L'utilisateur a décidé de fermer le jeu.
		            		fenetre.close();
		            
				}
			}
			
			fenetre.clear();
			
			//Boucle infinie pour gérer le jeu
			Time dureeFrame = clock.restart();
			
			gererJeu(dureeFrame.asSeconds());
			afficherJeu(fenetre);
			
			fenetre.draw(monSprite);
			monSprite.setPosition(200, 100);
			
			fenetre.display();
			
		}
	}
	
	public static void gererJeu(float dureeFrame){
		//Ici, on gérera le jeu (mouvements des persos, menu, collisions...)
	}
	
	public static void afficherJeu(RenderWindow fenetre){
		//Ici, on gérera l'affichage du jeu (dessin des persos...)
	}

}
