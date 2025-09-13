
import java.util.*;

class Array_List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list);           // [Apple, Banana, Cherry]
        System.out.println(list.get(1));    // Banana
        list.remove("Banana");
        System.out.println(list);           // [Apple, Cherry]
    }
}

//ArrayList is a resizable (dynamic) array implementation in Java.
//Belongs to java.util package.