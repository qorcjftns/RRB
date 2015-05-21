package view.component;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GComponent {
	
	public float x, y;
	public float vx = 0, vy = 0;
	
	
	public GComponent() {}
	
	public static boolean isCollision(GComponent c1, GComponent c2) {
		return c1.getBounds().intersects(c2.getBounds());
	}
	
	abstract public void draw(Graphics g);
	abstract public Rectangle getBounds();
	abstract public boolean isTouching(float x, float y);
}
