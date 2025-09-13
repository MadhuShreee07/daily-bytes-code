
public class String_functions {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "   Java Programming   ";

        // 1. concat()
        System.out.println("Concat: " + str1.concat(" " + str2));

        // 2. length()
        System.out.println("Length: " + str1.length());

        // 3. charAt()
        System.out.println("charAt(1): " + str1.charAt(1));

        // 4. substring()
        System.out.println("Substring (1,4): " + str1.substring(1, 4));

        // 5. equals() and equalsIgnoreCase()
        System.out.println("Equals: " + str1.equals("Hello"));
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase("hello"));

        // 6. compareTo()
        System.out.println("CompareTo: " + str1.compareTo(str2));

        // 7. toUpperCase() and toLowerCase()
        System.out.println("Uppercase: " + str1.toUpperCase());
        System.out.println("Lowercase: " + str1.toLowerCase());

        // 8. trim()
        System.out.println("Trim: '" + str3.trim() + "'");

        // 9. replace()
        System.out.println("Replace: " + str2.replace("World", "Java"));

        // 10. contains()
        System.out.println("Contains 'Hell': " + str1.contains("Hell"));

        // 11. startsWith() and endsWith()
        System.out.println("StartsWith 'He': " + str1.startsWith("He"));
        System.out.println("EndsWith 'lo': " + str1.endsWith("lo"));

        // 12. indexOf() and lastIndexOf()
        String str4 = "Programming";
        System.out.println("IndexOf 'g': " + str4.indexOf('g'));
        System.out.println("LastIndexOf 'g': " + str4.lastIndexOf('g'));

        // 13. split()
        String[] words = str3.trim().split(" ");
        System.out.print("Split: ");
        for (String w : words) {
            System.out.print(w + " ");
        }
        System.out.println();

        // 14. isEmpty()
        String emptyStr = "";
        System.out.println("Is Empty: " + emptyStr.isEmpty());

        // 15. join()
        String joined = String.join("-", "Java", "Python", "C++");
        System.out.println("Join: " + joined);

        // 16. valueOf()
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf int to String: " + numStr + " (length: " + numStr.length() + ")");
    }
}

