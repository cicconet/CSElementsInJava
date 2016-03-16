
public class Main {

	public static void main(String[] args) {
		int[] A = {1, 5, 3, 9, 15, 64, 7, 2, 4, 6, 8, -10, 20};
		int[] T = new int[A.length]; // temporary storage
		
		mergeSort(A,T);
		
		for(Integer i : A) {
			System.out.println(i);
		}
	}
	
	static void mergeSort(int[] A, int[] T) {
		mergeSort(A, 0, A.length, T);
	}
	
	static void mergeSort(int[] A, int i0, int i1, int[] T) {
		if (i1 > i0+1) {
			int im = i0+(i1-i0)/2;
			mergeSort(A, i0, im, T); // sorts A[i0,...,im-1]
			mergeSort(A, im, i1, T); // sorts A[im,...,i1-1]
			merge(A,i0,i1,im,T); // merges sorted subarrays
		}
	}
	
	static void merge(int[] A, int i0, int i1, int im, int[] T) {
		int l = i0;
		int r = im;
		for (int k = i0; k < i1; k++) {
			if (l < im && (r >= i1 || A[l] <= A[r])) {
				T[k] = A[l]; 
				l++;
			} else {
				T[k] = A[r];
				r++;
			}
		}
		for (int i = i0; i < i1; i++) {
			A[i] = T[i];
		}
	}
}
