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
	
	//Mettre ici toutes les variables qui doivent Ãªtre conservÃ©e tout au long de l'exÃ©cution
	//du jeu (ex : position des perso, vitesse balle...)
	// -> Il faut mettre public static devant pour qu'elles soient globales
	//		ex : public static Texture texturePerso1;
	// -> Il ne faut pas oublier de les initialiser dans la fonction initialisation()
	//		ex : texturePerso1 = new Texture(); //dans la fonction initialisation()
	// -> Pour y accÃ©der depuis un autre fichier, il faut les prÃ©fixer de "Jeu."
	//		ex : Jeu.rPerso
	
	public static Sprite[] personnages;
	public static float rPerso;
	
	public static Sprite balle;
	public static float rBalle;
	public static int[] scores;
	public static boolean finPartie;
	
	//Pour le moteur physique
	public static float vitesseX;
	public static float vitesseY;
	public static float g;
	public static boolean[] dejaCollision;
	
	public static Texture texturePerso1;
	public static Texture texturePerso2;
	public static Texture textureBalle;
	public static Font police;
	public static Text texte;
	public static Text texteVictoire;

	public static void main(String[] args) {
		
		RenderWindow fenetre = new RenderWindow();
		fenetre.create(new VideoMode(1024, 768, 32), "Jeu ISN");
		finPartie = false;
		
		Clock clock = new Clock();
		
		initialisation();
		
		while(fenetre.isOpen()){
			
			//Boucle pour rÃ©cupÃ©rer chaque Ã©vÃ©nement (clic de souris, touche clavier) reÃ§u par la fenÃªtre
			for(Event event : fenetre.pollEvents()){
				
				//event reprÃ©sente l'Ã©vÃ©nement qui sera traitÃ©.
				//event.type donne le type d'Ã©vÃ©nement (clic de souris, clavier...)
				//Selon le type de l'Ã©vÃ©nement, il faut utiliser event.asBLABLA() pour rÃ©cupÃ©rer les
				//informations relatives Ã  l'Ã©vÃ©nement (touche du clavier, bouton de souris, position du clic).
				
				if(event.type == Event.Type.CLOSED) {
		            		//L'utilisateur a dÃ©cidÃ© de fermer le jeu.
		            		fenetre.close();
		            
				}
			}
			
			fenetre.clear();
			
			//Boucle infinie pour gÃ©rer le jeu
			Time dureeFrame = clock.restart();
			if (finPartie == false){
				gererJeu(dureeFrame.asSeconds());
				afficherJeu(fenetre);
			}
			else
			{
				texteVictoire.setString("Victoire !\n" + "Joueur " + (Scores.JoueurGagnant() +1 ));
				fenetre.draw(texteVictoire);
			}
			
			fenetre.display();
			
		}
	}
	
	public static void initialisation()
	{
		rPerso = 40;
		rBalle = 7;
		
		g = 500;
		vitesseX = 0;
		vitesseY = 0;
		dejaCollision = new boolean[2];
		dejaCollision[0] = false;
		dejaCollision[1] = false;
		
		personnages = new Sprite[2];
		personnages[0] = new Sprite();
		personnages[1] = new Sprite();
		
		scores = new int[2];
		
		personnages[0].setOrigin(rPerso, rPerso);
		personnages[1].setOrigin(rPerso, rPerso);
		
		personnages[0].setPosition(256, 763);
		personnages[1].setPosition(256 + 512, 763);
		
		balle = new Sprite();
		
		balle.setOrigin(rBalle, rBalle);
		balle.setPosition(256, 200);
		
		texturePerso1 = new Texture();
		texturePerso2 = new Texture();
		textureBalle = new Texture();
		
		try {
			texturePerso1.loadFromFile(new File("IMAGE/persoJ1.png")); 
		} catch(IOException ex) { 
			
		}
		
		try {
			texturePerso2.loadFromFile(new File("IMAGE/persoJ2.png")); 
		} catch(IOException ex) { 
			
		}
		
		try {
			textureBalle.loadFromFile(new File("IMAGE/balle.png")); 
		} catch(IOException ex) { 
			
		}
		
		personnages[0].setTexture(texturePerso1);
		personnages[1].setTexture(texturePerso2);
		balle.setTexture(textureBalle);
		
		police = new Font();
		try { 
			police.loadFromFile(new File("LiquidCrystal-Normal.otf"));
		} catch(IOException ex) { 
			ex.printStackTrace(); 
		}
		
		texte = new Text();
		texte.setFont(police);
		texte.setString("J1 : 0	J2 : 0");
		
		texte.setPosition(10, 10);
		
		texteVictoire = new Text();
		texteVictoire.setFont(police);
		texteVictoire.setCharacterSize(200);
		texteVictoire.setString("Victoire !");
		
		texteVictoire.setPosition(140, 200);
	}
	
	public static void gererJeu(float dureeFrame){
		Mouvements.deplacements(dureeFrame);
		Physique.gererPhysique(dureeFrame);
		//Ici, on gÃ©rera le jeu (mouvements des persos, menu, collisions...)
		
	}
	
	public static void afficherJeu(RenderWindow fenetre){
		//Ici, on gÃ©rera l'affichage du jeu (dessin des persos...)
		AffichageTerrain.afficherterrain(fenetre);
		
		fenetre.draw(personnages[0]);
		fenetre.draw(personnages[1]);
		fenetre.draw(balle);
		
		fenetre.draw(texte);
	}

}
