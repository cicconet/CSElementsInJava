// a hash table is essentially a dictionary, i.e., a container for (key, value) pairs
// keys are mapped to indices (buckets) by a hash function
// every bucket is a linked list

public class Main {
	public static void main(String[] args) {
		put("Physics", "Takaaki Kajita and Arthur B. McDonald");
		put("Chemistry", "Tomas Lindahl, Paul Modrich and Aziz Sancar");
		put("Physiology or Medicine", "William C. Campbell and Satoshi Ōmura");
		put("Literature", "Svetlana Alexievich");
		put("Peace", "National Dialogue Quartet");
		
		String key = "Peace";
		String value = get(key);
		if (value != null) {
			System.out.println("Nobel Prize 2015");
			System.out.println(key+": "+value);
		}
	}
	
	static final int nBuckets = 31;
	static final KeyValueNode[] buckets = new KeyValueNode[nBuckets];
	
	static int hash(String s) {
		int h = 0;
		for (int i = 0; i < s.length(); i++) {
			h = (h*3 % nBuckets)+s.charAt(i);
		}
		return h % nBuckets;
	}
	
	static void put(String key, String value) {
		int index = hash(key);
		KeyValueNode bucket = buckets[index];
		if (bucket == null) {
			buckets[index] = new KeyValueNode(key, value);
		} else { // handle collision
			KeyValueNode node = bucket;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new KeyValueNode(key, value);
		}
	}
	
	static String get(String key) {
		int index = hash(key);
		String value = null;
		KeyValueNode node = buckets[index];
		while (node != null) {
			if (key.equals(node.key)) {
				value = node.value;
				break;
			} else {
				node = node.next;
			}
		}
		return value;
	}
}

class KeyValueNode {
	String key;
	String value;
	KeyValueNode(String theKey, String theValue) {
		key = theKey;
		value = theValue;
	}
	KeyValueNode next = null;
}