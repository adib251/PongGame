import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




//This is where it will contain a lot of the game components
public class GamePanel extends JPanel implements Runnable{

	private static final int GAME_WIDTH = 1000;
	private static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	private static final int BALL_DIAMETER = 20;
	private static final int PADDLE_WIDTH = 25;
	private static final int PADDLE_HEIGHT = 100;
	
	
	//Do multiple things at the same time
	private Thread gameThread;
	private Image image;
	private Graphics graphics;
	private Random random;
	
	
	//Class objects of other game components
	private Paddle paddle1;
	private Paddle paddle2;
	private Ball ball;
	private Score score;
	
	
	
	
	
	//constructor
	GamePanel(){
		//always create new paddle and new ball at the start of the game
		newPaddles();
		newBall();
		
		//need the game width and height to draw the score
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		
		//call the inner class
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		
		//this will call the run method
		gameThread.start();
	}
	
	
	
	
	
	
	
	
	
	//call the class object of BALL inside this method
	//it will locate the ball at the center but randomly select the y axis
	public void newBall() {
		random = new Random();
		//x,y, width, height
		//initialise the ball object
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	
	//call the class object of PADDLE inside this method
	//For player 1 and player 2
	public void newPaddles() {
		
		//initilaise the paddles object
		paddle1 = new Paddle(50,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle((GAME_WIDTH-PADDLE_WIDTH)-50,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	
	//***** come back to this method again ******
	//1. Dmana method ani kena panggil? 
	//Answer: It will be call on repaint()
	//2. Why do we use Image?
	public void paint(Graphics g) {
		
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		drawGameComponents(graphics);
		g.drawImage(image,0,0,this);
	}
	
	
	//To draw all the gameCompnents
	public void drawGameComponents(Graphics g) {
		paddle1.drawThePaddles(g);
		paddle2.drawThePaddles(g);
		ball.drawBall(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation

	}
	
	
	
	//this method will be call inside the run method
	public void moveGameComponents() {
		paddle1.moveUpAndDown();
		paddle2.moveUpAndDown();
		ball.moveBall();
	}
	
	
	
	
	
	
	
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		//give a player 1 point and creates new paddles & ball
		if(ball.x <=0) {
			score.incrementPlayer2();;
			newPaddles();
			newBall();
			System.out.println("Player 2: "+score.getScorePlayer2());
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.incrementPlayer1();;
			newPaddles();
			newBall();
			System.out.println("Player 1: "+score.getScorePlayer1());
		}
	}
	
	
	//since extends runnable, this method need to be overwrite
	//this run method will be call whenever thread is start
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		
		
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				moveGameComponents();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	
	
	
	
	//INNER CLASS
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
