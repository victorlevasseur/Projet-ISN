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
	}
}
