package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CitizenTest {

    public static final BigDecimal SALARY = BigDecimal.valueOf(5000);
    public static final String NAME = "John";
    public static final String SURNAME = "Doe";
    private static final BigDecimal ANNUAL_INCOME = SALARY.multiply(BigDecimal.valueOf(12));
    private static final BigDecimal SALARY_BELOW_ZERO = BigDecimal.valueOf(-5000);

    @Test
    public void shouldCalculateTaxForSinglePersonWithNoKids() {
        //given
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(NAME, SURNAME, SALARY, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = ANNUAL_INCOME.multiply(BigDecimal.valueOf(0.39));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCalculateTaxForChildlessPersonWithPartner() {
        //given
        Tax tax = new ChildlessPersonWithPartner();
        var citizen = new Citizen(NAME, SURNAME, SALARY, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = ANNUAL_INCOME.multiply(BigDecimal.valueOf(0.25));
        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void shouldCalculateTaxForPersonWithPartnerAndKids() {
        //given
        Tax tax = new PersonWithPartnerAndKids();
        var citizen = new Citizen(NAME, SURNAME, SALARY, tax);

        //when
        BigDecimal actual = citizen.calculateTaxToPay();

        //then
        BigDecimal expected = ANNUAL_INCOME.multiply(BigDecimal.valueOf(0.20));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForSingle() {
        //given
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(NAME, SURNAME, SALARY_BELOW_ZERO, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForChildlessWithPartner() {
        //given
        Tax tax = new ChildlessPersonWithPartner();
        var citizen = new Citizen(NAME, SURNAME, SALARY_BELOW_ZERO, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

    @Test
    public void shouldThrowExceptionWhenIncomeBelowZeroForPersonWIthPartnerAndKids() {
        //given
        Tax tax = new PersonWithPartnerAndKids();
        var citizen = new Citizen(NAME, SURNAME, SALARY_BELOW_ZERO, tax);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () -> citizen.calculateTaxToPay());

    }

}