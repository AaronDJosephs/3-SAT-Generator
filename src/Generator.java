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
		System.out.println("\n Your m:n ratio is " + z + ".");
	}

}