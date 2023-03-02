package Main;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;
		
/**
 * StatsLibrary class contains mean, median, mode, standardDeviation, binomial distribution, geometric distribution
 * 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */

public class StatsLibrary {

	/**
	 * Takes an arraylist of doubles and creates 
	 * @param meanInput of an array
	 * @return a double value that is the mean
	 */
	public double mean(ArrayList<Double> meanInput) {
		double sum = 0;
		for(Double singleElement : meanInput) {
			sum = sum + singleElement;
		}
		double mean = sum / meanInput.size();
		return mean;
	}

	/**
	 * Takes ArrayList of doubles and sorts them using Collections.sort() 
	 * then using modular arithmatic we determine if it is an even or odd set
	 * i.e 17 or 16. If it is an even set we take the center position and return that value.
	 * Otherwise we take the two center values add them and divide by two to return the median.
	 * @param Arraylist of doubles is inputted
	 * @return a double is returned giving the median
	 */
	public double median(ArrayList<Double> medianInput) {
		double realMedian;
		// Sorts the arraylist from least to greatest
		Collections.sort(medianInput);
		// if the length of the list is even then we find the average of the center two values
		if(medianInput.size() % 2 == 0) {
			// gives us left center location on array
			// need to subtract 1 in order to accurately retrieve data from array list
			int centerLeft = (medianInput.size() / 2) - 1;
			// center left is the next position so we add one
			int centerRight = centerLeft + 1;
			// takes center left and center right sums them and then divides by 2 to return the realMedian
			realMedian = ((medianInput.get(centerLeft) + medianInput.get(centerRight)) / 2 ); 
		}	else {
		// else take the value of the middle list
			realMedian = medianInput.get(medianInput.size() / 2);
		}
		return realMedian;
	}
	
	/**
	 * DOES NOT RETURN THE NUMBER OF TIMES OCCURED.
	 * @param ArrayList of doubles is inputed
	 * @return Double of mode is returned. If null returned no mode or multiple of the same count.
	 */
	public Object mode(ArrayList<Double> modeInput) {
		
		boolean multipleModes = false;
		double modeHolder = 0;
		int maxCount = 1;
		// modeValue is used for returning 
		double modeValue = 0;
		
		
		for(int i = 0; i < modeInput.size(); i++) {
			// count is here to be reset after every run
			int count = 1;
			double compareValuei = modeInput.get(i);
			for(int p = 0; p < modeInput.size(); p++) {
				// if the values that we retrieve are equal and they are not being pulled from the
				// same position then add to count
				if(i != p && compareValuei == modeInput.get(p) ) {
					count++;
					modeValue = modeInput.get(i);
				}
			}
			// if statement to catch if the maxCount has increased
			// resets multiple modes to false
			if(maxCount < count) {
				maxCount = count;
				modeHolder = modeValue;
				multipleModes = false;
				
			} else if(maxCount == count && modeValue != modeHolder) {
				// if maxCount is the same as the new count and does not equal its starting value
				// then we set multiple modes to true
				multipleModes = true;
			}
		}
		if(multipleModes == true) {
			return null;
		} else {
			return modeValue;
		}
	}
	/**
	 * standardDeviation will take an ArrayList<Double> and return the population standard deviation.
	 * @param ArrayList<Double> is required input.
	 * @return will return population standard deviation. If 0 then size of ArrayList is to small.
	 */
	public double standardDeviation(ArrayList<Double> standardDeviationInputList) {
		double mean = mean(standardDeviationInputList);
		double sumOfTopEquation = 0;
		
		// if statement to catch size error 
		if(standardDeviationInputList.size() == 1) {
			return 0;
		} else {
			for(int i = 0; i < standardDeviationInputList.size(); i++) {
				// we subtract the mean from each value on the list then square 
				sumOfTopEquation += Math.pow(standardDeviationInputList.get(i) - mean, 2);
			}
			// dividing the top part of the equation by n-1 then square rooting
			double standardDeviation = Math.sqrt(sumOfTopEquation / standardDeviationInputList.size());
			return standardDeviation;
		}
	}

	// BigInteger factorial method for inputting a number you wish to 
	// be factorialized. This method is used for when the user wishes 
	// to get a return of a integer without a trail of decimals
	/**
	 * This factorial 
	 * @param integer 
	 * @return BigInteger factorial of inputed value. If null then inputed value was negative
	 */
	public BigInteger factorial(int factorialInput) {
		
		int sizeCounter = 0;
		BigInteger factorialFinal = BigInteger.valueOf(1);
		BigInteger size = BigInteger.valueOf(factorialInput);
		
		//Catch statement for value of zero being inputed
		if(factorialInput == 0 ) {
			BigInteger one = BigInteger.valueOf(1);
			return one;
		} else if (factorialInput < 0) {
		// Catch statement for negative inputed value
			return null;
		} else {
			
			while(factorialInput != sizeCounter) {
				sizeCounter++;
				size = BigInteger.valueOf(sizeCounter);
				factorialFinal = factorialFinal.multiply(size);
			}
			return factorialFinal;
		}
	}	
	
