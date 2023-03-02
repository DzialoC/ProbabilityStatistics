package setOperations;
import java.util.ArrayList;

/**
 * Set operations does set logic on strings. This class contains the following methods
 * union, compliment, intersection.
 * 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */

public class SetOperations {
	
	/**
	 * Union set method for strings.
	 * @param inputA = ArrayList of strings
	 * @param inputB = ArrayList of strings
	 * @return returns the union of the sets
	 */
	public ArrayList<String> union(ArrayList<String> inputA, ArrayList<String> inputB) {
		ArrayList<String> outputC = new ArrayList<String>();
		// sets outputC equal to inputA
		for(int counter = 0; counter < inputA.size(); counter++) {
			outputC.add(inputA.get(counter));
		}
		for(int i = 0; i < inputB.size(); i++) {
			if(!outputC.contains(inputB.get(i))) {
				outputC.add(inputB.get(i));
			}
		}
		return outputC;	
	}

	/**
	 * Compliment set method for strings. Larger set goes into inputA 
	 * @param inputA = Larger set of strings (.size()) ArrayList of strings
	 * @param inputB = ArrayList of strings
	 * @return returns the compliment of the sets
	 */
	public ArrayList<String> compliment(ArrayList<String> inputA, ArrayList<String> inputB) {
		ArrayList<String> outputC = new ArrayList<String>();
		// sets outputC equal to inputA
		for(int counter = 0; counter < inputA.size(); counter++) {
			outputC.add(inputA.get(counter));
		}
			for(int i = 0; i < inputB.size(); i++) {
					if(outputC.contains(inputB.get(i))) {
						outputC.remove(inputB.get(i));
				}
			}
		return outputC;
	}

	/**
	 * Intersection set method for strings.
	 * @param inputA = ArrayList of strings
	 * @param inputB = ArrayList of strings
	 * @return returns the intersection of the sets
	 */
	public ArrayList<String> intersection(ArrayList<String> inputA, ArrayList<String> inputB) {
		ArrayList<String> outputC = new ArrayList<String>();
		for(int i = 0; i < inputA.size(); i++) {
			for(int p = 0; p < inputB.size(); p++) {
				if(inputA.get(i) == inputB.get(p)) {
					outputC.add(inputB.get(p));
				}
			}
		}
		return outputC;
	}
}	