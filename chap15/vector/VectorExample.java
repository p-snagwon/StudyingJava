package chap15.vector;

import java.util.List;
import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {

        List<Border> list = new Vector<>();

        list.add(new Border("제목1", "내용1", "긓쓴이1"));
        list.add(new Border("제목2", "내용2", "긓쓴이2"));
        list.add(new Border("제목3", "내용3", "긓쓴이3"));
        list.add(new Border("제목4", "내용4", "긓쓴이4"));
        list.add(new Border("제목5", "내용5", "긓쓴이5"));


        list.remove(2);
        list.remove(3);

        for (Border border : list) {
            System.out.println(border.subject + "\t" + border.content + "\t" + border.writer);
        }
    }
}
