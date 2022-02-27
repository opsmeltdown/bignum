
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
		temp.moveToStart();
		for( int i = 0; i < a.length(); i++){
			int num = Character.getNumericValue(a.charAt(i));
			Integer x = new Integer(num);
			temp.insert(x);
		}
		return temp;
	}

	private String LLtoString (LList<Integer> a) {
		//iterate thru LL and concat into string
		String answer = "";
		for(a.moveToStart(); !a.isAtEnd(); a.next()){
			answer = answer.concat(a.getValue().toString());
		}
		return answer;
	}


	private LList<Integer> addition (LList<Integer> a, LList<Integer> b) {
		//add the 2 LinkedLists inputted and 
		//return answer list to the calculate method
		LList<Integer> answer = new LList<Integer>();
		Integer carry = new Integer(0);
		Integer sum = new Integer(0);
		//find the bigger sized list and use that as for loop parameter
		//ineffiecient but itll do
		if (a.length() >= b.length()) {
			for(a.moveToStart(); !a.isAtEnd(); a.next()){
				sum = carry;
				if (!b.isAtEnd()){
					sum += b.getValue();
				}
				sum += a.getValue();
				carry = sum / 10;
				sum = sum % 10;
				answer.insert(sum);
				b.next();
			}

		} else {
			for(b.moveToStart(); !b.isAtEnd(); b.next()){
				sum = carry;
				if (!a.isAtEnd()){
					sum += a.getValue();
				}
				sum += b.getValue();
				carry = sum / 10;
				sum = sum % 10;
				answer.insert(sum);
				a.next();
			}
		}
		if (carry != 0) answer.insert(carry);
		return answer; 
	}

	private LList<Integer> mult (LList<Integer> a, LList<Integer> b) {
		//multiply lists and return answer list
		//will have to use add function
		LList<Integer> answer = new LList<Integer>();
		Integer temp = new Integer(0);

		//TO DO stuff here
		if(a.length() <= b.length()){
			LList<Integer> PR1 = new LList<Integer>();
			//first value in a times all values in b, partial result
			for(b.moveToStart(); !b.isAtEnd(); b.next()){
				temp = a.getValue() * b.getValue();
				//reverse temp if its longer than 1 digit so it works in addition function
				String str = temp.toString() , reverse = "";
				char ch;
				if (str.length() > 1) { 
					for (int i=0; i<str.length(); i++) {
						ch= str.charAt(i); 
						reverse= ch + reverse;
					}
				temp = Integer.valueOf(reverse);
				}
				PR1.append(temp);
			}
			a.next();
			LList<Integer> PR2 = new LList<Integer>();
			//second value in a times all values in b, partial result
			for(b.moveToStart(); !b.isAtEnd(); b.next()){
				temp = a.getValue() * b.getValue();
				String str = temp.toString() , reverse = "";
				char ch;
				if (str.length() > 1) {
					for (int i=0; i<str.length(); i++) {
						ch= str.charAt(i); 
						reverse= ch + reverse;
					}				
				temp = Integer.valueOf(reverse);
				}	
				PR2.append(temp);				
			}
			//combine partial results to get full result
			PR2.moveToStart();
			//PR2.insert(0);
			//PR2.insert(0);
			System.out.println(LLtoString(PR1));
			System.out.println(LLtoString(PR2));
			answer = addition(PR1, PR2);
		}


		System.out.println(LLtoString(answer));
		return answer; 
	}

	private LList<Integer> exp (LList<Integer> a, LList<Integer> b) {
		//use exponentiation by squaring which i know nothing about right now xD	
		LList<Integer> answer = new LList();

		//TO DO stuff here

		return answer; 
	}
}
