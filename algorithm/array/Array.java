package algorithm.array;

public class Array {

    public static String[] strArray = {"sdafa", "sdafjskl", "lskfjkl", "dsfjklasf", "sdfjlkf", "sdlfjkld", "lfjkl", "dsafkjdfklj"};

    static int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].indexOf("s") > -1) {
                count++;
            }
        }

        System.out.println("s가 들어간 개수: " + count);

    }
}
