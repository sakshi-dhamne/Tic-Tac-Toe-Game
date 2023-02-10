package Game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tic_Tac_Toe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	JPanel rpanel = new JPanel();
	JButton resButton = new JButton();
	
	Tic_Tac_Toe()
	{
		//-----------------FRAMES-----------------------------
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.gray);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//-----------------TEXTFIELD--------------------------
		textfield.setBackground(Color.DARK_GRAY);
		textfield.setForeground(Color.MAGENTA);
		textfield.setFont(new Font("Lucida Calligraphy", Font.BOLD ,80));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		//---------------------TITLE-PANEL-------------------
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		//------------------BUTTON-PANEL-------------------
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color (150,150,150));
		button_panel.setForeground(Color.white);
		
		for(int i=0;i<9;i++)
		{
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 90));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		
		//continue title_panel
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		
		frame.add(button_panel);
		
		firstTurn();
		
		//--------RESET BUTTON--------------
		rpanel.setLayout(new BorderLayout());
		resButton.setText("Reset the game!");
		resButton.setFont(new Font("Fira Code", Font.ITALIC , 30));
		resButton.setSize(100,50);
		resButton.setFocusable(false);
		resButton.addActionListener(this);
		
		resButton.setBackground(Color.RED);
		title_panel.add(textfield);
		     rpanel.add(resButton);
		     frame.add(title_panel,BorderLayout.NORTH);
		     frame.add(button_panel,BorderLayout.CENTER);
		     frame.add(rpanel,BorderLayout.SOUTH);
		     frame.setLocationRelativeTo(null);
		     
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
	   	for(int i=0;i<9;i++)
	   	{
	   		if(e.getSource()==buttons[i])
	   		{
	   			if(player1_turn){
	   				if(buttons[i].getText()==""){
	   					buttons[i].setForeground(new Color (255,0,0));
	   					buttons[i].setText("X");
	   					player1_turn=false;
	   					textfield.setText("O Turn");
	   					check();
	   				}
	   			}
	   		
	   			else {
	   				        buttons[i].setForeground(new Color (0,255,0));
		   					buttons[i].setText("O");
		   					player1_turn=true;
		   					textfield.setText("X Turn");
		   					check();
	   			  }
	   		  }
	   	  }
	   	if(e.getSource()==resButton){
	   		frame.remove(button_panel);
	   		button_panel = new JPanel();
	   		button_panel.setLayout(new BorderLayout());
	   		button_panel.setLayout(new GridLayout(3,3));
	   		button_panel.setBackground(new Color(38,38,38));
	   		frame.add(button_panel,BorderLayout.CENTER);
	   		
	   		for(int i = 0; i<9; i++){
	   			buttons[i]=new JButton();
	   			button_panel.add(buttons[i]);
	   			buttons[i].setFont(new Font("MV Boli",Font.BOLD, 90));
	   			buttons[i].setFocusable(false);
	   			buttons[i].addActionListener(this);
	   		}
	   		if(random.nextInt(2)==0){
	   			//int is 2 for two players
	   			player1_turn = true;
	   			textfield.setText("X Turn");
	   		}
	   		else{
	   			player1_turn = false;
	   			textfield.setText("O turn");
	   		}
	   		
	   		SwingUtilities.updateComponentTreeUI(frame);
	   	}
	  }
     		
	public void firstTurn()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0)
		{
			player1_turn = true;
			textfield.setText("X Turn");
		}
		else
		{
			player1_turn = false;
			textfield.setText("O Turn");
		}
			
	}
	public void check(){
		
			// code for tie condition
			int i = 0;
			while(buttons[i].getText() != "")
			{
				if(i==buttons.length-1){
					draw();
					break;
				}
				i++;
			}
		//check x win condition
		if(     (buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
		  ){
			xWins(0,1,2);
		}
		if(      (buttons[3].getText()=="X")&&
				 (buttons[4].getText()=="X")&&
				 (buttons[5].getText()=="X")
		   ){
			xWins(3,4,5);
		}
		if(      (buttons[6].getText()=="X")&&
				 (buttons[7].getText()=="X")&&
				 (buttons[8].getText()=="X")
		   ){
			xWins(6,7,8);
		}
		if(      (buttons[0].getText()=="X")&&
				 (buttons[3].getText()=="X")&&
				 (buttons[6].getText()=="X")
		   ){
			xWins(0,3,6);
		}
		if(      (buttons[1].getText()=="X")&&
				 (buttons[4].getText()=="X")&&
				 (buttons[7].getText()=="X")
		   ){
			xWins(1,4,7);
		}
		if(      (buttons[2].getText()=="X")&&
				 (buttons[5].getText()=="X")&&
				 (buttons[8].getText()=="X")
		   ){
			xWins(2,5,8);
		}
		if(      (buttons[0].getText()=="X")&&
				 (buttons[4].getText()=="X")&&
				 (buttons[8].getText()=="X")
		   ){
			xWins(0,4,8);
		}
		if(      (buttons[2].getText()=="X")&&
				 (buttons[4].getText()=="X")&&
				 (buttons[6].getText()=="X")
		   ){
			xWins(2,4,6);
		}
		
		//check y win condition
		if(     (buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")
		  ){
			oWins(0,1,2);
		}
		if(      (buttons[3].getText()=="O")&&
				 (buttons[4].getText()=="O")&&
				 (buttons[5].getText()=="O")
		   ){
			oWins(3,4,5);
		}
		if(      (buttons[6].getText()=="O")&&
				 (buttons[7].getText()=="O")&&
				 (buttons[8].getText()=="O")
		   ){
			oWins(6,7,8);
		}
		if(      (buttons[0].getText()=="O")&&
				 (buttons[3].getText()=="O")&&
				 (buttons[6].getText()=="O")
		   ){
			oWins(0,3,6);
		}
		if(      (buttons[1].getText()=="O")&&
				 (buttons[4].getText()=="O")&&
				 (buttons[7].getText()=="O")
		   ){
			oWins(1,4,7);
		}
		if(      (buttons[2].getText()=="O")&&
				 (buttons[5].getText()=="O")&&
				 (buttons[8].getText()=="O")
		   ){
			oWins(2,5,8);
		}
		if(      (buttons[0].getText()=="O")&&
				 (buttons[4].getText()=="O")&&
				 (buttons[8].getText()=="O")
		   ){
			oWins(0,4,8);
		}
		if(      (buttons[2].getText()=="O")&&
				 (buttons[4].getText()=="O")&&
				 (buttons[6].getText()=="O")
		   ){
			oWins(2,4,6);
		}
		
		}
	public void xWins(int a, int b, int c){
		 buttons[a].setBackground(Color.GREEN);
		 buttons[b].setBackground(Color.GREEN);
		 buttons[c].setBackground(Color.GREEN);
		 
		 for(int i=0;i<9;i++){
			 buttons[i].setEnabled(false);
		 }
		 textfield.setText("X wins!!");
	}
    public void oWins(int a, int b, int c){
    	 buttons[a].setBackground(Color.GREEN);
		 buttons[b].setBackground(Color.GREEN);
		 buttons[c].setBackground(Color.GREEN);
		 
		 for(int i=0;i<9;i++){
			 buttons[i].setEnabled(false);
		 }
		 textfield.setText("O wins!!");
	}

    public void draw(){
    	for(int i=0; i<buttons.length; i++){
    		buttons[i].setEnabled(false);
    	}
    	textfield.setText("Game Draw!");
    	textfield.setHorizontalAlignment(JLabel.CENTER);
    }
}
