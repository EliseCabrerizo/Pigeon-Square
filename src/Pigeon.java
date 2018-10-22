import java.util.Random;

public class Pigeon extends Thread {

	private int posX=-1;
	private int posY=-1;
	private int numberPigeon;
	
	public int getPosX() {

		return posX;

	}
	public void setPosX(int X) {

		this.posX = X;
	}
	public int getPosY() {

		return posY;

	}
	public void setPosY(int Y) {

		this.posY = Y;

	}
	

	public Pigeon(int i)
	{
		super();
		Random rand = new Random();
		this.posX=rand.nextInt(Parc.windowSize);
		this.posY=rand.nextInt(Parc.windowSize);
		this.numberPigeon=i;
	}

	public void move(Food food){

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


	public Food findFood()
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

	public int distance(int cibleX,int cibleY)
	{
		return Math.abs(posX-cibleX)+Math.abs(posY-cibleY);
	}
	
	public void eat(Food food)
	{
		if(posX==food.getPosX()&&posY==food.getPosY())
			if(food.isFresh())
			{
				food.isEaten();
				System.out.println("Nourriture mangée par le pigeon "+numberPigeon);
			}
	}
	
	public void afraid()
	{
		Random rand= new Random();
		int intervalOccurence=rand.nextInt(Parc.windowSize);
		int randomNumber = rand.nextInt(Parc.windowSize*20);
		
		
		if(randomNumber<intervalOccurence)
		{
			this.posX=rand.nextInt(Parc.windowSize);
			this.posY=rand.nextInt(Parc.windowSize);
			System.out.println("Pigeon "+numberPigeon+" est effrayé");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void game()

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