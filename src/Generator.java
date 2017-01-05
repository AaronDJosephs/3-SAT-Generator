import java.util.Scanner;
import java.math.*;
import java.util.Random;

public class Generator {
	public static int m; //m is equal to the number of clauses
	public static int n; //n is equal to the number of variables
	
	//This function generates a random boolean
	public static boolean randomBool() { 
		double rand = Math.random();
		if (rand < 0.5) 
			return true;
		else return false;
	}
	
	//This function selects a random element from a boolean array
	public static boolean randomElement(boolean[] array) {
		int rndm = new Random().nextInt(array.length);
		return array[rndm];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many clauses do you want? ");
		m = Integer.parseInt(scan.next());
		System.out.println("\n How many variables do you want? ");
		n = Integer.parseInt(scan.next());
		float z = (float) m / (float) n;
		
		boolean[] variables = new boolean[n]; //Creates an array of booleans of length n. This represents the variables.
		Clause[] clauses = new Clause[m]; //Creates an array of clauses of length m. Each clause consists of 3 variables.

		//in a loop of length m, randomly select 3 variables at a time to add to an array
		for(int i = 0; i <= m-1; i++) {
			
		}
		
		//for(int i = 0; i <= n-1; i++) {
		//	variable[i] = randomBool();
		//}
		
		
		System.out.println("\n Your m:n ratio is " + z + ".");
		//System.out.println("\n Your first and last variables are as follows: " + variable[0] + " " + variable[n-1]);
		System.out.println("\n The length of the variable list is: " + variables.length);
	}

}
