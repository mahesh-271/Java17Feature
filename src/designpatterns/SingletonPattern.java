package designpatterns;

public class SingletonPattern {

    private static SingletonPattern instance;

    private SingletonPattern(){};

    //synchronized keyword is used for thread safe
    public static synchronized SingletonPattern getInstance(){

        if(instance == null){
            instance =  new SingletonPattern ();
        }
        return instance;
    }

    public static void main(String []args) {

        SingletonPattern singletonPattern = SingletonPattern.getInstance ();
        SingletonPattern singletonPattern1 = SingletonPattern.getInstance ();

        boolean isSame = singletonPattern1 == singletonPattern;
        System.out.println ("Both are same :" + isSame);
    }
}
