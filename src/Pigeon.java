import java.util.Random;

public class Pigeon {



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

	

	public Pigeon()

	{
		Random rand = new Random();
		Pigeon.posX=rand.nextInt(Parc.WIDTH);
		Pigeon.posY=rand.nextInt(Parc.HEIGHT);

		

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
				food.isEaten();
	}
	
	public static void afraid()
	{
		Random rand= new Random();
		int intervalOccurence=rand.nextInt(600);
		int randomNumber = rand.nextInt(600);
		
		if(randomNumber<intervalOccurence)
		{
			posX=rand.nextInt(Parc.WIDTH);
			posY=rand.nextInt(Parc.WIDTH);
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
		

	}

	

}