
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

	private LList<Integer> reverseLL (LList<Integer> a) {
		LList<Integer> reversal = new LList<Integer>();
		for (a.moveToStart(); !a.isAtEnd(); a.next()) {
			reversal.insert(a.getValue());
		}
		return reversal;
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

		Stack multstack = new AStack();
		Integer carry = new Integer(0);
		String str ="";
		int i =0;
		if(a.length() <= b.length()){
			num1 = a;
			num2 = b;
		} else {
			num1 = b;
			num2 = a;
		}
		for(num1.moveToStart(); !num1.isAtEnd(); num1.next()){
			str = "";
			for(num2.moveToStart(); !num2.isAtEnd(); num2.next()) {
				Integer num = num1.getValue() * num2.getValue();
				num += carry;
				carry = num / 10;
				num = num % 10;
				str = num.toString() + str;
			}
			int j =i;
			while(j>0){
				str = str + "0";
				j--;
			}
			if (carry != 0) str = carry.toString() + str;
			carry = 0;
			//push
			multstack.push(str);
			i++;
		}
		String topOfStack;
		String nextInStack;
		while(!multstack.isEmpty()){
			topOfStack = (String) multstack.pop();
			//just in case its multiplication by 0
			while (topOfStack.charAt(0) == '0' && topOfStack.length() > 1) {
				topOfStack = topOfStack.replaceFirst("0", "");
			}
			num1 = StringtoLL(topOfStack);
			if (!multstack.isEmpty()) {
				nextInStack = (String) multstack.pop();
			} else break;
			num1 = StringtoLL(topOfStack);
			num2 = StringtoLL(nextInStack);
			multstack.push(LLtoString(addition(num1,num2)));
		}
		return reverseLL(num1); 
	}

	private LList<Integer> exp (LList<Integer> a, LList<Integer> b) {
		//use exponentiation by squaring which i know nothing about right now xD	
		LList<Integer> answer = new LList();

		//TO DO stuff here

		return answer; 
	}
}
