package Mindow;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class Mindow extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Mindow getDefault() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		return new Mindow(d.width * 3 / 4, d.height * 3 / 4);
	}
	
	public static int w = 1280, h = 720;
	
	private JFrame frame;
	public Mindow(int w, int h) {
		this.setMinimumSize(new Dimension(w,h));
		this.setPreferredSize(new Dimension(w,h));
		this.setMaximumSize(new Dimension(w,h));
		
		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		Toolkit.getDefaultToolkit().sync();
		super.paint(g);
		Drawer.getInstance().draw(g);
	}
	public void render() {
		this.repaint();
	}
	
	public void addKeyListener(KeyListener keylistener) {
		super.addKeyListener(keylistener);
		frame.addKeyListener(keylistener);
	}
	
	public void addMouseInputListener(MouseInputListener mil) {
		super.addMouseListener(mil);
		super.addMouseMotionListener(mil);
		frame.addMouseListener(mil);
		frame.addMouseMotionListener(mil);
	}
}
