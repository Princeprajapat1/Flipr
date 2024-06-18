package com;
import javax.swing.*;



import java.awt.event.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.*;

public class Signup extends JFrame implements ActionListener {
	JTextField nf,uf,pwdf,ansf,srtf,date ;
	JButton create,back;
	Signup(){
		setLayout(null);
		getContentPane().setForeground(Color.WHITE);
		setBounds(350,200,900,360);
//		panel
		JPanel p1= new JPanel();
		p1.setBackground(Color.gray);
		p1.setLayout(null);
		p1.setBounds(0,0,500,400);
		add(p1);
//		label
		JLabel usrnm= new JLabel("User id");
		usrnm.setFont(new Font("Tahoma",Font.BOLD,14));
		usrnm.setBounds(50,20,100,25);
		p1.add(usrnm);
		 uf = new JTextField();
		uf.setBounds(190,20,180,25);
		uf.setBorder(null);
		p1.add(uf);
		
		JLabel nm= new JLabel("Name");
		nm.setFont(new Font("Tahoma",Font.BOLD,14));
		nm.setBounds(50,60,100,25);
		p1.add(nm);
		 nf = new JTextField();
		nf.setBounds(190,60,180,25);
		nf.setBorder(null);
		p1.add(nf);
		
		
		JLabel pwd= new JLabel("Password");
		pwd.setFont(new Font("Tahoma",Font.BOLD,14));
		pwd.setBounds(50,100,100,25);
		p1.add(pwd);
		 pwdf = new JTextField();
		 pwdf.setBounds(190,100,180,25);
		pwdf.setBorder(null);
		p1.add(pwdf);
		
		JLabel srt= new JLabel("Email");
		srt.setFont(new Font("Tahoma",Font.BOLD,14));
		srt.setBounds(50,140,100,25);
		p1.add(srt);
		
		srtf=new JTextField();
			srtf.setBounds(190,140,180,25);
			
		
		p1.add(srtf);
		
		
//		button
		
		 back= new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(80,250,100,30);
		back.setBorder(null);
		back.addActionListener(this);
		p1.add(back);
		
		 create= new JButton("Create");
		create.setBackground(Color.black);
		create.setForeground(Color.white);
		create.setBounds(220,250,100,30);
		create.setBorder(null);
		create.addActionListener(this);
		p1.add(create);
	
//		Image
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupkro.png"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon i3= new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(580,40,200,200);
		add(image);
		
	

		
		
		
		setVisible(true);
	}
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==create) {
    		
    		int username=Integer.parseInt(uf.getText());
    		String name=nf.getText();
    		String pass =pwdf.getText();
    		String email=srtf.getText();
    		String password= pwdf.getText();
    		   DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    		   Date dt= new Date(getDefaultCloseOperation(), getDefaultCloseOperation(), getDefaultCloseOperation());
    	    	String date=   date_format_obj.format(dt);
    	
    	
   String query="insert into user values('"+username+"','"+name+"','"+email+"','"+password+"','"+date+"');";
    	try {
    		Conn c= new Conn();
    		c.stmt.executeUpdate(query);
    		JOptionPane.showMessageDialog(null,"Account Created Successfully !");
    	setVisible(false);
    	new Login();
    	}catch(Exception h) {
    		
    		h.printStackTrace();
    	}
    		
    		
    		
    		
    	}else if(e.getSource()==back) {
    		setVisible(false);
    		new Login();
    	}
    }

public static void main(String args[]) {
	new Signup();
}
}
