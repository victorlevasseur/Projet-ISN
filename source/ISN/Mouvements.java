package ISN;
import org.jsfml.system.*;
import org.jsfml.window.Keyboard;

public class Mouvements {
	public static void deplacements(float dureeFrame){
		Vector2f positionJ1 = Jeu.personnages[0].getPosition();
		if (positionJ1.x - Jeu.rPerso>0 && Keyboard.isKeyPressed(Keyboard.Key.Q)) {		
			
			//move permet de bouger l'objet par rapport à sa position actuelle.
			//Une vitesse de 150 px/s est idéale ! :)
			Jeu.personnages[0].move(-140*dureeFrame, 0);
		}
		if (positionJ1.x - Jeu.rPerso<507 && Keyboard.isKeyPressed(Keyboard.Key.D)) {		
			
			//move permet de bouger l'objet par rapport à sa position actuelle.
			//Une vitesse de 150 px/s est idéale ! :)
			Jeu.personnages[0].move(+140*dureeFrame, 0);
		Vector2f positionJ2 = Jeu.personnages[1].getPosition();
		if (positionJ2.x - Jeu.rPerso>517 && Keyboard.isKeyPressed(Keyboard.Key.LEFT)) {		
			
			//move permet de bouger l'objet par rapport à sa position actuelle.
			//Une vitesse de 150 px/s est idéale ! :)
			Jeu.personnages[1].move(-140*dureeFrame, 0);
		}
		if (positionJ2.x - Jeu.rPerso<1024 && Keyboard.isKeyPressed(Keyboard.Key.RIGHT)) {		
			
			//move permet de bouger l'objet par rapport à sa position actuelle.
			//Une vitesse de 150 px/s est idéale ! :)
			Jeu.personnages[1].move(+140*dureeFrame, 0);
			}			
		}
	}
}
