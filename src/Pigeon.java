import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Pigeon extends Thread {



	private static int posX=-1;

	private static int posY=-1;

	

	public int getPosX() {

		return posX;

	}
	public void setPosX(int posX) {

		Pigeon.posX = posX;
	}
	public int getPosY() {

		return posY;

	}
	public void setPosY(int posY) {

		Pigeon.posY = posY;

	}
	

	public Pigeon(int x, int y)
	{
		super();
		Random rand = new Random();
		//posX=rand.nextInt(Parc.windowSize);
		//posY=rand.nextInt(Parc.windowSize);
		posX=x;
		posY=y;

	}

	public void paintComponent(Graphics g) throws IOException{
		Image img = ImageIO.read(new File("res/dove.png"));
		g.drawImage(img,posX,posY,60,60,null);
    }

	public static void move(Food food){

		if(food.isFresh())
		{
			if(posX < food.getPosX())
				for(int i=posX;i<food.getPosX();i++)
					posX ++;
			else if(posX > food.getPosX())
				for(int i=posX;i>food.getPosX();i--)
					posX --;
			

			if(posY < food.getPosY())
				for(int i=posY;i<food.getPosY();i++)
					posY++;
			else if(posY > food.getPosY())
				for(int i=posY;i>food.getPosY();i--)
					posY--;
		}
		
	}


	public static Food findFood()
	{
		Food temp=new Food();
		int distanceMin = 10000000;
		for(int i=0;i<Parc.food.size();i++)
		{
			if(Parc.food.get(i).exist()&&Parc.food.get(i).isFresh())
				if(distanceMin>distance(Parc.food.get(i).getPosX(),Parc.food.get(i).getPosY()))
				{
					distanceMin=distance(Parc.food.get(i).getPosX(),Parc.food.get(i).getPosY());
					temp= Parc.food.get(i);
				}
				
		}
			return temp;
	}

	public static int distance(int cibleX,int cibleY)
	{
		return Math.abs(Pigeon.posX-cibleX)+Math.abs(Pigeon.posY-cibleY);
	}
	
	public static void eat(Food food)
	{
		if(posX==food.getPosX()&&posY==food.getPosY())
			if(food.isFresh())
			{
				food.isEaten();
				System.out.println("Nourriture mangée");
			}
	}
	
	public static void afraid()
	{
		Random rand= new Random();
		int intervalOccurence=rand.nextInt(Parc.windowSize);
		int randomNumber = rand.nextInt(Parc.windowSize*20);
		
		
		if(randomNumber<intervalOccurence)
		{
			posX=rand.nextInt(Parc.windowSize);
			posY=rand.nextInt(Parc.windowSize);
			System.out.println("Effrayé");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void game()

	{
		if(Parc.food.size()>0)
		{
			
			Food temp = findFood();
			move(temp);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eat(temp);
		}
		afraid();
		
	}

	@Override
	public void run()
	{
		while(true)
		{
			game();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}