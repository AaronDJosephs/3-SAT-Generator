//defines the instance type
//Needs: a toString method

public class Instance {

	int size;
	Clause[] clauses = new Clause[size];
	Clause[] instance = new Clause[size];
	
	public Instance(Clause[] clauses) {
		size = clauses.length;
		clauses = this.clauses;
		for (int i = 0; i < clauses.length; i++) 
		{
			for (int j = 0; j < 3; j++)
			{
				if (Generator.randomBool() == true) 
					clauses[i].setVar(j, !clauses[i].getVar(j));
			}
		}
	}	
}

