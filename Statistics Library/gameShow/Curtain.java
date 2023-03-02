package gameShow;
/**
 * Curtain Class that creates a curtain object with two boolean values. Used in GameShow class. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class Curtain {
	private boolean prize;
	private boolean opened;
	
	public Curtain(boolean prizeInput) {
		prize = prizeInput;
		opened = false;
	}
	
	public boolean checkCurtain() {
		return prize;
	}
	
	public void setOpened() {
		opened = true;
	}
	
	public boolean wasOpened() {
		return opened;
	}

}
