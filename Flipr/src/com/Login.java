package com;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.awt.*;

public class Login extends JFrame implements ActionListener {
	JButton signup, fgtpas, login;
	JTextField uf, pf;

	Login() {
//		bydefaultlayout border
		setLayout(null);
		setBounds(380, 150, 800, 400);
		getContentPane().setBackground(Color.white);
//	to divide the frame in two panel
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(null);
		p2.setLayout(null);
		p1.setBounds(10, 10, 380, 342);
		p2.setBounds(399, 0, 400, 400);
		add(p1);
		add(p2);
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.gray);

//	image on panel1
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(120, 200, 150, 150);
		p2.add(image);

//		addlabel username 

		JLabel usrnm = new JLabel("Username");
		usrnm.setForeground(Color.black);
		usrnm.setFont(new Font("Tohima", Font.PLAIN, 20));
		usrnm.setBounds(90, 30, 100, 25);
		p1.add(usrnm);

		uf = new JTextField();
		uf.setBounds(90, 60, 200, 25);
//		u can set border of textfield
		uf.setBorder(null);
		p1.add(uf);

		JLabel pass = new JLabel("Password");
		pass.setForeground(Color.black);
		pass.setFont(new Font("Tohima", Font.PLAIN, 20));
		pass.setBounds(90, 90, 100, 25);
		p1.add(pass);

		pf = new JTextField();
		pf.setBounds(90, 120, 200, 25);
//		u can set border of textfield
		pf.setBorder(null);
		p1.add(pf);
		setVisible(true);
//	buttons	
		login = new JButton("Login");
		login.setBackground(Color.gray);
		login.setForeground(Color.white);
		login.setBounds(135, 165, 100, 30);
		login.setBorder(new LineBorder(Color.gray));
		login.addActionListener(this);
		p1.add(login);

//button

		signup = new JButton("Signup");
		signup.setBackground(Color.gray);
		signup.setForeground(Color.green);
		signup.setBounds(80, 280, 100, 30);
		signup.setBorder(new LineBorder(Color.gray));
		signup.addActionListener(this);
		p1.add(signup);

		fgtpas = new JButton("Forgot Password");
		fgtpas.setBackground(Color.gray);
		fgtpas.setForeground(Color.red);
		fgtpas.setBounds(210, 280, 100, 30);
		fgtpas.setBorder(new LineBorder(Color.gray));
		fgtpas.addActionListener(this);
		p1.add(fgtpas);

	}

	public void actionPerformed(ActionEvent e) {
		String user = uf.getText();
		String pass = pf.getText();

		if (e.getSource() == login) {
			try {

				String query = "select * from user where name='" + user + "' " + "and password='" + pass + "';";
				Conn con = new Conn();

				ResultSet rs = con.stmt.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Loading(rs.getString("name"));

				} else {
					JOptionPane.showMessageDialog(null, "data not available!");

				}

			} catch (Exception c) {
			}

		} else if (e.getSource() == signup) {
			setVisible(false);
			new Signup();
		} 

	}

	public static void main(String args[]) {
		new Login();
	}
}
