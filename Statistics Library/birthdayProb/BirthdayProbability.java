package birthdayProb;
import java.util.ArrayList;

import Main.StatsLibrary;

/**
 * Birthday probability class that determines the likely hood of classmates having the same birthday over 
 * a specified amount of runs
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class BirthdayProbability {

	/**
	 * 
	 * @param numberOfClassmatesInput 
	 * @param numberOfRunsInput
	 * @return 
	 */
	public double sharingBirthdayProbability(double numberOfClassmatesInput, double numberOfRunsInput) {
		double sameBirthdayCount = 0;
		double totalProbability = 0;
		ArrayList<Person> peopleOfTheClass = new ArrayList<Person>();
		
		for(int i = 0; i < numberOfRunsInput; i++) {
			
			peopleOfTheClass.clear();
			// creates a random set of classmates with random birthdays
			for(int classmateID = 0; classmateID < numberOfClassmatesInput; classmateID++) {
				Person nonBinary = new Person();
				nonBinary.setRandomBirthday();
				peopleOfTheClass.add(nonBinary);
			}

			boolean sameBirthdayBoolean = false;
			// will check all classmates for same birthday once one is found the check stops and the list is reset
			if(sameBirthdayBoolean == false) {
				for(int j = 0; j < peopleOfTheClass.size(); j++) {
					for(int p = 0; p < peopleOfTheClass.size(); p++) {
						int personA = peopleOfTheClass.get(j).getBirthday();
						int personB = peopleOfTheClass.get(p).getBirthday();
						if(personA == personB && j !=p ) {
							sameBirthdayCount++;
							sameBirthdayBoolean = true;
							break;
						}
					}
				}
			}
		}
		totalProbability = sameBirthdayCount / numberOfRunsInput;
		return totalProbability;
	}

	
}
