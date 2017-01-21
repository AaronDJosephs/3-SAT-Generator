import java.util.Scanner;
import java.math.*;
import java.util.Random;



public class Generator {
	public static int m; //m is equal to the number of clauses
	public static int n; //n is equal to the number of variables
	public static String instance = ""; //instance keeps track of the fully generated instance
	
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
		if (randomBool()==true) {
			instance = instance + "v" + rndm;
			return array[rndm];
		}
		else {
			instance = instance + "!v" + rndm;
			return !array[rndm];
		}
	}
	
		//This function determines whether an instance is satisfiable.
	//Though inefficient, this code just runs through all the possibilities. 
	/*
	 * What does it mean to check every possibility? 
	 * Take an instance, and a list of variables, and try every combination of variables until one works. 
	 * If none are successful, it is not satisfiable. 
	 * 1. Input: an instance, a variable list. 
	 *    Output: a boolean. If true, the instance is satisfiable. If false, the instance is not satisfiable.
	 * 2. 
	 */
	public static boolean checkVerifiability(boolean[] variables, Clause[] clauses) {
		for (int i = 0; i < variables.length; i++) {
			variables[i] = true;
		}
		return solvable(variables, instance, clauses);
	}
	
	//Reports whether or not a particular setting of variables solves the instance.  
	public static boolean solvable(boolean[] variables, String instance, Clause[] clauses) {
		String clause;
		String[] splitInstance = instance.split("/\"");
		for (int i = 0; i < splitInstance.length; i++) {
			clause = splitInstance[i];
			clause = clause.substring(1, clause.length()-1);
			Clause currentClause = new Clause(true, true, true);
			boolean var1;
			char[] clauseChars = clause.toCharArray();
			for (char c : clauseChars) {
				if (c == '!') {
					
				}
			}
		}
		return true;
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
			instance = instance + "(";
			boolean one = randomElement(variables);
			instance = instance + "\\/";
			boolean two = randomElement(variables);
			instance = instance + "\\/";
			boolean three = randomElement(variables);
			instance = instance + ")/\\";
			clauses[i] = new Clause(one, two, three);
		}
		instance = instance + ")";
		System.out.println(Boolean.toString(variables[1]));
		//prints out instance, deletes final " or"
		System.out.println(instance.substring(0, instance.length()-3));
		System.out.println("\n Your m:n ratio is " + z + ".");
		System.out.println("\n The length of the variable list is: " + variables.length);
	}

}
