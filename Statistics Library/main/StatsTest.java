package Main;
import java.util.ArrayList;
/**
 * StatsLibrary tester class to test the multiple methods it employees. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class StatsTest {

	public static void main(String[] args) {
		
		StatsLibrary formulas = new StatsLibrary();
		
		// Odd amount of values in the set 2 modes
		ArrayList<Double> dataSet1 = new ArrayList<Double>();
		dataSet1.add(1.0);
		dataSet1.add(2.0);	
		dataSet1.add(3.0);
		dataSet1.add(4.0);
		dataSet1.add(4.0);
		dataSet1.add(6.0);
		dataSet1.add(6.0);
		dataSet1.add(7.0);
		dataSet1.add(8.0);
		dataSet1.add(9.0);
		dataSet1.add(10.0);
		
		// Even amount of values in the set 1 mode
		ArrayList<Double> dataSet2 = new ArrayList<Double>();
		dataSet2.add(1.0);
		dataSet2.add(2.0);	
		dataSet2.add(3.0);
		dataSet2.add(4.0);
		dataSet2.add(5.0);
		dataSet2.add(6.0);
		dataSet2.add(6.0);
		dataSet2.add(7.0);
		dataSet2.add(8.0);
		dataSet2.add(9.0);
		
		
		
		System.out.println("Part 1 | Median: " + formulas.median(dataSet1));
		System.out.println("Part 1 | Mode: " + formulas.mode(dataSet1));
		System.out.println("Part 1 | Mean : " + formulas.mean(dataSet1));
		System.out.println("Part 1 | StandardDeviation : " + formulas.standardDeviation(dataSet1));
		System.out.println(" ------------------------------------------- ");
		System.out.println("Part 2 | Median: " + formulas.median(dataSet2));
		System.out.println("Part 2 | Mode: " + formulas.mode(dataSet2));
		System.out.println("Part 2 | Mean : " + formulas.mean(dataSet2));
		System.out.println("Part 2 | StandardDeviation : " + formulas.standardDeviation(dataSet2));
		System.out.println(" ------------------------------------------- ");
		System.out.println("Factorial : " + formulas.factorial(19));
		System.out.println("Combination : " + formulas.combination(10, 3));
		System.out.println("Permuation : " + formulas.permutation(10, 10));
		System.out.println("pmf for Binomial Distribution : % " + formulas.binomialDistribution(.7,7,5));
		System.out.println("Geometric Distribution: % " + formulas.geometricDistribution(.50, 5));
	}

	
}
