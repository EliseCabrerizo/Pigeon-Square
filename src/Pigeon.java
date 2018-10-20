
public class Pigeon {

	private int posX=-1;
	private int posY=-1;
	
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
	
	public Pigeon(int X, int Y)
	{
		this.posX=X;
		this.posY=Y;
		
	}
	
	public void move(int cibleX, int cibleY){
		
		if(this.posX < cibleX){
			this.posX += 1;
		}else if(this.posX > cibleX){
			this.posX -= 1;
		}
		
		if(this.posY < cibleY){
			this.posY -= 1;
		}else if(this.posY > cibleY){
			this.posY += 1;
		}
		
	}
	
	
	
	public static void game()
	{
		
	}
	
}
