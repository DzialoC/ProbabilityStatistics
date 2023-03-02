package gameShow;
import java.util.ArrayList;
import java.util.Random;

/**
 * GameShow class proves through random number generation the Monte Carlo method. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class GameShow {
	
	/**
	 * Monte Carlo simulation to show that not changing your choice leaves you with roughly 33% 
	 * @return Percentage of games won
	 */
	public double gameSimulationNoChange() {
		
		double percentWon, gamesWon = 0;
		Random random = new Random();
		ArrayList<Boolean> curtains = new ArrayList<Boolean>();
		
		for(int i = 0; i < 10000; i++) {
			curtains.clear();
			curtains.add(false);
			curtains.add(false);
			curtains.add(false);
			int prize = random.nextInt(3);
			curtains.set(prize, true);
			int choice = random.nextInt(3);
			
			if(curtains.get(choice) == true) {
				gamesWon++;
			}
		}
		percentWon = gamesWon / 10000;
		percentWon = percentWon * 100;
		return percentWon;
	}
	
	
	/**  over 10,000 total games, a game consists of three choices. one choice is correct. the participant chooses one of the three. One fake choice is removed.
	 * leaving the participant with two choices. his choice and the remaining curtain. In this simulation the participant always chooses the other curtain.
	 * @return Percentage of winning when changing choice.
	 */
	public double gameSimulationYesChange() {
		
		// total games played - larger the total the more accurate the simulation
		int totalGames = 10000;
		double gamesWon = 0;
		Random random = new Random();

		
		// for loop for total games
		for (int gamePlayed = 0; gamePlayed < totalGames; gamePlayed++) {
			
			// Initialze and add all curtains to arraylist
			int prizeIndex = random.nextInt(3);
			ArrayList<Curtain> curtains = new ArrayList<Curtain>();
			for (int p = 0; p <= 2; p++) {
				boolean setPrize = false;
				if(prizeIndex == p) {
					setPrize = true;
				}
				Curtain c = new Curtain(setPrize);
				curtains.add(c);
			}
			
			// Player first choice
			int playerChoice = random.nextInt(3);
			int openedIndex = -1;
			// Open known curtain without prize
			
			for (int z = 0; z < curtains.size(); z++) {
				if (z != playerChoice && !curtains.get(z).checkCurtain()) {
					curtains.get(z).setOpened();
					openedIndex = z;
					break;
				}
			}
			
			for (int x = 0; x < curtains.size(); x++) {
				if (x != playerChoice && x != openedIndex) {
					boolean hasPrize = curtains.get(x).checkCurtain();
					if (hasPrize) {
						gamesWon++;
					}
				}
			}
		}
		return (gamesWon / totalGames) * 100;
	}

}
