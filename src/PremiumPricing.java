public class PremiumPricing extends BasePricing{
    // overridding : same method signature , different behavior for primium rides;
    @Override
    public double calculateFare(double distance)
    {
        return distance * 2.5+5.0; // primium rate + 5base fee;
    }
    // overloading: same method name : different parameter(adding a promo code);
    public double calculateFare(double distance , double discount)
    {
        double total = calculateFare(distance);// calculte the overriden method;
        return total-discount;
    }
}
