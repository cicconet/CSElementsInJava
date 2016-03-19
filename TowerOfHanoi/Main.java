
// solves the tower of hanoi problem recursively
// each tower is implemented as a stack

public class Main {
	static Stack s1 = new Stack();
	static Stack s2 = new Stack();
	static Stack s3 = new Stack();
	static Stack[] ss = {s1, s2, s3};

	public static void main(String[] args) {

		int n = 25; // number of discs initially at first tower
		for (int i = 0; i < n; i++) {
			ss[0].push(n-i);
		}

		System.out.println("before");
		System.out.printf("s1:\t"); ss[0].print();
		System.out.printf("s2:\t"); ss[1].print();
		System.out.printf("s3:\t"); ss[2].print();

		long startTime = System.nanoTime();
		
		moveN(n);
		
		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("after");
		System.out.printf("s1:\t"); ss[0].print();
		System.out.printf("s2:\t"); ss[1].print();
		System.out.printf("s3:\t"); ss[2].print();

		System.out.println("estimated time (s): "+estimatedTime/(1e9));
	}

	static void move1(int iOrig, int iDest) {
		Stack.Node topOrig = ss[iOrig].pop();
		ss[iDest].push(topOrig.data);
	}

	static void move2(int iOrig, int iDest, int iTemp) {
		Stack.Node topOrig = ss[iOrig].pop();
		ss[iTemp].push(topOrig.data);
		topOrig = ss[iOrig].pop();
		ss[iDest].push(topOrig.data);
		Stack.Node topTemp = ss[iTemp].pop();
		ss[iDest].push(topTemp.data);
	}

	static void moveN(int n) {
		moveN(n, 0, 2, 1);
	}

	static void moveN(int n, int iOrig, int iDest, int iTemp) {
		if (n == 1) {
			move1(iOrig,iDest);
		} else if (n == 2) {
			move2(iOrig,iDest,iTemp);
		} else {
			moveN(n-1, iOrig, iTemp, iDest);
			Stack.Node topOrig = ss[iOrig].pop();
			ss[iDest].push(topOrig.data);
			moveN(n-1, iTemp, iDest, iOrig);
		}
	}

}

class Stack {
	void print() {
		Node n = top;
		while (n != null) {
			System.out.printf("%d\t", n.data);
			n = n.next;
		}
		System.out.printf("\n");
	}
	class Node {
		Node next = null;
		int data;
		public Node(int theData) { data = theData; }
	}
	Node top;
	Node pop() {
		Node r = null;
		if (top != null) {
			r = top;
			top = top.next;
		}
		return r;
	}
	void push(int theData) {
		Node n = new Node(theData);
		n.next = top;
		top = n;
	}
}
