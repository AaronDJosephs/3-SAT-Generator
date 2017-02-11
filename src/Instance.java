//defines the instance type
//Needs: a toString method


public class Instance {

	int size;
	Clause[] clauses = new Clause[size];
	Clause[] instance = new Clause[size];
	
	public Instance(Clause[] clauses) {
		
		size = clauses.length;
		
		
	}
	
}

