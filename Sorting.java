public class Sorting {
	public static void bubble(int arr[]) { //going to be asked to write on final
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (arr[j] > arr[j+1]) {
					//Swap
					int temp = arr[j]; 
					arr[j] = arr[j+1]; 
					arr[j+1] = temp;
				}
			}
		}
	} 
	public static void insertion(int arr[]) { 
		int n = arr.length; 
		for (int i = 1; i < n; ++i){
			int key = arr[i]; 
			int j = i - 1; //  one less

			// finding right place for key
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j]; // move it to right
				j = j-1; 
			} 
			arr[j+1] = key; 
		} 
	}

	public static void selection (int arr[]) { 
		int n = arr.length; 

		// One by one move boundary of unsorted subarray 
		for (int i = 0; i < n-1; i++) { 
			// Find the minimum element in unsorted array 
			int min_idx = i; 
			for (int j = i+1; j < n; j++) { 
				if (arr[j] < arr[min_idx]) { 
					min_idx = j; 
				}
			}
			// Swap the found minimum element with the ith element 
			int temp = arr[min_idx]; 
			arr[min_idx] = arr[i]; 
			arr[i] = temp; 
		} 
	} 
	public static void mergeSort(int arr[], int l, int r) { 
		if (l < r) { 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			mergeSort(arr, l, m); 
			mergeSort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	}
	public static void merge(int arr[], int l, int m, int r) { 
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1; 
		int n2 = r - m; 

		// Create temp arrays
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		//Copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i]; 
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		// Merge the temp arrays 
		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarray array
		int k = l; 
		while (i < n1 && j < n2) { 
			if (L[i] <= R[j]) { // is 1 less than 3
				arr[k] = L[i]; // merge 1 into original array
				i++; // move index 1 more
			} 
			else{ 
				arr[k] = R[j]; // left value is bigger than right value
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) { 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) { 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	public static void quick(int arr[], int low, int high) { 
		if (low < high) { 
			// pi is partitioning index, arr[pi] is now at right place
			int pi = partition(arr, low, high);
			System.out.println("partitioning index: " + pi);
			printArray(arr);

			// Recursively sort elements before partition and after partition 
			quick(arr, low, pi-1); 
			quick(arr, pi+1, high); 
		} 
	} 
	public static int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high];  
		int i = low;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) { 
				swap(arr,i,j);
				i++; 
			} 
		}
		swap(arr,i,high); // swapping pivot value

		return i; 
	}
	public static void swap (int [] arr, int i, int j) {
		if (i != j) {
			//System.out.println("swap arr[" + i + "]: "  + arr[i] + ", arr[" + j + "] " + arr[j]);
			// swap arr[i] and arr[j] 
			int temp = arr[i]; 
			arr[i] = arr[j]; 
			arr[j] = temp; 
		}
	}

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main (String args[]) {

		int[] arr = {64, 34, 25, 12, 22, 11, 90}; 
		bubble(arr); 
		System.out.println("Bubble Sorted array"); 
		printArray(arr); 

		arr = new int[] {64, 34, 25, 12, 22, 11, 90}; 		
		insertion(arr); 
		System.out.println("Insertion Sorted array"); 
		printArray(arr); 

		arr = new int[] {64, 34, 25, 12, 22, 11, 90}; 		
		selection(arr); 
		System.out.println("Selection Sorted array"); 
		printArray(arr); 

		arr = new int[] {64, 34, 25, 12, 22, 11, 90}; 		
		mergeSort(arr, 0, arr.length-1); 
		System.out.println("Merge Sorted array"); 
		printArray(arr); 

		arr = new int[] {173, 34, 25, 12, 64, 11, 26, 43, 87,4, 0, 22};
		printArray(arr);
		quick(arr, 0, arr.length-1); 
		System.out.println("Quick Sorted array"); 
		printArray(arr); 
	}

}
