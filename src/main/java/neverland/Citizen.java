package neverland;

import java.math.BigDecimal;

public class Citizen {
    private String name;
    private String surname;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    private Tax tax;

    public Citizen(BigDecimal salary, Tax tax) {
        this.salary = salary;
        this.tax = tax;
    }

    public BigDecimal calculateTaxToPay() {
        double taxRateDouble = tax.calculateTax();
        BigDecimal taxRate = BigDecimal.valueOf(taxRateDouble);
        BigDecimal annualIncome = calculateAnnualIncome();
        if (annualIncome.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Annual income cannot be under 0");
        }
        BigDecimal taxToPay = annualIncome.multiply(taxRate);
        return taxToPay;
    }

    public BigDecimal calculateAnnualIncome() {
        if (this.salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary cannot be under 0");
        }
        BigDecimal annualIncome = this.salary.multiply(BigDecimal.valueOf(12));
        return annualIncome;
    }
}
