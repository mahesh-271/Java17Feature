package designpatterns.factory;

public class Factory {

    public static Payment createObjects(String name){

        if(name == null){
            return null;
        }
        if(name.equals ( "UPI" )) {
            return new UPIPayment ();
        }
        if(name.equalsIgnoreCase ( "credit" ))
        {
            return new CreditCard ();
        }
        return null;
    }
}
