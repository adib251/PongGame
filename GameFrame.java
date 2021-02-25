//Create the frame of the game



import java.awt.*;
import javax.swing.*;



//Inheritance
public class GameFrame extends JFrame{

	
	//Class object of game panel
	//declare
	GamePanel panel;
	
	
	//constructor
	GameFrame()
	{
		//initialise
		panel = new GamePanel();
		this.add(panel);
		
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//relize you dont punt setSize 
		//this will make all the components fit in inside the frame dynamically
		//it will adjust accordingly
		this.pack();
		
		
		this.setVisible(true);
		
		//The window will appear at the center of the screen
		this.setLocationRelativeTo(null);
	}
}
