package Demo1;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(100); // 使用信用卡支付

        context.setPaymentStrategy(new WeChatPayment());
        context.executePayment(200); // 使用微信支付

        context.setPaymentStrategy(new AlipayPayment());
        context.executePayment(300); // 使用支付宝支付
    }
}
