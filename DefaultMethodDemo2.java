package newfeatures;

public class DefaultMethodDemo2 {

	public static void main(String[] args) {
		
		Payment upi = new UpiPayment();
        Payment card = new CardPayment();
        Payment cash = new CashPayment();

        System.out.println("\n--- UPI Payment ---");
        upi.pay(2500);
        upi.generateReceipt(2500); // uses default method

        System.out.println("\n--- Card Payment ---");
        card.pay(5000);
        card.generateReceipt(5000); // overridden default method

        System.out.println("\n--- Cash Payment ---");
        cash.pay(1200);
        cash.generateReceipt(1200); // uses default method

	}

}
