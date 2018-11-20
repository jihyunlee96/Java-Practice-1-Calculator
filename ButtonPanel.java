import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ButtonPanel extends Panel {
	int i = 0, j = 0;
	int buttonSize = 80; // 1-9 숫자 버튼의 크기
	int buttonCount = 0; // 버튼 초기화시 사용
	int opButtonX = 3 * buttonSize; // 연산자 버튼의 x 좌표 값

	public JButton[] numButtons;
	public JButton[] opButtons;

	public JButton zeroButton;
	public JButton dotButton;
	
	public JButton cButton;
	public JButton signButton;
	public JButton modButton;
	
	public JButton sButton;
	
	public JButton resultScreen;
		
	public ButtonPanel () {
		
		String[] operators = {"/", "X", "-", "+", "="};
		
		setLayout(null);
		
		// 1-9 숫자 버튼 생성 후 추가
		numButtons = new JButton[9];
			
		for(i = 2*buttonSize; i <= 4*buttonSize; i += buttonSize) {	// i: 버튼의 y축 좌표 값
			for(j = 0; j <= 2*buttonSize; j += buttonSize) {	// j: 버튼의 x축 좌표 값
				numButtons[buttonCount] = new JButton(String.valueOf(buttonCount+1));
				numButtons[buttonCount].setBounds(j, i, buttonSize, buttonSize);
				numButtons[buttonCount].setFont(new Font("Monaco", Font.BOLD, 20));
				numButtons[buttonCount].setOpaque(true);
				numButtons[buttonCount].setBackground(Color.GRAY);
				this.add(numButtons[buttonCount]);
				buttonCount ++;
			}
		}
					
		// 0, dot 버튼 생성 후 추가
		zeroButton = new JButton("0");
		dotButton = new JButton(".");
				
		zeroButton.setBounds(0, 5 *buttonSize, buttonSize, buttonSize);
		dotButton.setBounds(buttonSize, 5*buttonSize, buttonSize, buttonSize);
		
		zeroButton.setFont(new Font("Monaco", Font.BOLD, 20));
		dotButton.setFont(new Font("Monaco", Font.BOLD, 20));
		
		zeroButton.setOpaque(true);
		dotButton.setOpaque(true);
		
		zeroButton.setBackground(Color.GRAY);
		dotButton.setBackground(Color.GRAY);
					
		this.add(zeroButton);
		this.add(dotButton);
			
		// C, sign, modulus 버튼 생성 후 추가
		cButton = new JButton("C");
		signButton = new JButton("+/-");
		modButton = new JButton("%");
			
		cButton.setBounds(0, buttonSize, buttonSize, buttonSize);
		signButton.setBounds(buttonSize, buttonSize, buttonSize, buttonSize);
		modButton.setBounds(2*buttonSize, buttonSize, buttonSize, buttonSize);
		
		cButton.setOpaque(true);
		signButton.setOpaque(true);
		modButton.setOpaque(true);
		
		cButton.setBackground(Color.GRAY);
		signButton.setBackground(Color.GRAY);
		modButton.setBackground(Color.GRAY);
		
		cButton.setForeground(Color.RED);
		signButton.setForeground(Color.RED);
		modButton.setForeground(Color.RED);
					
		this.add(cButton);	this.add(signButton);	this.add(modButton);
			
		// 연산자 버튼 생성 후 추가
		opButtons = new JButton[5];
			
		buttonCount = 0;
		for(i = buttonSize; i <= 5*buttonSize; i += buttonSize) {		// 연산자 버튼의 y 좌표 값
			opButtons[buttonCount] = new JButton(operators[buttonCount]);
			opButtons[buttonCount].setBounds(opButtonX, i, buttonSize, buttonSize);
			opButtons[buttonCount].setOpaque(true);
			opButtons[buttonCount].setBackground(Color.GRAY);
			opButtons[buttonCount].setForeground(Color.RED);
			this.add(opButtons[buttonCount]);
			buttonCount ++;
		}
		
		// 스톱워치 버튼 생성 후 추가
		sButton = new JButton("S");
		sButton.setBounds(2*buttonSize, 5*buttonSize, buttonSize, buttonSize);
		sButton.setOpaque(true);
		sButton.setBackground(Color.GRAY);
		sButton.setForeground(Color.ORANGE);
		this.add(sButton);
		
		// 결과 창 화면에 추가
		resultScreen = new JButton("0");
		resultScreen.setBounds(5, 5, 4*buttonSize-10, buttonSize-10);
		resultScreen.setFont(new Font("Monaco", Font.PLAIN, 30));
		resultScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		resultScreen.setOpaque(true);
		resultScreen.setBackground(Color.BLACK);
		add(resultScreen);
		
		this.setBackground(Color.BLACK);

	}
}