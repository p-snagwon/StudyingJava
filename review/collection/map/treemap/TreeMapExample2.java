package review.collection.map.treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
    public static void main(String[] args) {

        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(87, "홍길동");
        scores.put(98, "이동수");
        scores.put(75, "박길순");
        scores.put(95, "신용권");
        scores.put(99, "박상원");

        //원래는 올림차순이네
        Set<Map.Entry<Integer, String>> entries1 = scores.entrySet();
        for (Map.Entry<Integer, String> entry : entries1) {
            System.out.print(entry.getKey() + "-" + entry.getValue());

        }
        System.out.println();

        NavigableMap<Integer, String> descendingMap = scores.descendingMap();
        Set<Map.Entry<Integer, String>> entries = descendingMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.print(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();

        NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
        Set<Map.Entry<Integer, String>> entries2 = ascendingMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries2) {
            System.out.print(entry.getKey() + "-" + entry.getValue());
        }
    }
}
