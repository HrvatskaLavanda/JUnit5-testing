package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

}