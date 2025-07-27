package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CitizenTest {
    @Test
    public void shouldCalculateTaxForSinglePersonWithNoKids() {
        //given
        BigDecimal salary = BigDecimal.valueOf(5000);
        BigDecimal annualIncome = salary.multiply(BigDecimal.valueOf(12));
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(salary, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = annualIncome.multiply(BigDecimal.valueOf(0.39));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCalculateTaxForChildlessPersonWithPartner() {
        //given
        BigDecimal salary = BigDecimal.valueOf(5000);
        BigDecimal annualIncome = salary.multiply(BigDecimal.valueOf(12));
        Tax tax = new ChildlessPersonWithPartner();
        var citizen = new Citizen(salary, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = annualIncome.multiply(BigDecimal.valueOf(0.25));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCalculateTaxForPersonWithPartnerAndKids() {
        //given
        BigDecimal salary = BigDecimal.valueOf(5000);
        BigDecimal annualIncome = salary.multiply(BigDecimal.valueOf(12));
        Tax tax = new PersonWithPartnerAndKids();
        var citizen = new Citizen(salary, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = annualIncome.multiply(BigDecimal.valueOf(0.20));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForSingle() {
        //given
        BigDecimal salary = BigDecimal.valueOf(-5000);
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(salary, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForChildlessWithPartner() {
        //given
        BigDecimal salary = BigDecimal.valueOf(-5000);
        Tax tax = new ChildlessPersonWithPartner();
        var citizen = new Citizen(salary, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForPersonWIthPartnerAndKids() {
        //given
        BigDecimal salary = BigDecimal.valueOf(-5000);
        Tax tax = new PersonWithPartnerAndKids();
        var citizen = new Citizen(salary, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

}