	// overloaded method for permutations and combinations
	/**
	 * Overloaded method for permutations and combinations. Its return type is an object in order to throw a null expection 
	 * for if and when a user inputs a negative number
	 * @param double factorial Inputed value
	 * @return returns the factorial final value of input
	 */
	@SuppressWarnings("null")
	public double factorial(double factorialInput) {
		double factorialFinal = 1;
		int sizeCounter = 0;
		//Catch statement for value of zero being inputed
		if(factorialInput == 0 ) {
			return factorialFinal;
		} else if (factorialInput < 0) {
		// Catch statement for negative inputed value
			return (Double) null;
		} else {
			// While loop to catch when the size counter is equal to the 
			while(factorialInput != sizeCounter) {
				sizeCounter++;
				factorialFinal = factorialFinal * sizeCounter;
			}
			return factorialFinal;
		}
	}


	/**
	 * Combination method that returns a double from two inputs. If 0 return, make sure inputs do not contain decimals 
	 * and verify that firstInput > secondInput.
	 * @param nInput = number of object to choose from. MUST BE WHOLE NUMBER
	 * @param yInput = the number of objects selected (cannot be more then nInput). MUST BE WHOLE NUMBER
	 * @return Returns a double value of the calculated combinations. 
	 */
	public double combination(double nInput, double yInput) {
		if(yInput > nInput) {
			return 0;
		} else if(yInput % 1 == 0 || nInput % 1 == 0) {
			// determines if they inputed values have decimal values
			
			// combinations formula
			double combinationOutput = (factorial(nInput) / (factorial(yInput) * factorial((nInput-yInput))));
			return combinationOutput;
		}
		// returns zero if no conditions above are met
		return 0;
	}

	/**
	 * Permutations method calculates the permutation with the two inputed values
	 * @param nInput = the set from which elements are permuted
	 * @param yInput = size of each permutation
	 * @return Returns a double value of calculated permutation
	 */
	public double permutation(double nInput, double yInput) {
		double permuationOutput = 0;
		if(nInput > 0 && yInput > 0) {
			if(yInput > nInput) {
				return 0;
			}
			permuationOutput = factorial(nInput) / factorial((nInput - yInput));
		}
		return permuationOutput;
	}
	

	/** Binomial Distribution to find the pmf
	 * 
	 * @param probabilityOfSuccess = value that is of being successful. i.e .50
	 * @param numberOfTrials =  value that is the number of runs.
	 * @param numberOfSuccess = value of successful trails ran.
	 * @return Returns double value of the calculated Binomial Distribution.
	 */
	public double binomialDistribution(double probabilityOfSuccess, double numberOfTrials, double numberOfSuccess) {
		double failureRate = 1 - probabilityOfSuccess;
//		double binomialDistributionOutput = combination(numberOfTrials, numberOfSuccess) * Math.pow(probabilityOfSuccess, numberOfSuccess) * Math.pow(failureRate,(numberOfTrials - numberOfSuccess));
		double binomialDistributionOutput = ((factorial(numberOfTrials)) / (factorial(numberOfSuccess) * factorial(numberOfTrials - numberOfSuccess) ))
				* Math.pow(probabilityOfSuccess, numberOfSuccess) * Math.pow(failureRate, numberOfTrials - numberOfSuccess);
		binomialDistributionOutput = binomialDistributionOutput * 100;
		return binomialDistributionOutput;
	}
	
	
	/**
	 * Calculates the Geometric distribution with double as inputs. probabilityOfSuccess needs to be 0 < probabilityOfSuccess <=1
	 * or -1 will be thrown
	 * @param probabilityOfSuccess = value that is of being successful. i.e .50
	 * @param numberOfFailures = value that is the number of failures.
	 * @return Returns a double of the calculated Geometric Distribution. If -1 check # of failures
	 */
	public double geometricDistribution(double probabilityOfSuccess, double numberOfFailures) {
		double failureRate = 1 - probabilityOfSuccess;
		// probability needs to be between 0 and 1 
		if( 0 < probabilityOfSuccess && probabilityOfSuccess <= 1 ) {
			double geometricDistributionOutput =Math.pow(failureRate, (numberOfFailures - 1)) * probabilityOfSuccess;
			geometricDistributionOutput = geometricDistributionOutput * 100;
			return geometricDistributionOutput;
		} else {
			return -1;
		}

	}
	
	
	
	
	
	
	
	
	
}