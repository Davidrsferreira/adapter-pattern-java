public class LegacyPaymentAdapter implements PaymentProcessor{
    private final LegacyPaymentService paymentService;

    public LegacyPaymentAdapter(LegacyPaymentService legacyService) {
        this.paymentService = legacyService;
    }

    @Override
    public void pay(Double amount) {
        String amountInCents = String.valueOf((int)(amount * 100));
        paymentService.makePayment(amountInCents);
    }
}
