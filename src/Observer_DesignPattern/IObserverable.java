package Observer_DesignPattern;

public interface IObserverable {
    public void add_observer(IObserver observer);
    public void remove_observer(IObserver observer);
    public void notify_observer();
}
