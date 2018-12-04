package Mindow;

import java.awt.Graphics;

public class DefaultDrawer extends Drawer{
	
	private int x, y;
	private int dx, dy;
	
	
	public void tick() {
		x+=dx;
		y+=dy;
	}
	public void draw(Graphics g) {
		g.drawString("Test", x, y);
	}
}
