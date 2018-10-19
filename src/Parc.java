import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Parc extends JComponent {

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		try {
		      Image img = ImageIO.read(new File("res/background.jpg"));
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
}
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public static void main(String args[]) {
		ThreadAffichage threadAffichage=new ThreadAffichage();
		ThreadPigeon threadPigeon1 = new ThreadPigeon();
		ThreadPigeon threadPigeon2 = new ThreadPigeon();
		ThreadPigeon threadPigeon3 = new ThreadPigeon();

		threadAffichage.start();
		threadPigeon1.start();
		threadPigeon2.start();
		threadPigeon3.start();
		}
}
		