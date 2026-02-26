package designpatterns.factory;

public class UPIPayment implements Payment{

    @Override
    public void pay() {
        System.out.println ("UPI Payment paid successfully");
    }
}
