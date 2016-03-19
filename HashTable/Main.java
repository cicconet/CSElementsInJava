import java.util.Hashtable;

// simply illustrates the use of Java's Hashtable class
// a hash table is essentially a dictionary, i.e., a container for (key, value) pairs
// details: https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html

public class Main {
	public static void main(String[] args) {
		Hashtable<String, String> nobelPrizes2015 = new Hashtable<String, String>();
		nobelPrizes2015.put("Physics", "Takaaki Kajita and Arthur B. McDonald");
		nobelPrizes2015.put("Chemistry", "Tomas Lindahl, Paul Modrich and Aziz Sancar");
		nobelPrizes2015.put("Physiology or Medicine", "William C. Campbell and Satoshi Ōmura");
		nobelPrizes2015.put("Literature", "Svetlana Alexievich");
		nobelPrizes2015.put("Peace", "National Dialogue Quartet");
		
		String key = "Physiology or Medicine";
		String value = nobelPrizes2015.get(key);
		if (value != null) {
			System.out.println("Nobel Prize 2015");
			System.out.println(key+": "+value);
		}
	}
}
