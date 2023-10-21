package halloween;

public class Kid {
    private String name;
    private int age;
    private String street;

    public Kid(String name, int age, String street) {
        this.name = name;
        this.age = age;
        this.street = street;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return String.format("%s,%d years old, from %s",name,age,street);
    }
    public String toOutput(){
        return String.format("%s from %s street",name,street);
    }
}
