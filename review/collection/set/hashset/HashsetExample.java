package review.collection.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetExample {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("ibatis");

        int size = set.size();
        System.out.println("총 객체 수 :" + size);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.remove("JDBC");
        set.remove("iBatis");

        System.out.println("총 객체 수 :" + size);

        iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

    }
}
