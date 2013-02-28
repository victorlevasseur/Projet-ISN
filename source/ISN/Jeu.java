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
	public static Sprite[] personnages;
	public static float rPerso;
	
	public static Sprite balle;
	public static float rBalle;
	
	public static Sprite filet;
	
	public static float vitesseX;
	public static float vitesseY;
	
	public static float g;
	
	public static Texture texturePerso1;
	public static Texture texturePerso2;

	public static void main(String[] args) {
		
		RenderWindow fenetre = new RenderWindow();
		fenetre.create(new VideoMode(1024, 768, 32), "Jeu ISN");
		
		Clock clock = new Clock();
		
		initialisation();
		
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
			
			fenetre.display();
			
		}
	}
	
	public static void initialisation()
	{
		personnages = new Sprite[2];
		personnages[0] = new Sprite();
		personnages[1] = new Sprite();
		
		personnages[0].setOrigin(40, 40);
		personnages[1].setOrigin(40, 40);
		
		personnages[0].setPosition(256, 763);
		personnages[1].setPosition(256 + 512, 763);
		
		filet = new Sprite();
		balle = new Sprite();
		
		rPerso = 40;
		rBalle = 7;
		
		vitesseX = 0;
		vitesseY = 0;
		
		texturePerso1 = new Texture();
		texturePerso2 = new Texture();
		
		try {
			texturePerso1.loadFromFile(new File("IMAGE/persoJ1.png")); 
		} catch(IOException ex) { 
			
		}
		
		try {
			texturePerso2.loadFromFile(new File("IMAGE/persoJ2.png")); 
		} catch(IOException ex) { 
			
		}
		
		personnages[0].setTexture(texturePerso1);
		personnages[1].setTexture(texturePerso2);
	}
	
	public static void gererJeu(float dureeFrame){
		Mouvements.deplacements(dureeFrame);
		//Ici, on gérera le jeu (mouvements des persos, menu, collisions...)
	}
	
	public static void afficherJeu(RenderWindow fenetre){
		//Ici, on gérera l'affichage du jeu (dessin des persos...)
		AffichageTerrain.afficherterrain(fenetre);
		
		fenetre.draw(personnages[0]);
		fenetre.draw(personnages[1]);
	}

}
