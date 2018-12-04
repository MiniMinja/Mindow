package Mindow;

import java.awt.Graphics;

public abstract class Drawer {
	
	private static Drawer drawer;
	
	public static Drawer getInstance() {
		if(Drawer.drawer == null) Drawer.drawer = new DefaultDrawer();
		return Drawer.drawer;
	}
	
	public static void setDrawer(Drawer drawer) {
		Drawer.drawer = drawer;
	}
	
	public abstract void tick();
	public abstract void draw(Graphics g);
}
