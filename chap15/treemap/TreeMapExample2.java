package chap15.treemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
    public static void main(String[] args) {

        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(87, "홍길동");
        scores.put(98, "김미수");
        scores.put(88, "박민우");
        scores.put(83, "최철수");
        scores.put(100, "수스");
        scores.put(99, "박서아");

        NavigableMap<Integer, String> descendingMap = scores.descendingMap();
        Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
        for (Map.Entry<Integer, String> entry : descendingEntrySet) {

            System.out.print(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }
}
