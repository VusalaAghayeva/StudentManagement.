package beans;

public class Student {
    private String name;
    private String surname;
    private int age;
    private String classname;

    public Student() {
    }

    public Student(String name, String surname, int age, String classname) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.classname = classname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getfullinfo() {
        return this.getName() + " " + this.getSurname() + " " + this.getAge() + " " + this.getClassname();

    }
}