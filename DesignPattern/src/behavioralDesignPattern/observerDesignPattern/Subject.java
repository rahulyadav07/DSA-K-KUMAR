package behavioralDesignPattern.observerDesignPattern;
// Observable : - basically this is responsible for emiting the value;
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
interface Observer {
    void update(String data);
}

