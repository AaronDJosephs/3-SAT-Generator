import java.util.Scanner;
import java.util.Random;
import java.math.*;

public class Generator {
	public static int m; //m is equal to the number of clauses
	public static int n; //n is equal to the number of variables
	
	public boolean randomBool() {
		double rand = Math.random();
		if (rand > 0.5) 
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many clauses do you want? ");
		m = Integer.parseInt(scan.next());
		System.out.println("\n How many variables do you want? ");
		n = Integer.parseInt(scan.next());
		float z = (float) m / (float) n;
		
		boolean[] variable = new boolean[n]; //Creates an array of booleans of length n. This represents the variables.
		//how to represent a clause??
		//in a loop of length m, randomly select 3 variables at a time to add to an array
		
		
		//for(int i = 0; i <= n-1; i++) {
		//	variable[i] = randomBool();
		//}
		
		
		System.out.println("\n Your m:n ratio is " + z + ".");
		//System.out.println("\n Your first and last variables are as follows: " + variable[0] + " " + variable[n-1]);
		System.out.println("\n The length of the variable list is: " + variable.length);
	}

}
