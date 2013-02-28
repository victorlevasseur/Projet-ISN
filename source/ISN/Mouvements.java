package ISN;
import org.jsfml.system.*;
import org.jsfml.window.Keyboard;

public class Mouvements {
	public static void deplacements(float dureeFrame){
		Vector2f positionJ1 = Jeu.personnages[0].getPosition();
		if (positionJ1.x - Jeu.rPerso>0 && Keyboard.isKeyPressed(Keyboard.Key.Q)) {
			positionJ1.x = positionJ1.x - 40*dureeFrame;
			Jeu.personnages[0].setPosition(positionJ1);
			
		}
			
	}
}
