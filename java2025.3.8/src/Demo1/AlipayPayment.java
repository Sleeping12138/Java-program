package Demo1;

public class AlipayPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Alipay.");
    }
}
