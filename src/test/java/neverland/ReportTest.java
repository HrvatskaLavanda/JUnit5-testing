package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    public void shouldGenerateReport() {
        //given
        var report = new Report();
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(CitizenTest.SALARY, tax);

        //when
        report.generateAnnualReport(citizen);

        //then

    }
}