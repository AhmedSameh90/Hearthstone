package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import exceptions.FullHandException;

public class winner extends JFrame {
	private JPanel win;
	
	public winner() {	 
		setTitle("Congratulations");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setBounds(400, 100, 1400, 850);
		JLabel x = new JLabel(new ImageIcon("picture/Background.jpg"));
		setContentPane(x);
		x.setLayout(new FlowLayout());	
		win = new JPanel();
		win.setSize(50, 50);
		win.setBackground(Color.GREEN);
		add(win ,  BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public JPanel getWin() {
		return win;
	}
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException {
		new winner();
	}
}

