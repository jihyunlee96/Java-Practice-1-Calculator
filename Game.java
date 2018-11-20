import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Game extends JFrame implements ActionListener {
	JTextField t;
	JLabel question;
	
	public Game()
	{
		setSize(300, 280);
		setTitle("Mini Game");
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		t = new JTextField();
		t.setLocation(0, 200);
		t.setSize(250, 50);;
		add(t);
		
		JButton bt = new JButton("CHECK!");
		bt.setFont(new Font("Monaco", Font.PLAIN, 10));
		bt.setLocation(250, 200);
		bt.setSize(50, 50);
		bt.addActionListener(this);
		add(bt);
		
		question = new JLabel(randomQuestionGenerator());
		question.setFont(new Font("Monaco", Font.BOLD, 30));
		question.setBackground(Color.WHITE);
		question.setOpaque(true);
		question.setLocation(10, 10);
		question.setSize(280, 80);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		add(question);
		
		JTextArea memo = new JTextArea();
		memo.setSize(280, 80);
		memo.setLocation(10, 110);
		memo.setText("(memo)");
		add(memo);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "CHECK!") {
			int user_ans = Integer.parseInt(t.getText());
			int ans = parseAnswer(question.getText());
			
			if(user_ans == ans) {
				JOptionPane.showMessageDialog(null, "Your answer is correct.\nCongratulations!", ":-)", 1);
				question.setText(randomQuestionGenerator());
				t.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "Your answer is wrong.\nTry again!", ":-(", 1);
				t.setText("");
			}
		}
	}
	
	public int parseAnswer(String s) {
		int ans = 0;
		
		String arr[] = s.split(" ");
		int num1 = Integer.parseInt(arr[0]);
		char op = arr[1].charAt(0);
		int num2 = Integer.parseInt(arr[2]);
		
		ans = Calculation.calculate(num1, num2, op);
		
		return ans;
	}
	
	public String randomQuestionGenerator() {
		String question = "";
		char[] ops = {'+', '-', '*', '%'};
		
		int num1 = (int) (Math.random()*100 + 1);
		int num2 = (int) (Math.random()*100 + 1);
		int opIndex = (int) (Math.random() * 4);
		char op = ops[opIndex];
		
		question = num1 + " " + op + " " + num2;
		
		return question;
	}
}
