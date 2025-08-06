package neverland;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Official {

    private String fileName;

    public Official(String fileName) {
        this.fileName = fileName;
    }

    public void generateAnnualReport(Citizen citizen) {
        try {
            FileWriter writer = new FileWriter(fileName);

//            Files.write(Path.of("report.txt"), ) - inny sposób
            writer.write("Name: " + citizen.getName() + " ");
            writer.write("Surname: " + citizen.getSurname() + " ");
            writer.write("Annual income: " + citizen.calculateAnnualIncome() + " ");
            writer.write("Tax to pay: " + citizen.calculateTaxToPay() + " ");

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
