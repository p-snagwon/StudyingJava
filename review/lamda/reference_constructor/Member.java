package review.lamda.reference_constructor;

public class Member {

    private String name;
    private String id;

    public Member() {
    }

    public Member(String id) {
        System.out.println("Member(String id) 실행");
        this.id = id;
    }

    public Member(String name, String id) {
        System.out.println("Member(String id, String name) 실행");
        this.name = name;
        this.id = id;
    }
}
