package Exercise.OpinionPoll;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        setAge(age);
        setName(name);
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
