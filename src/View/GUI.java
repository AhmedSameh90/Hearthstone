package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.*;

import exceptions.FullHandException;
public class GUI extends JFrame{
	private JPanel ch;
	private JPanel o;
	private JPanel field;
	private JPanel chhand;
	private JPanel ohand;
	private JButton power;
	private JButton end;
	private JPanel hand;
	private JPanel chfield;
	private JPanel ofield;
	private JPanel w;
	private JPanel r;
	public GUI() {
		
		setTitle("Hearthstone");
		setLayout(new GridLayout(3,0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ch= new JPanel();
		o = new JPanel();
		field = new JPanel();
		chhand = new JPanel();
		ohand = new JPanel();

		ch.setLayout(new BorderLayout(2,6));
		ch.setBackground(Color.DARK_GRAY);
		ch.setSize(getWidth() , getHeight()/3);
		JLabel label = new JLabel("Current Hero                Hand");
		label.setFont(new Font("Arial", Font.BOLD , 35));
		label.setForeground(Color.CYAN);
		ch.add(label , BorderLayout.BEFORE_FIRST_LINE);
		add(ch);
		
		field.setLayout(new BorderLayout(2,8));
		field.setBackground(Color.GREEN);
		label = new JLabel("Current Hero Field");
		label.setFont(new Font("Arial", Font.BOLD , 35));
		label.setForeground(Color.BLACK);
		field.add(label , BorderLayout.BEFORE_FIRST_LINE);
		field.setSize(getWidth() , getHeight()/3);
		add(field);
		
		o.setLayout(new BorderLayout(0,3));
		o.setBackground(Color.DARK_GRAY);
		label = new JLabel("Opponent          Opponent's Field");
		label.setFont(new Font("Arial", Font.BOLD , 35));
		label.setForeground(Color.CYAN);
		o.add(label , BorderLayout.BEFORE_FIRST_LINE);
		o.setSize(getWidth() , getHeight()/3);
		add(o);
		
		power = new JButton("Use Hero Power!");
		power.setSize(2, 3);
		power.setFont(new Font("Serif" , Font.ITALIC , 23));
		power.setBackground(Color.ORANGE);
		ch.add(power , BorderLayout.EAST);
		
		end = new JButton("End Turn");
		end.setFont(new Font("Serif" , Font.ITALIC , 25));
		end.setBackground(Color.RED);
		field.add(end , BorderLayout.WEST);
		
		hand = new JPanel();
		hand.setSize( 50 , ch.getHeight());
		hand.setLayout(new GridLayout(1,10));
		hand.setBackground(Color.DARK_GRAY);
		ch.add(hand , BorderLayout.CENTER);
		
		chfield = new JPanel();
		chfield.setSize(field.getWidth() ,field.getHeight()/2);
		chfield.setLayout(new GridLayout(1,7));
		chfield.setBackground(Color.WHITE);
		field.add(chfield);
		
		ofield = new JPanel();
		ofield.setSize(field.getWidth() ,field.getHeight()/2);
		ofield.setLayout(new GridLayout(1,7));
		ofield.setBackground(Color.DARK_GRAY);
		o.add(ofield , BorderLayout.CENTER);
		
		w = new JPanel();
		w.setLayout(new GridLayout(2,1));
		r = new JPanel();
		r.setLayout(new GridLayout(2,1));
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
		
	}
	public JPanel getCh() {
		return ch;
	}
	public void setPower(JButton power) {
		this.power = power;
	}
	public JPanel getO() {
		return o;
	}
	public JPanel getField() {
		return field;
	}
	public JPanel getChhand() {
		return chhand;
	}
	public JPanel getOhand() {
		return ohand;
	}
	public JButton getPower() {
		return power;
	}
	public JButton getEnd() {
		return end;
	}
	public JPanel getHand() {
		return hand;
	}
	public JPanel getChfield() {
		return chfield;
	}
	public JPanel getOfield() {
		return ofield;
	}	
	public JPanel getW() {
		return w;
	}
	public JPanel getR() {
		return r;
	}
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException {
		new GUI();
	}
}
