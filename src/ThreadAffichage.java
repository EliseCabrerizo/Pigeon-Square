import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class ThreadAffichage extends Thread {

	//Constructor
	public ThreadAffichage() {
	}
	
	//Boucle de simulation
	@Override
	public void run() {
		super.run();

		Parc c = new Parc();
		createWindow(c);

		while (true) {
			c.repaint();
			rockOccurence(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//Creation de la fenetre de simulation
	public void createWindow(Parc c){
		//Proprietes de la fenetre
		JFrame mainFrame = new JFrame("POOA - PigeonSquare");
		mainFrame.getContentPane().add(c);
		mainFrame.setSize(Parc.windowSize, Parc.windowSize);
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
		
		//Gestion du clic de la souris
		mainFrame.addMouseListener(new MouseListener() { 

			//Creation de la nourriture au clic de la souris
			@Override
			public void mouseClicked(MouseEvent e) {
				c.createFood(e.getX(), e.getY());
			}


			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});


	}

	
	public void rockOccurence(Parc c) {
		//Occurence aléatoire pour lancer la pierre
		Random rand= new Random();
		int intervalOccurence=rand.nextInt(Parc.windowSize);
		System.out.println("intervalOccurence = "+intervalOccurence);
		int randomNumber = rand.nextInt(Parc.windowSize*25);
		System.out.println("randomNumber = "+randomNumber);


		if(randomNumber<intervalOccurence) {
			System.out.println("Debut du if");
			Rock r = new Rock();
			Parc.setRock(r);
			System.out.println("Fin du if");
		}
	}
}