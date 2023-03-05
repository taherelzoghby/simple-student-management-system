package studentmangementsystem;

import java.util.regex.Pattern;

public class Person {

    private static int counter = 0;
    private int id;
    private String name;
    private final PersonDetail personDet;

    //Counter is set to 1 initially
    static {
        counter = 1;
    }

    public Person(String name, PersonDetail personDet) {
        this.id = counter;
        this.name = name;
        this.personDet = personDet;
        ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public PersonDetail getPersonDet() {
        return personDet;
    }

    @Override
    public String toString() {
        return "id : " + this.id + "\nname : " + name;
    }

}
