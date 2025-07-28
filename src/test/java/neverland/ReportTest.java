package neverland;

import org.junit.jupiter.api.Test;

class ReportTest {

    @Test
    public void shouldGenerateReport() {
        //given
        var report = new Official();
        Tax tax = new SingleWIthNoKids();
        var citizen = new Citizen(CitizenTest.SALARY, tax);
        Official official = new Official();

        //when
        official.generateAnnualReport(citizen);

        //then

    }
}