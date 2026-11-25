import java.util.Scanner;
interface Payment{
    double calculateFee(double amount);
}
class CreditCardPayment implements Payment{
    @Override 
    public double calculateFee(double amount){
        return amount * 0.2;
    }
}
class UpiPayment implements Payment{
    @Override 
    public double calculateFee(double amount){
        return amount * 0.005;
    }
}
class WalletPayment implements Payment{
    @Override 
    public double calculateFee(double amount){
        return amount * 0.1;
    }
}
public class OnlinePaymentProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paymentType = scanner.nextInt();
        double paymentAmount = scanner.nextDouble();

        Payment payment;
        if(paymentType == 1){
            payment = new CreditCardPayment();
        } else if(paymentType == 2){
            payment = new UpiPayment();
        }else if(paymentType == 3){
            payment = new WalletPayment();
        } else{
            System.out.println("Invalid");
            scanner.close();
            return;
        }
        scanner.close();
        double fee = payment.calculateFee(paymentAmount);
        double finalAmount = paymentAmount + fee;
        System.out.printf("Payment Amount: %.2f\n"+paymentAmount);
        System.out.printf("Transaction Fee: %.2f\n"+fee);
        System.out.printf("Final Amount: %.2f\n"+finalAmount);
    }
}
