 /*Merge-sort is based on the divide-and-conquer paradigm.
It involves the following three steps:
• Divide the array into two (or more) subarrays
• Sort each subarray (Conquer)
• Merge them into one  */


//Descending Big to small  if (Left[i] > Right[j]) {
//Ascending small to big    if (Left[i] < Right[j]) {

//WORST AVERAGE BEST - O(nlog(n))
public class Merge_sort {

	    public static void mergeSort(int[] arr, int numberOfElements) {
	        if (numberOfElements < 2) {   // only one element in an array cannot be sorted
	            return;
	        }

	        int mid = numberOfElements / 2;        // Find the middle position and create left and right partitions
	        int[] leftArr = new int[mid];
	        int[] rightArr = new int[numberOfElements - mid];        //creation of left and right array

	        
	        //fill up the partitions on newly created left and right array.
	        for (int i = 0; i < mid; i++) {
	            leftArr[i] = arr[i];            //left array
	        }

	        for (int i = mid; i < numberOfElements; i++) {
	            rightArr[i - mid] = arr[i];            //right array
	        }

	        mergeSort(leftArr, mid);         // Apply merge sort on the left partition

	        mergeSort(rightArr, numberOfElements - mid);   	        // Apply merge sort on the right partition


	        merge(arr, leftArr, mid, rightArr, numberOfElements - mid);    	        // Finally merge the partitions

	    }

	      //here l & r are the starting ptrs of the left and right array
	    public static void merge(int[] arr, int[] Left, int l, int[] Right, int r) {
	        int i = 0, j = 0, k = 0;

	        while (i < l && j < r) {
	            if (Left[i] < Right[j]) {
	                arr[k] = Left[i];
	                i++;
	            } else {
	                arr[k] = Right[j];
	                j++;
	            }
	            k++;
	        }

	        while (i < l) {                     // Copy remaining elements of Left[]

	            arr[k] = Left[i];
	            i++;
	            k++;
	        }

	        while (j < r) {                   	  // Copy remaining elements of Right[]

	            arr[k] = Right[j];
	            j++;
	            k++;
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {34, 7, 23, 32, 5, 62};

	        System.out.println("Before Sorting:");
	        for (int n : arr) {
	            System.out.print(n + " ");
	        }

	        mergeSort(arr, arr.length);

	        System.out.println("\n\nAfter Sorting:");
	        for (int n : arr) {
	            System.out.print(n + " ");
	        }
	    }
	}

//mergesort - divide
//merge - conquer


//nikhil lohia