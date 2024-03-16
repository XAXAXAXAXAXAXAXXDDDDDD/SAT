package state;
public abstract interface State {

    // bei ungültige Zustände wird eine Exception geworfen

    public void close();
    public void combinationEntered();
    public void errorEntered();
    public void lock();
    public void open();
    public void startUnlock();


}
