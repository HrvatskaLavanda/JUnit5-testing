package neverland;

import java.io.FileWriter;
import java.io.IOException;

public class Report {
    public void generateAnnualReport(Citizen citizen) {
        try {
            FileWriter writer = new FileWriter("report.txt");

            writer.write("Name: " + citizen.getName());
            writer.write("Surname: " + citizen.getSurname());
            writer.write("Annual income: " + citizen.calculateAnnualIncome());
            writer.write("Tax to pay: " + citizen.calculateTaxToPay());

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
