package state;
public class Opened implements State{

    private Controller m_controller;
    private static Opened m_instance;

    public Opened (Controller c) {
        m_controller = c;
    }

    public static State enter (Controller c) {
        if(m_instance == null) m_instance = new Opened(c);
        return m_instance;
    }

    @Override
    public void close() {
        System.out.println("change state to Closed");
        m_controller.changeState(Closed.enter(m_controller));
    }

    @Override
    public void combinationEntered() throws IllegalStateException{
        throw new IllegalStateException("cannot enter combination, door is Opened!");
    }

    @Override
    public void errorEntered() throws IllegalStateException{
        throw new IllegalStateException("cannot enter error, door is Opened!");
    }

    @Override
    public void lock() throws IllegalStateException{
        throw new IllegalStateException("door must be Closed!");
    }

    @Override
    public void open() {
        System.out.println("door is already Open!");
    }

    @Override
    public void startUnlock() throws IllegalStateException{
        throw new IllegalStateException("door must be locked!");
    }
}
