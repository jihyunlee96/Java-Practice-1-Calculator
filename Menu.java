import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu extends JMenuBar implements ActionListener {	
	
	public Menu () {
		super();
		
		JMenu menu = new JMenu("More...");
		this.add(menu);
		
		JMenuItem dev = new JMenuItem("About Developer...");
		dev.addActionListener(this);
		menu.add(dev);
		
		menu.addSeparator();
		
		JMenuItem clock = new JMenuItem("Clock");
		clock.addActionListener(this);
		menu.add(clock);
		
		JMenuItem memo = new JMenuItem("Memo");
		memo.addActionListener(this);
		menu.add(memo);
		
		JMenuItem graphs = new JMenuItem("Graphs");
		graphs.addActionListener(this);
		menu.add(graphs);
		
		JMenuItem miniGame = new JMenuItem("Mini Game");
		miniGame.addActionListener(this);
		menu.add(miniGame);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "About Developer...") 
		{
			try { Desktop.getDesktop().browse(new URI("https://github.com/jihyunlee96")); }
			catch (IOException ex) { System.exit(0); }
			catch (URISyntaxException ex) { System.exit(0); }			
		}
		
		else if(e.getActionCommand() == "Clock") 
		{
			Clock.getClock();
		}
		
		else if(e.getActionCommand() == "Memo") 
		{
			Memo f = new Memo();
		}
		
		else if(e.getActionCommand() == "Mini Game") 
		{
			Game g = new Game();	
		}
		
		else if(e.getActionCommand() == "Graphs") 
		{
			String input1 = JOptionPane.showInputDialog("' y = ax + b '\n Enter the value of a.");
			int a = Integer.parseInt(input1);
			
			String input2 = JOptionPane.showInputDialog("' y = ax + b '\n Enter the value of b.");
			int b = Integer.parseInt(input2);
			
			System.out.print(a+b);
			
			Graphs gr = new Graphs(a, b);
		}
	}
}
