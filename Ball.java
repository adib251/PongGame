 import java.awt.*;
import java.util.*;



//This game will only have one ball
//What the ball can do?
//1. Ball can move updown - y direction && leftright - x direction
//Condition: Only if it hits the paddle


public class Ball extends Rectangle{

	
	//Declare attributes
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	Ball(int x, int y, int width, int height){
		//from rectangle
		super(x,y,width,height);
		
		random = new Random();
		
		//if x==0 , x=-1 then go left
		//need to change to -1 bc if 0, we cant multiply
		//-2 *2 = -4
		
		//if x==1, go right
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		
		//if x==0, x=-1 then go up		
		//if x==1 go down
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);
		
	}
	
	
	//Internal method
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	
	//Internal method
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	

	public void moveBall() {
		
		//30 +(-7) = 23
		x += xVelocity;
		y += yVelocity;
	}
	
	
	public void drawBall(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}

