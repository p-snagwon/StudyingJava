package review.generic.boundedtype_parameter;

public class BoundedTypeParameterExample {

    public static void main(String[] args) {

//        int compare = Util.compare("a", "a");

        int result1 = Util.compare(10, 20);
        System.out.println(result1);

        int result2 = Util.compare(4.5, 3);
        System.out.println(result2);

    }
}
