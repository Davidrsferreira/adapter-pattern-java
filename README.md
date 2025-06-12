# Adapter Design Pattern - Java Example

## 🧩 What is the Adapter Pattern?

The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts like a bridge between two interfaces, converting the interface of a class into another interface the client expects.

Real-life analogy: Think of a power plug adapter — it allows a device from one country to be plugged into a socket of another.

---

## 💼 Scenario

You're working on a modern e-commerce system that uses a standardized interface for processing payments. However, you need to integrate a legacy third-party payment provider that doesn't match your system's interface.

This is where the Adapter Pattern shines.

---

## 🧱 Evolution

- **Version 1:** The system directly uses a legacy payment class (`LegacyPaymentService`) — tight coupling.
- **Version 2:** Introduces the Adapter Pattern to abstract the payment system via a common interface (`PaymentProcessor`), enabling both legacy and modern processors to be used interchangeably.

---

## 📦 Project Structure

```
adapter-pattern/
│
├── PaymentProcessor.java          # Target interface
├── LegacyPaymentService.java      # Adaptee (incompatible interface)
├── LegacyPaymentAdapter.java      # Adapter class
├── StripePaymentProcessor.java    # Optional modern processor
└── PaymentClient.java             # Demo client
```

---

## 🧪 Classes Overview

### `PaymentProcessor` (Target)
Interface expected by the client.

```java
public interface PaymentProcessor {
    void pay(double amount);
}
```

### `LegacyPaymentService` (Adaptee)
Legacy or third-party system with an incompatible interface.

```java
public class LegacyPaymentService {
    public void makePayment(String amountInCents) {
        System.out.println("Legacy payment of " + amountInCents + " cents processed.");
    }
}
```

### `LegacyPaymentAdapter` (Adapter)
Implements the `PaymentProcessor` interface and uses the legacy system internally.

```java
public class LegacyPaymentAdapter implements PaymentProcessor {
    private LegacyPaymentService legacyService;

    public LegacyPaymentAdapter(LegacyPaymentService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public void pay(double amount) {
        String amountInCents = String.valueOf((int)(amount * 100));
        legacyService.makePayment(amountInCents);
    }
}
```

### `StripePaymentProcessor` (Alternative Implementation)
Modern implementation of the `PaymentProcessor` interface.

```java
public class StripePaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Stripe.");
    }
}
```

---

## 🚀 How to Run

1. Compile all `.java` files.
2. Run `PaymentClient`.
3. Output:
```
Legacy payment of 4999 cents processed.
Paid $49.99 using Stripe.
```

---

## ✅ Benefits of Using Adapter

- Allows integration with legacy or third-party code.
- Promotes code reuse and separation of concerns.
- Makes your system more flexible and maintainable.

---

## 📚 Learn More

- [Adapter Pattern - Refactoring.Guru](https://refactoring.guru/design-patterns/adapter)

---

## 📜 License

MIT License