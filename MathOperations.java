
public class MathOperations {
	LList<Integer> num1 = new LList<Integer>();
	LList<Integer> num2 = new LList<Integer>();

	/**
	 * calls appropriate method depening on sign, read from input
	 * @param a first string of numbers read in from input file
	 * @param b second string of numbers read in from input file
	 * @param sign string containing sign read from input file
	 * @return the string answer returned by appropriate method
	 */
	public String calculate (String a, String b, String sign) {
		num1 = StringtoLL(a);
		num2 = StringtoLL(b);
		if (sign.equals("+")) return LLtoString(addition(num1,num2));	
		else if (sign.equals("*")) return LLtoString(mult(num1,num2));
		else return LLtoString(exp(a, num2));
	}

	/**
	 * converts a string into a linked list in reverse order
	 * @param a string to be converted
	 * @return linked list of integers
	 */
	private LList<Integer> StringtoLL (String a) {
		LList<Integer> temp = new LList<Integer>();
		//iterate thru string adding all numbers to linked list nodes
		temp.moveToStart();
		for( int i = 0; i < a.length(); i++){
			int index = Character.getNumericValue(a.charAt(i));
			Integer x = new Integer(index);
			temp.insert(x);
		}
		return temp;
	}

	/**
	 * converts a linked list to a string in the correct order
	 * @param a linked list to be converted
	 * @return string representation of the list in the correct order
	 */
	private String LLtoString (LList<Integer> a) {
		//iterate thru LL and concat into string
		String answer = "";
		for(a.moveToStart(); !a.isAtEnd(); a.next()){
			answer = answer.concat(a.getValue().toString());
		}
		return answer;
	}

	/**
	 * reverses the order of nodes in the list
	 * @param a linked list to be reversed
	 * @return reversed linked list
	 */
	private LList<Integer> reverseLL (LList<Integer> a) {
		LList<Integer> reversal = new LList<Integer>();
		for (a.moveToStart(); !a.isAtEnd(); a.next()) {
			reversal.insert(a.getValue());
		}
		return reversal;
	}

	/**
	 * reads two linked lists and adds them together one node at a time
	 * @param a first linked list
	 * @param b second linked list
	 * @return linked list of integers
	 */
	private LList<Integer> addition (LList<Integer> a, LList<Integer> b) {
		//add the 2 LinkedLists inputted and 
		//return answer list to the calculate method
		LList<Integer> answer = new LList<Integer>();
		Integer carry = new Integer(0);
		Integer sum = new Integer(0);
		//find the bigger sized list and use that as for loop parameter
		//accumulates a and b, sets carry value if needed, adds sum to answer LL each loop
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

			//same as above loop
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

		/**
	 * reads two linked lists and multiplies them together one node at a time
	 * then adds the partial results together
	 * @param a first linked list
	 * @param b second linked list
	 * @return linked list of integers
	 */
	private LList<Integer> mult(LList<Integer> a, LList<Integer>b) {
		Integer temp = new Integer(0);
		Integer carry = new Integer(0);
		String str ="";
		String superstring = "";
		int numOfZeros =0;
		//finds bigger list t set as loop parameter
		if(a.length() <= b.length()){
			num1 = a;
			num2 = b;
		} else {
			num1 = b; 
			num2 = a;
		}
		//iterates through lists, multiplying, and inserting to string of result each loop
		for(num1.moveToStart(); !num1.isAtEnd(); num1.next()){
			str = "";
			for(num2.moveToStart(); !num2.isAtEnd(); num2.next()) {
				Integer num = num1.getValue() * num2.getValue();
				num += carry;
				carry = num / 10;
				num = num % 10;
				str = num.toString() + str;
			}
			//adds appropriate number of zeros to each partial result
			int j = numOfZeros;
			while(j>0){
				 str = str + "0";
				j--;
			}
			if (carry != 0) str = carry.toString() + str;
			carry = 0;
			superstring = superstring + str + " ";
			numOfZeros++;
		}
		//splits string of products into array and adds to stack
		String[] arrMult = superstring.split(" ");
		Stack multstack = new AStack(arrMult.length);
		for (int i = 0; i < arrMult.length; i++) {
			multstack.push(arrMult[i]);
		}
		LList<Integer> product1 = new LList<Integer>();
		LList<Integer> product2 = new LList<Integer>();
		String str1;
		String str2;
		//implements stack to add partial results to get final product
		while(!multstack.isEmpty()){
			str1 = (String)multstack.pop();
			while (str1.charAt(0) == '0' && str1.length() > 1) {
				str1 = str1.replaceFirst("0", "");
			} 
			product1 = StringtoLL(str1);
			if (!multstack.isEmpty()) {
				str2 = (String)multstack.pop();
				product2 = StringtoLL(str2);
			} else break;
			multstack.push(calculate(str1,str2, "+"));
		}
		return reverseLL(product1); 
	}

	/**
	 * uses exponentiation by squaring and multiplication method
	 * @param a exponent
	 * @param b base
	 * @return linked list of answer
	 */
	private LList<Integer> exp (String a, LList<Integer> b) {
		//use exponentiation by squaring
		LList<Integer> answer = new LList<Integer>();
		int power = Integer.parseInt(a);
		answer.insert(1);
		//algorithm assumes linkedlist is not reversed, so reverse it c:
		b = reverseLL(b);
		if (power == 1) return b;
		while (power > 0) {
			if ((power % 2) == 1) {
				answer = reverseLL(StringtoLL(calculate(LLtoString(answer), LLtoString(b), "*")));
			} 
			b = reverseLL(StringtoLL(calculate(LLtoString(b), LLtoString(b), "*")));
			power = power / 2;
		}
		return answer;
	}
}
