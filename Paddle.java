import java.awt.*;
import java.awt.event.*;


//In this game we will have 2 paddles
//Player 1 and Player 2
//What paddle can do?
//1.Move up and down 	-- y direction
// HOW? by pressing a specific keys



//WHY WE EXTEND RECTANGLE??
public class Paddle extends Rectangle{

	
	
	//Declare attributes
	private int id;
	private int yVelocity;
	private int speed = 10;
	
	
	
	//constructor
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id)
	{
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id=id;
	}
	
	
	
	
	//This can be name anything
	public void keyPressed(KeyEvent e) {
		switch(id) {
		
		//PLAYER 1
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}
			break;
			
			
		//PLAYER 2
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}
			break;
		}
	}
	
	
	
	//Once you released the key, you want the paddles to stop moving
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}
	
	
	
	
	//Why do we need to set on method, insted of the construcrtor
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	
	
	
	public void moveUpAndDown() {
		y= y + yVelocity;
	}
	
	
	
	public void drawThePaddles(Graphics g) {
		if(id==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
