package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

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

        String report;
        try {
            report = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(report.contains("Name: " + citizen.getName()));
        Assertions.assertTrue(report.contains("Surname: " + citizen.getSurname()));
        Assertions.assertTrue(report.contains("Annual income: " + citizen.calculateAnnualIncome()));
        Assertions.assertTrue(report.contains("Tax to pay: " + citizen.calculateTaxToPay()));

    }
}