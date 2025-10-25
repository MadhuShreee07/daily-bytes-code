


/*The selection sort works as follows:
• Begin from left most element.
• Find smallest element, swap it with the first element of the array.
• Then find the next smallest element in the remaining array (an array without
the first element) and swap it with the second element.*/

//BEST AVERAGE WORST TC - O(n^2) 


//Ascending	small - large (arr[min] > arr[j])
//Descending large to small	 (arr[min] < arr[j])

public class Selection_sort {

    static void selectionsort(int a[]) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int min  = i;

            // Find the index of the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) 
                    min = j;
                
            }

            // Swap a[i] with a[min]
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};

        System.out.println("Before sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }

        selectionsort(a);

        System.out.println("\nAfter sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
 
