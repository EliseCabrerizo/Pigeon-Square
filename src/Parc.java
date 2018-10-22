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


	public static int windowSize=750;
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


	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		//Background-----------

		//try 
		//{
			//Image img = ImageIO.read(new File("res/background.jpg"));
		  //  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		//} 
		//catch (IOException e) 
		//{
		//	e.printStackTrace();

		//} 

		//Background-----------

		//Pigeon-----------		

		for(int i=0;i<pigeons.length;i++)
		{
			Image img;
			try 
			{
				img = ImageIO.read(new File("res/dove.png"));
				g.drawImage(img,pigeons[i].getPosX()-(img.getWidth(null)/2),pigeons[i].getPosY()-(img.getHeight(null)/2),60,60,null);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Pigeon-----------	

		

		//Food-----------

		if(food!=null)
		{
			for(int i=0;i<food.size();i++)
			{
				try 
				{
					if (food.get(i).isFresh()&&food.get(i).exist())
					{	
						Image img = ImageIO.read(new File("res/freshfood.png"));
						int x= food.get(i).getPosX() - img.getWidth(null)/2;
						int y= food.get(i).getPosY() - img.getHeight(null)/2;
						g.drawImage(img,x,y,null);

					}
					else if(!food.get(i).isFresh()&&food.get(i).exist())
					{
						Image img = ImageIO.read(new File("res/rottenfood.png"));
						int x= food.get(i).getPosX() - img.getWidth(null)/2;
						int y= food.get(i).getPosY() - img.getHeight(null)/2;
						g.drawImage(img,x,y,null);

					}
				}
				catch (IOException ex) 
				{
					Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);

				}
			}
		}
		//Food-----------	
	}


	public static void main(String args[]) 
	{

		Parc.food = new ArrayList<>();
		
		Pigeon pigeon1=new Pigeon(1);
		Pigeon pigeon2=new Pigeon(2);
		Pigeon pigeon3=new Pigeon(3);
		Parc.pigeons = new Pigeon[]{pigeon1,pigeon2,pigeon3};
		
		ThreadAffichage threadAffichage=new ThreadAffichage();
		
		pigeon1.start();
		pigeon2.start();
		pigeon3.start();
		threadAffichage.start();

	}
	
	
	public void createFood(int x, int y)
	{
		Food food = new Food(x,y);
		getFood().add(food);
	}
	
}
