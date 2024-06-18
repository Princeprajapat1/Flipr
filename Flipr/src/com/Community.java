package com;
import java.awt.*;
import javax.swing.*;
public class Community extends JFrame{
Community(){
	
setLayout(null);
setBounds(10,10,1520,800);
setBackground(Color.gray);



	JLabel head= new JLabel("Community");
	head.setBounds(200,15,100,30);
	head.setFont(new Font("Tohima",30,Font.BOLD));
	head.setForeground(Color.blue);
	add(head);
	
	JLabel gw= new JLabel("vvvvvv");
	gw.setBounds(200,85,100,30);
	gw.setFont(new Font("Tohima",30,Font.BOLD));
	gw.setForeground(Color.blue);
	add(gw);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	getContentPane().setBackground(Color.gray);
	setVisible(true);

}


public static void main(String args[]) {
	new Community();
}
}
