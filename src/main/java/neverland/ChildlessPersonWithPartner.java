package neverland;

public class ChildlessPersonWithPartner implements Tax {
    private final double childlessPersonWithPartnerTax = 25;

    @Override
    public double calculateTax() {
        System.out.println("Your tax in percent: " + childlessPersonWithPartnerTax + " percent.");
        return childlessPersonWithPartnerTax / 100;
    }
}
