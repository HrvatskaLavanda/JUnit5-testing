package neverland;

import java.math.BigDecimal;

public class Citizen {
    private String name;
    private String surname;
    private BigDecimal annualIncome;
    private BigDecimal taxToPay;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public BigDecimal getTaxToPay() {
        return taxToPay;
    }

    public Tax getTax() {
        return tax;
    }

    private Tax tax;

    public Citizen(Tax tax) {
        this.tax = tax;
    }

    public BigDecimal calculateTaxToPay() {
        double taxRateDouble = tax.calculateTax();
        BigDecimal taxRate = BigDecimal.valueOf(taxRateDouble);
        if (annualIncome.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Annual income cannot be under 0");
        }
        taxToPay = annualIncome.multiply(taxRate);
        return taxToPay;
    }
}
