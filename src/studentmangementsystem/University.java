package studentmangementsystem;

import java.util.ArrayList;
import java.util.Map;

public class University {

    private ArrayList<Person> persons;

    public University() {
        this.persons = new ArrayList();
    }

    public University(ArrayList<Person> persons) {
        this.persons = new ArrayList(persons);
    }

    public ArrayList<Person> getPersons() {
        if (persons == null) {
            return null;
        }
        return persons;
    }
    //this function to add person

    public void AddPerson(String name, PersonDetail pr) {
        Person p = new Person(name, pr);
        if (persons == null) {
            this.persons = new ArrayList();
        }
        persons.add(p);
    }

    //this function to delete person
    public boolean DeletePerson(String name, PersonDetail personDet) {
        if (getPersons() == null) {
            return false;
        }
        return getPersons().removeAll(SearchPerson(name, personDet));
    }

    //this function to search
    public ArrayList<Person> SearchPerson(String name, PersonDetail personDet) {
        if (getPersons() == null) {
            return null;
        }
        ArrayList p_s = new ArrayList();
        for (Person p : getPersons()) {
            if (name.equals(p.getName()) && personDet.getProperties().equals(p.getPersonDet().getProperties())) {
                p_s.add(p);
            }
        }
        return p_s;
    }
    //this function to display persons

    public void Display(ArrayList<Person> ps) {
        if (ps.isEmpty()) {
            System.out.println("\nNot found!\n");
        } else {
            for (Person per : ps) {
                System.out.println(per.toString());
                Map<String, Object> prs = per.getPersonDet().getProperties();
                for (Map.Entry dd : prs.entrySet()) {
                    System.out.println(dd.getKey() + " : " + dd.getValue());
                }
                System.out.println("-----------------------------");
            }
        }
    }
}
