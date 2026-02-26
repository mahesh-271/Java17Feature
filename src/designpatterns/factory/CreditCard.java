package designpatterns.factory;

public class CreditCard implements Payment{

    @Override
    public void pay() {
        System.out.println ("Paid through credit card");
    }
}
