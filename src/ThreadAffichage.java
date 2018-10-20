import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;


public class ThreadAffichage extends Thread {

	public ThreadAffichage() {
	}

	public ThreadAffichage(String name) {
		super(name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target) {
		super(group, target);

	}

	public ThreadAffichage(ThreadGroup group, String name) {
		super(group, name);

	}

	public ThreadAffichage(Runnable target, String name) {
		super(target, name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);

	}

	@Override
	public void run() {
		super.run();
		
		JFrame mainFrame = new JFrame("POOA - PigeonSquare");
		mainFrame.setSize(600, 600);
		Parc c = new Parc();
		mainFrame.getContentPane().add(c);
		mainFrame.pack();
		
		mainFrame.setVisible(true);
		
		mainFrame.addMouseListener(new MouseListener() { 
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				c.createFood(e.getX(), e.getY());
				System.out.println(c.food);	
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		while (true) {
			c.paintComponent(c.getGraphics());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
	
	
