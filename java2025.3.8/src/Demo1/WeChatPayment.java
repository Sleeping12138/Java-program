package Demo1;

public class WeChatPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using WeChat.");
    }
}
