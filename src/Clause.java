//This class is simply an array of three booleans. That way, a full 3-sat instance can be simply represented by an array of clauses.
public class Clause {
	boolean[] data = new boolean[3];
	
	public Clause(boolean first, boolean second, boolean third) {
		data[0] = first;
		data[1] = second;
		data[2] = third;
	}
}
