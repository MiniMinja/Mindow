package Mindow;

import java.awt.Graphics;

public class DefaultDrawer extends Drawer{
	
	private int x, y;
	private int dx, dy;
	
	public DefaultDrawer() {
		dx = 1;
		dy = 1;
	}
	
	public void tick() {
		x+=dx;
		y+=dy;
	}
	
	public void draw(Graphics g) {
		g.drawString("Test", x, y);
	}
}
