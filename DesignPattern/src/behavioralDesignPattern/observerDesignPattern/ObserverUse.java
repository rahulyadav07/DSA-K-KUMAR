package behavioralDesignPattern.observerDesignPattern;

public class ObserverUse {
    public static void main(String[] args) {
        NewsAjency agency = new NewsAjency();

        Observer phone = new MobileSubscriber("Mobile");
        Observer email = new EmailSubscriber("Email");

        agency.registerObserver(phone);
        agency.registerObserver(email);

        agency.setNews("AAJ ka Taja khabar");
        agency.removeObserver(email);
        agency.setNews("harit");
    }
}
