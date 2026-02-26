package designpatterns.factory;

public class FactoryMethodMain {

    public static void main(String[] args) {

        Payment payment = Factory.createObjects ( "UPI" );
        Payment payment1 = Factory.createObjects ( "credit" );
        payment.pay();
        payment1.pay ();

        System.out.println (payment.getClass ());
    }
}