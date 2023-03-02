package birthdayProb;

import java.util.Random;

/**
 * Person class that creates a person with a random birthday method. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class Person {
	private int birthday;
	private boolean beenCounted = false;
	Random birthdayGenerator = new Random();
	
	/**
	 * Empty person constructor
	 */
	public Person() {
	}
	/**
	 * Returns birthday of person
	 */
	public int getBirthday() {
		return birthday;
	}
	/**
	 * Creates a random birthday for said person
	 */
	public void setRandomBirthday() {
		birthday = birthdayGenerator.nextInt(1, 365);
	}
	

}
