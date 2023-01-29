package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {

        String name = MenuUtil.requirename();
        String surname = MenuUtil.requiresurname();
        String classname = MenuUtil.requireclassname();
        int age = MenuUtil.requireage();

        Student st = new Student(name, surname, age, classname);
        return st;
    }

    public static void printAllRegistredStudents() {
        if (Config.studentns == null) {
            return;
        }
        for (int i = 0; i < Config.studentns.length; i++) {
            Student st = Config.studentns[i];
            System.out.println((i + 1) + " " + st.getfullinfo());
        }

    }

    public static void registerStudent() {
        int count = InputUtil.requirenumber("how many will Students be ? ");
        Config.studentns = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "Register");
            Config.studentns[i] = StudentUtil.fillStudent();
        }

        System.out.println("registration completed succesfully");
        StudentUtil.printAllRegistredStudents();
    }

    public static void findstudentandprint() {
        String text = InputUtil.requiretext("type name,surname or class name");
        Student[] result = findstudent(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getfullinfo());
        }
    }

    public static Student[] findstudent(String text) {
        int count = 0;
        for (int i = 0; i < Config.studentns.length; i++) {
            Student st = Config.studentns[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassname().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.studentns.length; i++) {
            Student st = Config.studentns[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassname().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updatestudentwitnewhobyekt() {
        StudentUtil.printAllRegistredStudents();
        int i = InputUtil.requirenumber("nececi adamda deyisiklik etmek isteyirsiz");
        System.out.println("melumatlari daxil edin:");
        Student s = StudentUtil.fillStudent();
        Config.studentns[i - 1] = s;//burada varaq deyisdirili veriler silinib yerine tezesi yazilmir
    }

    public static void updatestudentsameobyekt() {
        StudentUtil.printAllRegistredStudents();
        int i = InputUtil.requirenumber("nececi adamda deyisiklik etmek isteyirsiz");
        System.out.println("melumatlari daxil edin:");

        Student selectedstudent = Config.studentns[i - 1];
        String changeparams = InputUtil.requiretext("neleri deyisdirmek isteyirsiz:mes 'name','surname'");

        if (changeparams.contains("'name'")) {
            selectedstudent.setName(MenuUtil.requirename());
        }
        if (changeparams.contains("'surname")) {
            selectedstudent.setSurname(MenuUtil.requiresurname());
        }
        if (changeparams.contains("'age'")) {
            selectedstudent.setAge(MenuUtil.requireage());
        }
        if (changeparams.contains("'classname'")) {
            selectedstudent.setClassname(MenuUtil.requireclassname());
        }
    }

    public static void updatestudentwitrhsplit() {
        StudentUtil.printAllRegistredStudents();
        int index = InputUtil.requirenumber("nececi adamda deyisiklik etmek isteyirsiz");
        System.out.println("melumatlari daxil edin:");

        Student selectedstudent = Config.studentns[index - 1];
        String changeparams = InputUtil.requiretext("neleri deyisdirmek isteyirsiz:mes 'name','surname'");
        String[] parametrs = changeparams.split(",");
        for (int i = 0; i < parametrs.length; i++) {
            String params = parametrs[i];
            if (params.equalsIgnoreCase("name")) {
                selectedstudent.setName(MenuUtil.requirename());
            } else if (params.equalsIgnoreCase("surname")) {
                selectedstudent.setSurname(MenuUtil.requiresurname());
            } else if (params.equalsIgnoreCase("age")) {
                selectedstudent.setAge(MenuUtil.requireage());
            } else if (params.equalsIgnoreCase("classname")) {
                selectedstudent.setClassname(MenuUtil.requireclassname());
            }
        }
    }
}
