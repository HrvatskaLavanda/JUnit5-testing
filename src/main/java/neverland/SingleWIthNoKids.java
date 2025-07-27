package neverland;

public class SingleWIthNoKids implements Tax {

    private final double singleChildlessPersonTax = 39;

    @Override
    public double calculateTax() {
        System.out.println("Your tax in percent: " + singleChildlessPersonTax + " percent.");
        return singleChildlessPersonTax / 100;
    }
}
