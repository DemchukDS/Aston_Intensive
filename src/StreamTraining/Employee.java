package StreamTraining;

public class Employee {
    private int age;
    private String name;
    private String sex;
    private double salary;

    public Employee(String name, String sex, int age, double salery) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salery;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Name: " + getName() + ", sex: " + getSex() + ", age: " + getAge() + ", salery: " + getSalary() + "$");
    }
}
