package review.collection.map.hashmap;

import java.util.*;

public class HashMapExample1 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 92);
        map.put("홍길동", 87);
        System.out.println("총 Entry수: " + map.size());


        System.out.println("\t홍길동:" + map.get("홍길동"));
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + ":" + value);
        }
        System.out.println();

        //객체 삭제
        map.remove("홍길동");
        System.out.println("총 entry수: " + map.size());

        //객체를 하나씩 처리
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        /*Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + "\t" + value);
        }
        System.out.println();
*/

        for (Map.Entry<String, Integer> entry : entries) {

        }
        map.clear();
        System.out.println("총 entry수: " + map.size());
    }
}
