package StreamTraining;

public class Salary {
    private double salary;
    private String currensy;

    public Salary(double salary, String currensy) {
        this.currensy = currensy;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getCurrensy() {
        return currensy;
    }
}
