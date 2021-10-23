package chap15.set.hashset;

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
        set.add("iBatis");

        int size = set.size();
        System.out.println("총 객체 수: " + size);


        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.remove("Java");
        set.remove("iBatis");

        System.out.println("총 객체 수: " + size);


        for (String element : set) {
            System.out.println("\t" + element);
        }

        set.clear();

        if (set.isEmpty()) {
            System.out.println("비어있음");

        }

    }

}
