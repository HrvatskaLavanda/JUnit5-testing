package neverland;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class ReportTest {

    private File testFile = new File("src/test/java/neverland/test-report.txt");

    @Test
    public void shouldGenerateReport() throws IOException {
        //given
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(CitizenTest.NAME, CitizenTest.SURNAME, CitizenTest.SALARY, tax);
        Official official = new Official(testFile.getPath());

        //when
        official.generateAnnualReport(citizen);

        //then
        Assertions.assertTrue(testFile.exists());
        String report = Files.readString(testFile.toPath());

        checkIfAllFieldsInReportAreFilled(citizen, report);
    }

    public void checkIfAllFieldsInReportAreFilled(Citizen citizen, String report) {
        Assertions.assertTrue(report.contains("Name: " + citizen.getName()));
        Assertions.assertTrue(report.contains("Surname: " + citizen.getSurname()));
        Assertions.assertTrue(report.contains("Annual income: " + citizen.calculateAnnualIncome()));
        Assertions.assertTrue(report.contains("Tax to pay: " + citizen.calculateTaxToPay()));
    }
}