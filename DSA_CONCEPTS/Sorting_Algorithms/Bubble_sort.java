
/*The bubble sort works as follows:
• begin from the first index, compare the first and the second elements.
• If the first element is greater than the second element, they are swapped.
• Now compare the second and the third elements. Swap them if they are not in order.
• The above process goes on until the last element*/


class Bubble_sort {

    static void bubbleSort1(int a[]) {
        int n = a.length;
        boolean swapped=true;

        for (int i = 0; i < n - 1; ++i) {
            swapped = false;

            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    
                    int t = a[j];    //swap elements
                    a[j] = a[j + 1]; 
                    a[j + 1] = t;
                    swapped = true;
                }
            }

            // If no swaps, array is sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before sorting:");
        for (int num : arr) System.out.print(num + " ");

        bubbleSort1(arr);

        System.out.println("\nAfter sorting:");
        for (int num : arr) System.out.print(num + " ");
    }
}
