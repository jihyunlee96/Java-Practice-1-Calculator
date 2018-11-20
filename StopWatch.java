import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StopWatch {
	static String resultTime;
	static int startTime;
	static int ellapsedTime;
	static ArrayList<String> timeList = new ArrayList<String>();
	
	public static void initStopWatch() {
		// 변수 초기화
		resultTime = "";
		startTime = 0;
		ellapsedTime = 0;
		
		for(int position = 0; position < timeList.size(); position ++)
			timeList.remove(position);
	}
	
	public static String startStopWatch() {
		// 버튼을 누르면 켜지게 하고 기다리기
		stopwatch(true);		
		
		return "Stopwatch mode is on...";
	}
	
	public static String resumeStopWatch() {
		return "Resuming stopwatch...";
	}
	
	public static String endStopWatch() {
		int hour, min, sec;

		// 종료 버튼을 누르면 꺼지게 하기
		stopwatch(false);
		
		sec = ellapsedTime % 60;
		min = ellapsedTime / 60 % 60;
		hour = ellapsedTime / 3600;
		
		String result = String.format("[%d]  %02d:%02d:%02d\n", timeList.size()+1, hour, min, sec);
		timeList.add(result);
		
		String printResult = "Checkpoints!\n\n";
		for(int position = 0; position < timeList.size(); position ++)
			printResult += timeList.get(position) + "\0";
			
		JOptionPane.showMessageDialog(null, printResult, "Stopwatch", 1);
		
		return "Stopwatch mode is on...";
	}

public static void stopwatch (boolean isOn) {
	if (isOn == true) {
		startTime = (int)(System.currentTimeMillis() / 10);
		System.out.println("start: " + startTime);
	}
	
	if (isOn == false) {
		ellapsedTime = (int)(System.currentTimeMillis() / 10) - startTime;
		System.out.println("stop: " + ellapsedTime);
	}
	}	
}