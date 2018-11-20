import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
	int buttonSize = 80;
	String totalVal = "0"; // 현재까지 계산 완료한 값
	String tempVal = "0"; // 현재 입력받은 값
	
	char prevOp = ' ';
	char op = ' ';
	boolean isOpContinued = false;	// 두번 연속 사칙연산 하는지 확인하는 변수
	boolean wasLastOp = false; // 바로 직전 버튼이 연산자 버튼이었는지 확인하는 변수
	
	boolean stopwatchMod = false;
	
	// ButtonPanel 객체 생성
	ButtonPanel bPanel = new ButtonPanel();

	public Frame() {
		
		// 기본 골격 생성 
		this.setTitle("My Caclulator");
		this.setSize(4*buttonSize, 7*buttonSize-35);
		this.setBackground(Color.BLACK);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 메뉴바 만들기
		Menu menuBar = new Menu();
		setJMenuBar(menuBar);
		
		// ButtonPanel에서 만든 버튼들 addActionListener 해주기
		buttonAddActionListener(bPanel);
		add(bPanel);	
					
		// 사이즈 변경 불허하고, 화면 보이게 하기
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		boolean isButtonNumber = false;
		
		if(e.getActionCommand() == "S") {
			if(stopwatchMod == false) {
				StopWatch.initStopWatch();
				
				bPanel.resultScreen.setLabel(StopWatch.startStopWatch());
				stopwatchMod = true;
				
				return;
			}
			
			else {
				bPanel.resultScreen.setLabel(StopWatch.endStopWatch());
				
				return;
			}
		}
		
		if(stopwatchMod == true) {
			
			if(e.getActionCommand() == "C") {
				StopWatch.initStopWatch();
				stopwatchMod = false;
			}
			
			else
				return;
		}
				
		// 숫자 버튼인 경우 isButtonNumber를 true로 변경
		if(e.getActionCommand().compareTo("0") >= 0 
				&& e.getActionCommand().compareTo("9") <= 0) {
			wasLastOp = false;
			isButtonNumber = true;
		}
		
		else {
			isButtonNumber = false;
		}
		
		// 숫자 버튼일 경우, 일의 자리에 누른 숫자가 추가되게 함. 단, dot Button 을 눌렀으면 알맞은 소숫점 자리에 숫자가 추가되게 함		
		if(isButtonNumber) {
			if(tempVal != "0") {
				if(tempVal.length() > 12)
					tempVal = tempVal.substring(0, 12);
				
				tempVal = tempVal + e.getActionCommand();
			}
			else
				tempVal = e.getActionCommand();
		}
		// 연산자 버튼일 경우
		else if(e.getActionCommand() == "/" || e.getActionCommand() == "X"
				|| e.getActionCommand() == "-" || e.getActionCommand() == "+"
				|| e.getActionCommand() == "%") {
			
			prevOp = op;
			op = e.getActionCommand().charAt(0);
			
			if(wasLastOp == true)
				return;
			
			if(isOpContinued == false && totalVal.equals("0")) {
				totalVal = tempVal;
				tempVal = "0";
				isOpContinued = true;
				
				return;
			}
			
			else {
				if (totalVal == "") totalVal = "0";
				
				totalVal = Calculation.calculate(totalVal, tempVal, prevOp);
				bPanel.resultScreen.setLabel(totalVal);
				
				tempVal = "0";
				wasLastOp = true;
				
				return;
			}
		}
		else if(e.getActionCommand() == "=") {			
			if(!isOpContinued) {
				totalVal = tempVal;     
				tempVal = "0";
				
				bPanel.resultScreen.setLabel(totalVal);
				
				isOpContinued = false;
				
				return;
			}
			
			isOpContinued = false;
			
			tempVal = Calculation.calculate(totalVal, tempVal, op);
		}
		
		else if(e.getActionCommand() == "C") {
			totalVal = "0";
			tempVal = "0";
			
			StopWatch.initStopWatch();
		}
		
		else if(e.getActionCommand() == "+/-") {
			
			if (tempVal != "0") {
				if(tempVal.charAt(0) == '-')
					tempVal = tempVal.substring(1, tempVal.length());
				else
					tempVal = "-" + tempVal;
			}
			else
				tempVal = "-";
		}
		
		else if(e.getActionCommand() == ".") {
			if(!tempVal.endsWith("."))
				tempVal = tempVal + ".";
		}
		
		adjust(tempVal);
		adjust(totalVal);
		
		bPanel.resultScreen.setLabel(tempVal);
		
		System.out.println("tempVal = " + tempVal);
		System.out.println("totalVal = " + totalVal);
		System.out.println("op = " + op);
	}
	
	void buttonAddActionListener(ButtonPanel bPanel)
	{
		// ButtonPanel에서 만든 버튼들 addActionListener 해주기
		for (int i = 0; i < 9; i ++)
			bPanel.numButtons[i].addActionListener(this);
			
		for (int i = 0; i < 5; i ++)
			bPanel.opButtons[i].addActionListener(this);
				
		bPanel.zeroButton.addActionListener(this);
		bPanel.dotButton.addActionListener(this);
				
		bPanel.cButton.addActionListener(this);
		bPanel.signButton.addActionListener(this);
		bPanel.modButton.addActionListener(this);
		
		bPanel.sButton.addActionListener(this);
	}
	
	void adjust(String s)
	{
		if(s.endsWith(".0"))
			s = s.substring(0, s.length() - 2);
		
		if(s.length() > 12)
			s = s.substring(0, 12);
		
		if(s.equals("")) s = "0";
	}
}
