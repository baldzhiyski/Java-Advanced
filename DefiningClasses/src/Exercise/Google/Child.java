package Exercise.Google;

public class Child {
    private String name;
    private String birthday;


    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
