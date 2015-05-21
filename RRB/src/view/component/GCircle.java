package view.component;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GCircle extends GComponent {

	public float r;
	public GCircle(float x, float y, float r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval((int)x, (int)y, (int)r, (int)r);
	}
	
	public boolean isTouching(float x, float y) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle bound = new Rectangle((int)x, (int)y, (int)r, (int)r);
		return bound;
	}	
	

}
