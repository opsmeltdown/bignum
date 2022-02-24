//Jon Duncan
//Nicole Grondin
//I pledge

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

public class BigNumArithmetic {
	public static void main (String args[])throws IOException{
		try {
			//setting up file input, stack, and linked list
			File input = new File(args[0]);
			Scanner scan = new Scanner(input);
			Stack stack = new AStack();
			MathOperations mth = new MathOperations();
			String line;

			//loop as long as there is another line
			while (scan.hasNextLine()) {
				line = scan.nextLine();
				//removes extra whitespace from input line
				line = line.replaceAll("\\s+", " ").trim();
				String[] arrLine = line.split(" ");
				for (int i = 0; i < arrLine.length; i++) {
					/////remove 0's from front of numbers
					String temp = arrLine[i];
					for(int j =0; j<temp.length(); j++){
						if (temp.charAt(j)==0){
							temp = temp.substring(j+1);
						}
						else break;
					}
					arrLine[i] = temp;

					if (arrLine[i].equals("=")) break;
					if (!arrLine[i].equals("+") && !arrLine[i].equals("*") && !arrLine[i].equals("^")) {
						stack.push(arrLine[i]);
					} else {
						//pop 2 numbers and send to calculate method with sign
						stack.push(mth.calculate((String)stack.pop(), (String)stack.pop(), arrLine[i]));
						
					}
				}
			System.out.println(line + " " + stack.pop());
			}	

		}  catch (IOException e){
			System.out.println("File not found.");
		}
	}	
}	
