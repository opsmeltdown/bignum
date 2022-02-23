
public class MathOperations {
	private int carry;
	LList<Integer> num1 = new LList<Integer>();
	LList<Integer> num2 = new LList<Integer>();

	public String calculate (Object a, Object b, String sign) {
		//calls appropriate method depening on sign
		//and returns what the method returns
		
		if (sign.equals('+')) return LLtoString(addition(num1,num2));
		else if (sign.equals( '*')) return LLtoString(mult(num1,num2));
		else return LLtoString(exp(num1,num2));
	}

	private LList<Integer> StringtoLL (String a) {
		LList<Integer> temp = new LList<Integer>();
		for (int i = 0; i < a.length(); i++) {
			int num = Character.getNumericValue(a.charAt(i));
			Integer x = new Integer(num);
			temp.add(x);
		}
		return temp;
	}

	private String LLtoString (LList<Integer> a) {
		//iterate thru LL and concat into string
		String answer = "";
		return answer;
	}

	private <Integer> LList<Integer> addition (LList<Integer> a, LList<Integer> b) {
		//add the 2 LinkedLists inputted and 
		//return answer list to the calculate method
		LList<Integer> answer = new LList<Integer>();
		
		//TO DO stuff here

		return answer; 
	}

	private <Integer> LList<Integer> mult (LList<Integer> a, LList<Integer> b) {
		//multiply lists and return answer list
		//will have to use add function
		LList<Integer> answer = new LList<Integer>();

		//TO DO stuff here
	
		return answer; 
	}

	private <Integer> LList<Integer> exp (LList<Integer> a, LList<Integer> b) {
		//use exponentiation by squaring which i know nothing about right now xD	
		LList<Integer> answer = new LList<Integer>();

		//TO DO stuff here

		return answer; 
	}
}
