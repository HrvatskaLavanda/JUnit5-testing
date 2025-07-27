package neverland;

public class PersonWithPartnerAndKids implements Tax {
    private final double personWithPartnerAndKidsTax = 20;

    @Override
    public double calculateTax() {
        System.out.println("Your tax in percent: " + personWithPartnerAndKidsTax + " percent.");
        return personWithPartnerAndKidsTax / 100;
    }
}
