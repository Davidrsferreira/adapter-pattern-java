public class PaymentClient {

    public static void main(String[] args) {
        // Using legacy system through the adapter
        LegacyPaymentService legacyService = new LegacyPaymentService();
        legacyService.makePayment("4000");
    }
}
