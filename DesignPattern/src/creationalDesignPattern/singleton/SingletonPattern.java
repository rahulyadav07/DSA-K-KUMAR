package creationalDesignPattern.singleton;



public class SingletonPattern {
    private static SingletonPattern instance = null;
    private SingletonPattern() {

    }


    private static  SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance =  new SingletonPattern();
                    return instance;
                }
                else {
                    return instance;
                }
            }
        }
        else {
            return instance;
        }


    }

}
