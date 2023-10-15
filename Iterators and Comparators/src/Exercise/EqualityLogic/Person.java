package Exercise.EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode(){
        return (this.name.hashCode() + Integer.hashCode(age)*73);
    }
    @Override
    public boolean equals(Object object){
        if(this==object){
            return true;
        }
        if(object instanceof Person){
            Person other = (Person) object;
            return this.name.equals(other.name) && this.age==other.age;
        }
        return false;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.age, other.age);
        }
        return result;
    }
    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
