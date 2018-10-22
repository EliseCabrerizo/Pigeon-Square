import java.util.Timer;
import java.util.TimerTask;

public class Food {

	//Positions et indicateur sur la fraicheur et l'existence de la nourriture
	private boolean isFresh;
	private int posX; 
	private int posY;
	private boolean exist;
	
	//Constructors
	public Food(int X,int Y)
	{
		exist=true;
		isFresh=true;
		posX=X;
		posY=Y; 
		
		// Permet de faire vieillir la nourriture
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				isRotten();
			}
		};
		timer.schedule(task, 1450); 
	}

	public Food(){
	}
	
	//Getters et Setters
	public boolean isFresh()
	{
		return isFresh;
	}

	public boolean exist()
	{
		return exist;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	//Mise � false de l'existence de la nourriture mang�e
	public synchronized void isEaten(int i)
	{
		exist=false;
		System.out.println("Nourriture mang�e par le pigeon "+i);
	}

	//Mise a false de la fraicheur de la nourriture pourrie
	public void isRotten()
	{
		isFresh=false;
	}

}