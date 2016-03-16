public class Main {
	static public void main(String[] args) {
		int[] A = {3, 2, 8, 9, 0, 1, 2, 2}; 
		
		quickSort(A);
		
		for (Integer i : A) {
			System.out.println(i);
		}
		
	}
	
	static void quickSort(int[] A) {
		split(A, 0, A.length-1);
	}
	
	static void split(int[] A, int i0, int i1) {
		if (i0 < i1) {
			int pivot = A[i1];
			int wall = i0; // everyone to the left is <= pivot
			for (int j = i0; j < i1; j++) {
				if (A[j] <= pivot) {
					int vWall = A[wall];
					A[wall] = A[j];
					A[j] = vWall;
					wall++;
				}
			}
			int vWall = A[wall];
			A[wall] = pivot;
			A[i1] = vWall;
			split(A,i0,wall-1);
			split(A,wall+1,i1);
		}
	}
}
