import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Memo extends JFrame implements ActionListener {
	JTextArea t;
	
	public Memo ()
	{
		setSize(500, 400);
		setTitle("Memo");
		
		t = new JTextArea();
		add(t);
		
		setVisible(true);
		
		// 메뉴바 세팅
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(this);
		file.add(save);
		
		JMenuItem load = new JMenuItem("Load");
		load.addActionListener(this);
		file.add(load);
		
		this.setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Save") {
			FileDialog dialog = new FileDialog(this, "Save File", FileDialog.SAVE);
			dialog.setVisible(true);
			
			String path = dialog.getDirectory() + dialog.getFile();
			
		try { 
			FileWriter outputStream = new FileWriter(path);
			String s = t.getText();
			outputStream.write(s);
			outputStream.close();
		}
		
		catch (Exception ex) { System.exit(0); }
		}
		
		else if(e.getActionCommand() == "Load") {
			FileDialog dialog = new FileDialog(this, "Load File", FileDialog.LOAD);
			dialog.setVisible(true);
			
			String path = dialog.getDirectory() + dialog.getFile();
			
			String str = "";
			
			try {
				FileReader inputStream = new FileReader(path);
				
				int ch = 0;
				while (ch != -1) {
					ch = inputStream.read();
					str += (char)ch;
				} 
				
				str = str.substring(0, str.length()-1);
				
				inputStream.close();
			}
			catch(Exception ex) { System.exit(0); }
			
			t.setText(str);
		}
		
	}
}
