package DAO操作;

public class Student {
    private String number;
    private String name;
    private  int age;
    private  String sex;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String number, String name, int age, String sex) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Student(String number, String name, String age, String sex) {
        this.number = number;
        this.name = name;
        this.age = Integer.parseInt(age);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
