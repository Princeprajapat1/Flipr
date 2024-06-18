package com;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
	JProgressBar bar;
	Thread t;
public void run() {
		try {
			for(int i=1;i<=101;i++) {
				int max=bar.getMaximum();
				int value= bar.getValue();
				if(value<max) {
					bar.setValue(value+1);
				}else {
					setVisible(false);
				}
				Thread.sleep(25);
			}
			new Community();
		}catch(Exception e) {
			
		}
		
	}	

Loading(){
	
}
	Loading(String username){
		
		t= new Thread(this);
		
		setLayout(null);
		setBounds(500,200,650,400);
		getContentPane().setForeground(Color.white);
		
		JLabel text= new JLabel("Community");
		text.setBounds(50,20,600,40);
		text.setForeground(Color.blue);
		text.setFont(new Font("Ralway",Font.BOLD,34));
		add(text);
		
//		progressbar
		 bar= new JProgressBar();
		bar.setBounds(150,100,300,35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel bart= new JLabel("Loading,Please Wait...");
		bart.setBounds(220,140,200,30);
		bart.setForeground(Color.red);
		bart.setFont(new Font("Ralway",Font.BOLD,16));
		add(bart);
		
		
		JLabel usrnm= new JLabel("Welcome "+username+"");
		usrnm.setBounds(20,310,400,40);
		usrnm.setForeground(Color.black);
		usrnm.setFont(new Font("Ralway",Font.BOLD,16));
		add(usrnm);
		
		
		t.start();
		
		setVisible(true);
	}
	
	
	
	
	
public static void main(String args[]) {
	new Loading();
}







}
