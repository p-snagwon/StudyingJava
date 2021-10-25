package chap15.treemap;

import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(87, "홍길동");
        scores.put(98, "김미수");
        scores.put(88, "박민우");
        scores.put(83, "최철수");
        scores.put(100, "수스");
        scores.put(99, "박서아");

        //검색해서 저장할 맵엔트리 객체를 생성
        Map.Entry<Integer, String> entry = null;

        entry = scores.firstEntry();
        System.out.println("가장 낮은 점수: " + entry.getKey() + entry.getValue() + "\t");

        entry = scores.lastEntry();
        System.out.println("가장 높은 점수: " + entry.getKey() + entry.getValue() + "\t");

        entry = scores.lowerEntry(85);
        System.out.println("85점보다 낮은 점수: " + entry.getKey() + entry.getValue() + "\t");

        entry = scores.higherEntry(99);
        System.out.println("99점보다 높은 점수: " + entry.getKey() + entry.getValue() + "\t");

        entry = scores.floorEntry(99);
        System.out.println("99점이거나 낮은 점수: " + entry.getKey() + entry.getValue() + "\t");

        entry = scores.ceilingEntry(99);
        System.out.println("999점이거나 높은 점수: " + entry.getKey() + entry.getValue() + "\t");

        NavigableSet<Integer> score = scores.descendingKeySet();

        for (Integer decScore : score) {
            String name = scores.get(decScore);
            System.out.println(name + " : " + decScore);
        }

        while (!scores.isEmpty()) {
            Map.Entry<Integer, String> info = scores.pollFirstEntry();
            System.out.println(info.getValue() + " : " + info.getKey() + "남은 객체 수: " + scores.size());
        }

    }
}
