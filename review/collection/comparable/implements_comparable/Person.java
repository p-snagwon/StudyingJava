package review.collection.comparable.implements_comparable;

public class Person implements Comparable<Person>{

    //comparable인터페이스를 구현해서 compareTO를 구현하든가
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(age < o.age) return -1;
        else if(age == o.age) return 0;
        else return 1;
    }
}
