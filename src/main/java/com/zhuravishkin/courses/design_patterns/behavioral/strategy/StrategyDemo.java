package com.zhuravishkin.courses.design_patterns.behavioral.strategy;

// Client
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Paying with Credit Card:");
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(500);

        System.out.println("\nPaying with PayPal:");
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(300);

        System.out.println("\nPaying with Google Pay:");
        cart.setPaymentStrategy(new GooglePayPayment("+123456789"));
        cart.checkout(700);
    }
}

// Strategy: Интерфейс оплаты
interface PaymentStrategy {
    void pay(int amount);
}

// ConcreteStrategy: Оплата кредитной картой
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// ConcreteStrategy: Оплата через PayPal
class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

// ConcreteStrategy: Оплата через Google Pay
class GooglePayPayment implements PaymentStrategy {
    private final String phoneNumber;

    public GooglePayPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Google Pay: " + phoneNumber);
    }
}

// Context: Класс для выполнения оплаты
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment method is not set.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
