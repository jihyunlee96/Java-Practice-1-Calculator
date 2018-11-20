
public class Calculation {	
	public static String calculate (String totalVal, String tempVal, char op)
	{
		double result = 0;
		String s = "";
		
		if(totalVal.equals("")) totalVal = "0";
		
		switch(op) {
			case('+'):
				result = (Double.parseDouble(totalVal) + Double.parseDouble(tempVal));
				break;
			case('-'):
				result = (Double.parseDouble(totalVal) - Double.parseDouble(tempVal));
				break;
			case('X'):
				result = (Double.parseDouble(totalVal) * Double.parseDouble(tempVal));
				break;
			case('/'):
				result = (Double.parseDouble(totalVal) / Double.parseDouble(tempVal));
				break;
			case('%'):
				result = (Double.parseDouble(totalVal) % Double.parseDouble(tempVal));
				break;
		}
		
		s = String.valueOf(result);
		System.out.print(s + " ");
	
		if(s.endsWith(".0"))
			s = s.substring(0, s.length() - 2);
		
		if(s.length() > 15)
			s = s.substring(0, 12);
			
		System.out.println(s);
		
		if(s.equals(null)) s = "0";

		
		return s;
	}
	
	public static int calculate (int totalVal, int tempVal, char op)
	{
		int result = 0;
				
		switch(op) {
			case('+'):
				result = (totalVal + tempVal);
				break;
			case('-'):
				result = (totalVal - tempVal);
				break;
			case('*'):
				result = (totalVal * tempVal);
				break;
			case('/'):
				break;
			case('%'):
				result = (totalVal % tempVal);
				break;
		}
		
		return result;
	}
}
