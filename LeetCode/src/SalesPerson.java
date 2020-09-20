public class SalesPerson extends Employee{
    private Double SaleCommmission;

    public Double getSaleCommmission() {
        return SaleCommmission;
    }

    public void setSaleCommmission(Double saleCommmission) {
        SaleCommmission = saleCommmission;
    }

    private Double CalSalary(Double Salary,Double SaleCommission){
        Double CalSalary = Salary + SaleCommission;
        return CalSalary;
    }
}
