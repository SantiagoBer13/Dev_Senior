package Exercise_2;

public class Person {
    private String name;
    private String membership;

    public Person(String name, String membership) {
        this.name = name;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
