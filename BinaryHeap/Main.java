
// max-heap

import java.util.ArrayList;

public class Main {

	// dynamic array implementation
	static ArrayList<Integer> heap = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int[] numbers = {2, 1, 3, 5, 7, 7, 9, 2, 4, 6, 8, 0, 0};
		for (int n : numbers) {
			insert(n);
		}

		System.out.println("breadth-first traversal:");
		for (int j : heap) {
			System.out.printf("%d\t", j);
		}
		System.out.printf("\n");
		
		System.out.println("removing all elements, one by one:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d\t",remove());
		}
		System.out.printf("\n");
	}
	
	static void insert(int element) {
		heap.add(new Integer(element));
		if (heap.size() > 1) {
			// up-heap
			int index = heap.size()-1;
			int parentIndex = (index-1)/2;
			while (parentIndex < index && heap.get(index) > heap.get(parentIndex)) {
				int t = heap.get(index);
				heap.set(index,heap.get(parentIndex));
				heap.set(parentIndex,t);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}
		}
	}
	
	static Integer remove() { // removes root
		if (heap.size() == 0)
			return null;
		
		if (heap.size() == 1) // no need to heap-down
			return heap.remove(0);
		
		Integer r = heap.get(0); // to be returned after heap-down		
		
		// heap-down
		Integer last = heap.get(heap.size()-1);
		heap.set(0, last);
		heap.remove(heap.size()-1); // heap shrinks
		
		int index = 0;
		int indexLeft = 2*index+1; // index of left child
		int indexRight = 2*index+2; // index of right child
		int indexMax = indexLeft; // if we get here, root has at least one left child
		if (indexRight < heap.size() && heap.get(indexRight) > heap.get(indexLeft))
			indexMax = indexRight;
		
		while (indexLeft < heap.size() && heap.get(index) < heap.get(indexMax)) {
			// swap
			int t = heap.get(indexMax);
			heap.set(indexMax, heap.get(index));
			heap.set(index, t);
			
			index = indexMax;
			indexLeft = 2*index+1;
			indexRight = 2*index+2;
			indexMax = indexLeft;
			if (indexRight < heap.size() && heap.get(indexRight) > heap.get(indexLeft))
				indexMax = indexRight;
		}
		
		return r;
	}
}
