public class PiecePerson extends Employee{
    private Double PerPay;
    private int Number;

    public Double getPerPay() {
        return PerPay;
    }

    public void setPerPay(Double perPay) {
        PerPay = perPay;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
    private Double CalSalary(Double PerPay,int Number){
        Double Salary = PerPay*Number;
        return Salary;
    }
}
