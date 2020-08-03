package View;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import exceptions.FullHandException;

public class menu extends JFrame {

	public menu() {	 
		setTitle("Select your Heroes");
		setLayout(new GridLayout(0,3));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setBounds(400, 100, 1400, 850);
		JLabel x = new JLabel(new ImageIcon("picture/Background.jpg"));
		setContentPane(x);
		x.setLayout(new FlowLayout());		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public static void main(String[] args) throws FullHandException, CloneNotSupportedException {
		new menu();
	}
}
