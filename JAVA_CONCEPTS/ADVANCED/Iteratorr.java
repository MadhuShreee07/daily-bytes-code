
import java.util.*;

public class Iteratorr {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Sai");
        list.add("Srinivas");
        list.add("Pavan");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}


//It is used to traverse collections