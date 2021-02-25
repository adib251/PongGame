import java.awt.*;

public class Score extends Rectangle{

	//declare attributes
	private static int GAME_WIDTH;
	private static int GAME_HEIGHT;
	private int player1Score;
	private int player2Score;
	
	
	//constructor
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}
	
	
	
	//draw the score
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		
		
		//this is to give part between the 2 players
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		
		g.drawString(String.valueOf(player1Score/10)+String.valueOf(player1Score%10), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2Score/10)+String.valueOf(player2Score%10), (GAME_WIDTH/2)+20, 50);
	}
	
	

	
	public void incrementPlayer1()
	{
		player1Score++;
	}
	
	public int getScorePlayer1()
	{
		return player1Score;
	}
	
	
	public void incrementPlayer2()
	{
		player2Score++;
	}
	
	public int getScorePlayer2()
	{
		return player2Score;
	}
}
