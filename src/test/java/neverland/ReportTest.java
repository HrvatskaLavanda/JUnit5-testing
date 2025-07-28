package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

class ReportTest {

    @Test
    public void shouldGenerateReport() {
        //given
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(CitizenTest.SALARY, tax);
        Official official = new Official();
        File file = new File("report.txt");

        //when
        official.generateAnnualReport(citizen);

        //then
        Assertions.assertTrue(file.exists());
    }
}