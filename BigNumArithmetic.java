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
				if (line.length() > 0) {
					//removes extra whitespace from input line
					line = line.replaceAll("\\s+", " ").trim();
					String[] arrLine = line.split(" ");
					for (int i = 0; i < arrLine.length; i++) {
						//remove 0's from front of numbers
						String temp = arrLine[i];
						while (temp.charAt(0) == '0' && temp.length() > 1) {
							temp = temp.replaceFirst("0", "");
						}
						arrLine[i] = temp;
						if (!arrLine[i].equals("+") && !arrLine[i].equals("*") && !arrLine[i].equals("^")) {
							stack.push(arrLine[i]);
						} 
						//else if (stack.topValue()
						else {
							//pop 2 numbers and send to calculate
							stack.push(mth.calculate((String)stack.pop(), (String)stack.pop(), arrLine[i]));	
						}
					}
					for (int i = 0; i < arrLine.length; i++) {
						if (i != 0) System.out.print(" ");
						System.out.print(arrLine[i]);
					}

					System.out.println(" = " + stack.pop());
				}
			}	

		}  catch (IOException e){
			System.out.println("File not found.");
		}
	}	
}	 
