public class UpiPayment implements PaymentProcessor {
    private String upiId;
    public UpiPayment(String upiId)
    {
        this.upiId = upiId;
    }
    @Override
    public void processPayment(double amount)
    {
        System.out.println("Processing UPI payment of "+ amount + "via" + upiId);
    }
}
