import java.awt.Graphics;

import java.awt.Image;
import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.logging.Level;

import java.util.logging.Logger;



import javax.imageio.ImageIO;

import javax.swing.JComponent;



@SuppressWarnings("serial")

	public class Parc extends JComponent{



	public static Pigeon[] pigeons;

	public static ArrayList<Food> food;

	public static Pigeon[] getPigeons() {

		return pigeons;

	}
	public static void setPigeons(Pigeon[] pigeons) {

		Parc.pigeons = pigeons;

	}
	public static ArrayList<Food> getFood() {

		return food;

	}
	public static void setFood(ArrayList<Food> food) {

		Parc.food = food;

	}


	public void paintComponent(Graphics g) {



		super.paintComponent(g);

		

		//Background-----------

		try {

		      Image img = ImageIO.read(new File("res/background.jpg"));

		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		    } catch (IOException e) {

		      e.printStackTrace();

		    } 

		//Background-----------

		

		

		//Pigeon-----------		

		for(int i=0;i<pigeons.length;i++){

			try {

				if (pigeons[i].getPosX()!=-1 &&pigeons[i].getPosY()!=-1){

					Image img = ImageIO.read(new File("res/dove.png"));

					g.drawImage(img,pigeons[i].getPosX(),pigeons[i].getPosY(),60,60,null);

				}

			} catch (IOException ex) {

					Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);

			}

		}

		//Pigeon-----------	

		

		//Food-----------

		if(food!=null){

			

			for(int i=0;i<food.size();i++){

				

				try {

					if (food.get(i).isFresh()&&food.get(i).exist()){	

						Image img = ImageIO.read(new File("res/freshfood.png"));

						int x= food.get(i).getPosX() - img.getWidth(null)/2;

						int y= food.get(i).getPosY() - img.getHeight(null);

						g.drawImage(img,x,y,null);

					}else if(!food.get(i).isFresh()&&food.get(i).exist())
					{

						Image img = ImageIO.read(new File("res/rottenfood.png"));

						int x= food.get(i).getPosX() - img.getWidth(null)/2;

						int y= food.get(i).getPosY() - img.getHeight(null);

						g.drawImage(img,x,y,null);

					}

				} catch (IOException ex) {

					Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);

				}

			}

		}

		//Food-----------	

	}





	
	public static void main(String args[]) {

		
		Pigeon pigeon1=new Pigeon();

		Pigeon pigeon2=new Pigeon();

		Pigeon pigeon3=new Pigeon();

		Parc.pigeons = new Pigeon[]{pigeon1,pigeon2,pigeon3};

		Parc.food = new ArrayList<>();

		ThreadAffichage threadAffichage=new ThreadAffichage();

		ThreadPigeon threadPigeon1 = new ThreadPigeon();

		ThreadPigeon threadPigeon2 = new ThreadPigeon();

		ThreadPigeon threadPigeon3 = new ThreadPigeon();



		threadAffichage.start();

		threadPigeon1.start();

		threadPigeon2.start();

		threadPigeon3.start();

		

		}

	

	

	public void createFood(int x, int y){

		Food food = new Food(x,y);

		getFood().add(food);

	}

	
	

	

	

}