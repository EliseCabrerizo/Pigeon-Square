import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Rock {


	//Positions et indicateur sur l'existence de la perturbation
	private int posX; 
	private int posY;
	private boolean exist;
	
	//Constructors
	public Rock()
	{
		Random rand= new Random();
		
		exist=true;
		posX=rand.nextInt(Parc.windowSize);
		posY=rand.nextInt(Parc.windowSize); 
		
		// Permet de faire vieillir la pierre
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				disappear();
			}
		};
		timer.schedule(task, 2000); 
	}

	
	//Getters et Setters

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

	//Mise à false de l'existence de la pierre
	public synchronized void disappear()
	{
		exist=false;
	}
	
}
