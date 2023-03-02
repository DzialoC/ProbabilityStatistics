package gameShow;

/**
 * GameShow tester to run GameShow class. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class GameShowTester {
	public static void main(String[] args) {
		GameShow curtainTime = new GameShow();
		System.out.println("No change :%"+curtainTime.gameSimulationNoChange()+"\nChange :%" + curtainTime.gameSimulationYesChange());
	}

}
