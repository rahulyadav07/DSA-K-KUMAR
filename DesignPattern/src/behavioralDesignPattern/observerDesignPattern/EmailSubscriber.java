package behavioralDesignPattern.observerDesignPattern;

public class EmailSubscriber implements Observer{
    private String name;

    EmailSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String data) {
        System.out.println(name + " recieve nes by mail" + data);
    }
}

class MobileSubscriber implements Observer {
    private String name;
    MobileSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String data) {
        System.out.println(name + " recieve news by mobile" + data);
    }
}