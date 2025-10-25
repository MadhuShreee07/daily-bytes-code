public class rough {
    public static void main(String[] args) {
        char[] arr = {'H', 'E', 'L', 'L', 'O', 'H', 'O', 'W', 'A', 'R', 'E', 'Y', 'O', 'U'};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            char key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key
            // one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // Helper method to print array elements
    public static void printArray(char[] arr) {
        for (char c : arr)
            System.out.print(c + " ");
        System.out.println();
    }
}
