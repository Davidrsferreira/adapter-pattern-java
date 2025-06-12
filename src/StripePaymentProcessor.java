public class StripePaymentProcessor implements PaymentProcessor{
    @Override
    public void pay(Double amount) {
        System.out.println("Paid $" + amount + " using Stripe.");
    }
}
