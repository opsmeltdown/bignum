
public class MathOperations {
	LList<Integer> num1 = new LList<Integer>();
	LList<Integer> num2 = new LList<Integer>();

	public String calculate (String a, String b, String sign) {
		//calls appropriate method depening on sign
		//and returns what the method returns
		num1 = StringtoLL(a);
		num2 = StringtoLL(b);
		if (sign.equals("+")) return LLtoString(addition(num1,num2));
		else if (sign.equals("*")) return LLtoString(mult(num1,num2));
		else return LLtoString(exp(num1,num2));
	}

	private LList<Integer> StringtoLL (String a) {
		LList<Integer> temp = new LList<Integer>();
		//iterate thru string adding all numbers to linked list nodes
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
		for (int i = 0; i < a.size(); i++) {
			answer = a.get(i).toString().concat(answer);
		}
		return answer;
	}

	private LList<Integer> addition (LList<Integer> a, LList<Integer> b) {
		//add the 2 LinkedLists inputted and 
		//return answer list to the calculate method
		LList<Integer> answer = new LList<Integer>();
		int carry = 0;
		int sum = 0;
		//somethings wrong here idk its 4:30am goodnight
/*		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); i++) {
				sum = carry;
				sum += a.get(i) + b.get(j);
				carry = sum / 10;
				sum = sum % 10;
				answer.add(sum);
			}
		}		
*/
		return a; 
	}

	private LList<Integer> mult (LList<Integer> a, LList<Integer> b) {
		//multiply lists and return answer list
		//will have to use add function
		LList<Integer> answer = new LList<Integer>();

		//TO DO stuff here
	
		return answer; 
	}

	private LList<Integer> exp (LList<Integer> a, LList<Integer> b) {
		//use exponentiation by squaring which i know nothing about right now xD	
		LList<Integer> answer = new LList<Integer>();

		//TO DO stuff here

		return answer; 
	}
}
