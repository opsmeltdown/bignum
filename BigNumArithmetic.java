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
		String line;
		
		//loop as long as there is another line
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			//removes extra whitespace from input line
			line = line.replaceAll("\\s+", " ").trim();
			System.out.println(line);
			
       			}	
		}	
		}  catch (IOException e){
		System.out.println("File not found.");
		}
	}		
}
