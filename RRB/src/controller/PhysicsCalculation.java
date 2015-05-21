package controller;

import java.awt.Canvas;
import java.util.Iterator;
import java.util.Vector;

import view.component.GCircle;
import view.component.GComponent;

public class PhysicsCalculation extends Thread{
	
	private double gravity = 0.001;
	private Canvas canvas;
	
	Vector<GComponent> comps = new Vector<GComponent>();
	
	public PhysicsCalculation(Vector<GComponent> cs, Canvas c) {
		comps = cs;
		canvas = c;
	}
	
	@Override
	public void run() {
		while(true) {
			Iterator<GComponent> it = comps.iterator();
			while(it.hasNext()) { // Draw
				GComponent gc = it.next(); // Get next GComponent item.
				if(gc instanceof GCircle) {
					GCircle circle = (GCircle) gc;
					circle.vy += gravity; // add gravitational acceleration.
					circle.y += circle.vy;
					circle.vx = (float) 0.15;
					circle.x += circle.vx;
					
					// Collision Check
					Iterator<GComponent> toCheck = comps.iterator();
					while(toCheck.hasNext()) { // Draw
						GComponent comp = toCheck.next();
						if(comp == gc) continue;
						if(GComponent.isCollision(gc, comp)) {
							System.out.println("border vx, vy: " + comp.vx +"," + comp.vy);
							if(comp.vx != 0) {
								circle.vx *= comp.vx;
								System.out.println("new circle'x vx: " + circle.vx);
							}
							if(comp.vy != 0) {
								circle.vy *= comp.vy;
							}
						}
					}
				}
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}