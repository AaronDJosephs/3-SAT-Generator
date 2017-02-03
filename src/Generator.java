import java.util.Scanner;
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
	 * 2. Set all variables to true. 
	 * 3. If this solves instance, return true.
	 * 4. Set first variable to false.
	 * 5. Recurse on all variables but the first.
	 */
	public static boolean checkVerifiability(boolean[] variables, Clause[] clauses) {
		boolean solutionPossible = false;
		for (int i = 0; i < variables.length; i++) variables[i] = true;
		solutionPossible = solvable(variables, instance, clauses);
		if (solutionPossible == true) return true;
		for (int i = 0; i < variables.length; i++) {
			if (clauses.length > 1) {
				variables[0] = false;
				if (solutionPossible == true) return true;
				
			}
		}
		return solutionPossible;
	}
	
	//Reports whether or not a particular setting of variables solves the instance.  
	//This is a rather messy method and should be fine-tuned when possible.
	public static boolean solvable(boolean[] variables, String instance, Clause[] clauses) {
		String clause;
		String[] splitInstance = instance.split("/\"");
		for (int i = 0; i < splitInstance.length; i++) {
			clause = splitInstance[i];
			clause = clause.substring(1, clause.length()-1);
			Boolean var1 = null;
			Boolean var2 = null;
			Boolean var3 = null;
			char[] clauseChars = clause.toCharArray();
			for (int j = 0; j < clauseChars.length; j++) {
				if (clauseChars[j] == '!') {
					int k = j+2; //the index of the character in clauseChars corresponding to the next available variable number
					if (var1 == null) var1 = !variables[Character.getNumericValue(clauseChars[k])];
					else if (var2 == null) var2 = !variables[Character.getNumericValue(clauseChars[k])];
					else var3 = !variables[Character.getNumericValue(clauseChars[k])];
					j = j + 2;
				}
				if (clauseChars[j] == 'v') {
					int k = j+1; //the index of the character in clauseChars corresponding to the next available variable number
					if (var1 == null) var1 = !variables[Character.getNumericValue(clauseChars[k])];
					else if (var2 == null) var2 = !variables[Character.getNumericValue(clauseChars[k])];
					else var3 = !variables[Character.getNumericValue(clauseChars[k])];
				}
			}
			if (var1 == false && var2 == false && var3 == false) return false;
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
		scan.close();
		
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
		System.out.println("\n " + Boolean.toString(checkVerifiability(variables, clauses)));
	}
}
