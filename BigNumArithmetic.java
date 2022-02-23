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
			System.out.println(line);
			String[] arrLine = line.split(" ");
			for (int i = 0; i < arrLine.length; i++) {
				if (!arrLine[i].equals("+") || !arrLine[i].equals("*") ||!arrLine[i].equals("^")) {
					stack.push(arrLine[i]);
				} else {
					mth.calculate(stack.pop(), stack.pop(), arrLine[i]);
				}
			}
       		}	
			
		}  catch (IOException e){
		System.out.println("File not found.");
		}
	}	
}	
