
class Loop {
    public static void main(String[] args) {
        
        // Sample array for loop demonstration
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("=== For Loop ===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        
        
        System.out.println("\n=== While Loop ===");
        int j = 0;
        while (j < numbers.length) {
            System.out.println("Index " + j + ": " + numbers[j]);
            j++;
        }

        
        System.out.println("\n=== Do-While Loop ===");
        int k = 0;
        do {
            System.out.println("Index " + k + ": " + numbers[k]);
            k++;
        } while (k < numbers.length);

        
        
        System.out.println("\n=== For-Each Loop ===");
        for (int num : numbers) {
            System.out.println("Value: " + num);
        }
    }
}

