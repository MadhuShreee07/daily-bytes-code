
/*Step 1 - Consider the first element of the list as pivot.
Step 2 - Define two variables i and j. Set i and j to first and last elements of the list
respectively.
Step 3 - Increment i until list[i] < pivot then stop.
Step 4 - Decrement j until list[j] > pivot then stop.
Step 5 - If i <= j then exchange list[i] and list[j].
Step 6 - Repeat steps 3,4 & 5 until i > j.
Step 7 - Exchange the pivot element with list[j] element*/

// BEST AVERAGE - O(n log(n))
//WORST - O(n^2)
public class Quick_sort {

    static void quickSort(int a[], int first, int last) {
        int i = first, j = last;
        int p = (first + last)/2 ;  // pivot index (you can also use (first+last)/2)

        while (i <= j) {
        	
            while (a[i] < a[p])     // find the first element greater than the pivot
                i++;
            while (a[j] > a[p])    //finds the first element smaller than the pivot
                j--;
            
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
               
                i++;
                j--;
            }
        }

        if (first < j)
            quickSort(a, first, j);
        if (i < last)
            quickSort(a, i, last);
    }

    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62};

        System.out.println("Before Sorting:");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\n\nAfter Sorting:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}

