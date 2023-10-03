package Exercise.OpinionPoll;

public class Person {
    public Person(String name, int age) {
        setAge(age);
        setName(name);
    }

    String name;
    int age;

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
