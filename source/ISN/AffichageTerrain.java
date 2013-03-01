package ISN;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.graphics.Color;

public class AffichageTerrain {
	public static void afficherterrain(RenderWindow fenetre){
		RectangleShape monRectangle = new RectangleShape();
		monRectangle.setSize(new Vector2f(1024, 5));
		monRectangle.setFillColor(new Color(255, 255, 255, 255));
		monRectangle.setPosition(0, 763);
		
		RectangleShape filet = new RectangleShape();
		filet.setSize(new Vector2f(10, 485));
		filet.setFillColor(new Color(255, 255, 255, 255));
		filet.setPosition(507, 638);
		
		fenetre.draw(monRectangle);
		fenetre.draw(filet);
	}
}
