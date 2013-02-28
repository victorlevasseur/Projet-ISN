package ISN;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;
import org.jsfml.graphics.Color;

public class AffichageTerrain {
	public static void afficherterrain(){
		RectangleShape monRectangle = new RectangleShape();
		monRectangle.setSize(new Vector2f(1024, 1));
		monRectangle.setFillColor(new Color(255, 255, 255, 255));
	}
}
