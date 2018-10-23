import java.util.Random;

public class Pigeon extends Thread {

	//Position du pigeon dans le parc
	private int posX=-1;
	private int posY=-1;
	
	//Numero du pigeon
	private int numberPigeon;
	
	//Getters et Setters
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

	//Constructor
	public Pigeon(int i)
	{
		super();
		Random rand = new Random();
		this.posX=rand.nextInt(Parc.windowSize);
		this.posY=rand.nextInt(Parc.windowSize);
		this.numberPigeon=i;
	}

	//Bouge le pigeon en direction d'une nourriture fraîche
	public void move(Food food)
	{
		//Si la nourriture est fraiche
		if(food.exist() && food.isFresh())
		{
			//Bouge vers la droite
			if(posX < food.getPosX())
				for(int i=posX;i<food.getPosX()&&food.exist()&&food.isFresh();i++)
					{
					posX ++;
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			//Bouge vers la gauche
			else if(posX > food.getPosX())
				for(int i=posX;i>food.getPosX()&&food.exist()&&food.isFresh();i--)
					{
					posX --;
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			//Bouge vers le bas
			if(posY < food.getPosY())
				for(int i=posY;i<food.getPosY()&&food.exist()&&food.isFresh();i++)
					{
					posY++;
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			//Bouge vers le haut
			else if(posY > food.getPosY())
				for(int i=posY;i>food.getPosY()&&food.exist()&&food.isFresh();i--)
					{
					posY--;
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
	}

	//Trouve la nourriture fraîche la plus proche
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

	//Calcule la distance
	public int distance(int cibleX,int cibleY)
	{
		return Math.abs(posX-cibleX)+Math.abs(posY-cibleY);
	}
	
	//Manger la nourriture
	public void eat(Food food)
	{
		synchronized(this)
		{
			if(posX==food.getPosX()&&posY==food.getPosY())
				if(food.isFresh()&&food.exist())
					food.isEaten(numberPigeon);
		}
		
	}
	
	//Perturbation pour les pigeons
	public void afraid()
	{
		//Occurence aléatoire
		/*Random rand= new Random();
		int intervalOccurence=rand.nextInt(Parc.windowSize);
		int randomNumber = rand.nextInt(Parc.windowSize*25);
		
		if(randomNumber<intervalOccurence)
		{
			//Eloigne le pigeon
			this.posX=rand.nextInt(Parc.windowSize);
			this.posY=rand.nextInt(Parc.windowSize);
			System.out.println("Pigeon "+numberPigeon+" est effrayé");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

	//Comportement du pigeon
	public void game()
	{
		if(Parc.food.size()>0)
		{
			Food temp = findFood();
			move(temp);
			eat(temp);
		}
		afraid();
	}

	//Boucle de simulation du pigeon
	public void run()
	{
		while(true)
		{
			game();
			try 
			{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}