package Mindow;

public class Test {
	public static void main(String[] args) {
		Mindow m = Mindow.getDefault();
		Thread job = new Thread(new Runnable() {
			public void run() {
				try {
					Drawer.getInstance().tick();
					m.render();
					Thread.sleep(11);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		job.start();
	}
}
