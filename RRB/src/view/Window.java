package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;

import view.component.GCircle;
import view.component.GComponent;
import view.component.GRect;
import controller.PhysicsCalculation;



public class Window extends JFrame{

	Vector<GComponent> comps = new Vector<GComponent>();
	Canvas canvas;
	BufferStrategy bs;
	
	int width = 640;
	int height = 480;
	
	public void add(GComponent comp) {
		comps.add(comp);
	}
	
	public void draw() {
		this.setTitle("RRB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(640, 480));
		this.setVisible(true);
		
		canvas = new Canvas();
		
		canvas.setBackground(Color.WHITE);
		canvas.setSize(640, 480);
		
		this.add(canvas);
		
		// add border
		GRect upper = new GRect(-1,-1, 1,height);
		GRect left = new GRect(-1,-1, width,1);
		GRect lower = new GRect(-1,height+1, width,1);
		GRect right = new GRect(width+1,-1, 1,height);
		
		upper.vy = 1;
		left.vx = 1;
		right.vx = -1;
		lower.vy = -1;
		
		this.add(upper);
		this.add(left);
		this.add(right);
		this.add(lower);
		
		// Add two components
		this.add(new GCircle(100, 100, 30));
		this.add(new GCircle(200, 100, 30));
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		
		this.pack();
		
		this.setLocationRelativeTo(null);
		
		// Enable Physics Calculation.
		PhysicsCalculation calc = new PhysicsCalculation(comps, canvas);
		calc.start();
		
		// Start main drawing loop.
		DrawLoop draw = new DrawLoop();
		draw.start();
	}
	private class DrawLoop extends Thread {
		@Override
		public void run() {
			super.run();
			while(true) {
				Iterator<GComponent> it = comps.iterator();
				Graphics g = bs.getDrawGraphics(); // Get graphics
				g.clearRect(0, 0, 640, 480); // Clear canvas
				while(it.hasNext()) { // Draw
					GComponent gc = it.next(); // Get next GComponent item.
					gc.draw(g); // Draw item.
				}
				if(!bs.contentsLost())bs.show();
				
			}
		}
	}
}
