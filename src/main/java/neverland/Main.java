package neverland;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Citizen citizen = new Citizen("Aleksandra", "Nowak", BigDecimal.valueOf(10_000), new PersonWithPartnerAndKids());
        Official official = new Official("src/main/resources/report.txt");

        official.generateAnnualReport(citizen);
    }
}
