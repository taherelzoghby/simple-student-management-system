package studentmangementsystem;

import java.util.*;
import java.util.regex.Pattern;

public class StudentMangementSystem {

    //function test input is string or not
    public static void validString(String str) throws notValidString {
        if (str.isEmpty() || Pattern.matches("-?\\d+(\\.\\d+)?", str)) {
            throw new notValidString("Enter valid String!");
        }
    }


    public static void main(String[] args) throws notValidString {
        Scanner input = new Scanner(System.in);
        int select = 0;
        String name = null, faculty = null, course = null;
        University u1 = new University();
        HashMap pr1 = new HashMap();
        while (select != 5) {
            System.out.println("--\t--\t--\t--MENU--\t--\t--\t--\n1: Add person\n2: Delete person\n3: Search person \n4: Display person\n5: Exit program");
            System.out.print("Enter your selection : ");
            select = input.nextInt();

            try {
                switch (select) {
                    case 1 -> {
                        System.out.print("Enter your name : ");
                        name = input.nextLine();
                        name += input.nextLine();
                        validString(name);
                        System.out.print("Enter your faculty : ");
                        faculty = input.nextLine();
                        validString(faculty);
                        pr1.put("Faculty", faculty);
                        System.out.print("Enter your course : ");
                        course = input.nextLine();
                        validString(course);
                        pr1.put("course", course);
                        System.out.print("Select your gender (1-male 2-female) : ");
                        int select_Gender = input.nextInt();
                        Gender ge = switch (select_Gender) {
                            case 1 ->
                                Gender.Male;
                            case 2 ->
                                Gender.Female;
                            default ->
                                Gender.Male;
                        };
                        pr1.put("gender", ge);
                        u1.AddPerson(name, new PersonDetail(pr1));

                    }
                    case 2 -> {
                        System.out.print("Enter name : ");
                        name = input.nextLine();
                        name += input.nextLine();
                        System.out.print("Enter your faculty : ");
                        faculty = input.nextLine();
                        pr1.put("Faculty", faculty);
                        System.out.print("Enter your course : ");
                        course = input.nextLine();
                        pr1.put("course", course);
                        System.out.print("Select your gender (1-male 2-female) : ");
                        int select_Gender = input.nextInt();
                        Gender ge = switch (select_Gender) {
                            case 1 ->
                                Gender.Male;
                            case 2 ->
                                Gender.Female;
                            default ->
                                Gender.Male;
                        };
                        pr1.put("gender", ge);
                        if (u1.DeletePerson(name, new PersonDetail(pr1))) {
                            System.out.println("person is deleted : " + name + " , " + faculty + " , " + course);
                        } else {
                            System.out.println("Person is not found!");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter name : ");
                        name = input.nextLine();
                        name += input.nextLine();
                        System.out.print("Enter your faculty : ");
                        faculty = input.nextLine();
                        System.out.print("Enter your course : ");
                        course = input.nextLine();
                        System.out.print("Select your gender (1-male 2-female) : ");
                        int select_Gender = input.nextInt();
                        Gender ge = switch (select_Gender) {
                            case 1 ->
                                Gender.Male;
                            case 2 ->
                                Gender.Female;
                            default ->
                                Gender.Male;
                        };
                        pr1.put("Faculty", faculty);
                        pr1.put("course", course);
                        pr1.put("gender", ge);
                        if (!u1.SearchPerson(name, new PersonDetail(pr1)).isEmpty()) {
                            u1.Display(u1.SearchPerson(name, new PersonDetail(pr1)));
                        } else {
                            System.out.println("Person is not found!");
                        }
                    }
                    case 4 -> {
                        u1.Display(u1.getPersons());
                    }
                }
            } catch (notValidString e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
