package creationalDesignPattern.singleton;



public class SingletonPattern {
    private static SingletonPattern instance = null;
    private SingletonPattern() {

    }


    private static synchronized SingletonPattern getInstance() {
        if (instance == null) {
            instance =  new SingletonPattern();
            return instance;
        }
        else {
            return instance;
        }
    }

}
