public class PaymentClient {

    public static void main(String[] args) {
        // Using legacy system through the adapter
        LegacyPaymentService legacyService = new LegacyPaymentService();
        PaymentProcessor processor = new LegacyPaymentAdapter(legacyService);

        processor.pay(49.99); // Output: Legacy payment of 4999 cents processed.

        // Using the new payment system through the adapter
        PaymentProcessor stripeProcessor = new StripePaymentProcessor();
        stripeProcessor.pay(49.99); // Output: Paid $49.99 using Stripe.
    }
}
