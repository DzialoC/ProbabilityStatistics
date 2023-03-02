package setOperations;
import java.util.ArrayList;
/**
 * Set operations tester. 
 * Date 03022023
 * @author Dzialo
 * @version 1.0
 */
public class TesterSetOperations {

	public static void main(String []args) {
		
		SetOperations jody = new SetOperations();
		ArrayList<String> setA = new ArrayList<String>();
		ArrayList<String> setB = new ArrayList<String>();
		setA.add("Monday");
		setA.add("Tuesday");
		setA.add("Wednesday");
		setA.add("Thursday");
		setB.add("Thursday");
		setB.add("Friday");
		setB.add("Saturday");
		setB.add("Sunday");
		
		System.out.println("A is :" + setA.toString());
		System.out.println("B is :" + setB.toString());
		System.out.println("The Union of set A + B is :" + jody.union(setA,setB));
		System.out.println("The Compliment of set A + B is : " + jody.compliment(setA, setB));
		System.out.println("The intersection of set A + B is : " + jody.intersection(setA, setB));
		
	}
	
}
