package chap16.stream_pipe_line;

public class Member {

    public static int MALE = 0;
    public static int FEMALE = 1;

    private String name;
    private int age;
    private int sex;

    public Member(String name, int sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static int getMALE() {
        return MALE;
    }

    public static int getFEMALE() {
        return FEMALE;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }
}
