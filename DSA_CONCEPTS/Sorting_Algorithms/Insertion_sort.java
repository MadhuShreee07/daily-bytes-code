
/*
The insertion sort works as follows: 
• Begin from the 2nd element.   
• We take an element from unsorted part and compare it with elements in
sorted part, moving from right to left.*/


//to sort characters exactly the same code instead of int use char
//BEST TC- 0(N)
//AVERAGE WORST - O(N^2)

//Ascending	small to big  arr[j] > key
//Descending Big to small	arr[j] < key
public class Insertion_sort {

    static void insertionSort(int[] a) {
        int n = a.length;        

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

                                       // Shift elements of a[0..i-1] that are greater than key
            for(;j>=0;j--) {
            	if(a[j]>key)
            		a[j+1]=a[j];
            	else 
            		break;
            }
   
            // Place key at its correct position
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertionSort(arr);

        System.out.println("\nAfter sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

