package view.component;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GRect extends GComponent{
	
	public float width, height;
	
	public GRect(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public boolean isTouching(float x, float y) {
		return false;
	}
	@Override
	public Rectangle getBounds() {
		Rectangle bound = new Rectangle((int)x, (int)y, (int)width, (int)height);
		return bound;
	}
	

}
