import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Square {

	public static void main(String[] args) {
		int width = 600;
		int height = 600;
		JFrame window = createWindow(width,height);
		window.setVisible(true);

	}
	
	public static JFrame createWindow(int width, int height){
		//Creation de la fenetre---------------------------
		JFrame window = new JFrame("Pigeon Square");
		window.setResizable(false);
		window.setSize(width,height);
		window.setLocationRelativeTo(null);
		
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Image img = null;
		try {
			img = ImageIO.read(new File("res/background.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel pane = new JPanel(){
			  public void paintComponent(Graphics g){
				    try {
				      Image img = ImageIO.read(new File("res/background.jpg"));
				      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				    } catch (IOException e) {
				      e.printStackTrace();
				    }                
				  }               
				};
			pane.setBackground(Color.blue);
		
		window.setContentPane(pane);
		return window;
		//-------------------------	
	}
	
}
