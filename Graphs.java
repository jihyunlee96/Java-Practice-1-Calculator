import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

public class Graphs extends JFrame  {
	
	public Graphs(int a, int b)
	{
		setSize(400, 400);
		setTitle("Graphs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas c = new Canvas();
		c.setSize(400, 400);
		
		add(c);
		setVisible(true);
		
		Graphics g = c.getGraphics();
		g.setColor(Color.WHITE);
		g.drawString("Hello", 200, 200);
		
	}
}
