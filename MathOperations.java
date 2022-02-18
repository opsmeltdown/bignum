
public class MathOperations {
	private int carry;
	public <Integer> LList<Integer> calculate (LList<Integer> a, LList<Integer> b, Character sign) {
		//calls appropriate method depening on sign
		//and returns what the method returns
		if (sign.equals('+')) return addition(a,b);
		else if (sign.equals('*')) return mult(a,b);
		else return exp(a,b);
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
