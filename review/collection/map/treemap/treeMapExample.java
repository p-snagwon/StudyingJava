package review.collection.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class treeMapExample {

    public static void main(String[] args) {

        TreeMap<Integer, String> scores = new TreeMap<>();

        scores.put(87, "홍길동");
        scores.put(98, "이동수");
        scores.put(75, "박길순");
        scores.put(95, "신용권");
        scores.put(99, "박상원");

        //이진트리면 Map.Entry형태로 받아야 하나보다
        Map.Entry<Integer, String> entry = null;

        entry = scores.firstEntry();
        System.out.println("가장 낮은 점수: " + entry.getKey() + " " + entry.getValue());

        entry = scores.lastEntry();
        System.out.println("가장 높은 점수: " + entry.getKey() + " " + entry.getValue());

        entry = scores.floorEntry(98);
        System.out.println("98점이거나 바로 아래점수: " + entry.getKey() + " " + entry.getValue());

        while (!scores.isEmpty()) {
            entry = scores.pollFirstEntry();
            System.out.println(entry.getKey()+ "-" + entry.getValue() + "남은 객체 수: (" + scores.size() + ")");
        }

    }
}
