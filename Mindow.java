import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Mindow extends JPanel implements Runnable{
	private static Mindow instance;
	private static boolean initialized = false;
	private static Thread animationThread;
	
	public static void init(int width, int height) {
		instance = new Mindow(width, height);
		animationThread = new Thread(instance);
		initialized = true;
	}
	
	public static void start() {
		if(!initialized) {
			throw new IllegalStateException("must call init() first");
		}
		animationThread.start();
	}
	
	public static Mindow getInstance() {
		if(!initialized) {
			throw new IllegalStateException("must call init() first");
		}
		return instance;
	}
	
	private JFrame window;
	private int width, height;
	
	private LinkedList<Renderable> toRender;
	
	private Mindow (int width, int height) {
		toRender = new LinkedList<Renderable>();
		
		window = new JFrame("Collapse");
		
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.width = width;
		this.height = height;
		
		window.setContentPane(this);
		window.pack();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void addToRender(Renderable r) {
		toRender.add(r);
	}
	
	public void removeFromRender(Renderable r) {
		toRender.remove(r);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(Renderable r: toRender) {
			r.draw(g);
		}
	}
	
//--------------------------------------THREAD PART--------------------------------------
	long lastTick;
	
	public void run() {
		while(true) {
			long tick = System.nanoTime();
			if((tick - lastTick)/1e9 > 1/60.0) {
				this.repaint();
				lastTick = System.nanoTime();
			}
		}
	}
}
