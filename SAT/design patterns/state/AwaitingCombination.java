package state;
public class AwaitingCombination implements State{

    private Controller m_controller;
    private static AwaitingCombination m_instance;
    public AwaitingCombination(Controller c) {
        this.m_controller = c;
    }

    public static State enter (Controller c) {
        if(m_instance == null) m_instance = new AwaitingCombination(c);
        return m_instance;
    }

    @Override
    public void combinationEntered() {
        System.out.println("combination Entered...");
        System.out.println("Change State to Closed");
        m_controller.changeState(Closed.enter(m_controller));
    }

    @Override
    public void errorEntered() {
        System.out.println("error Entered...");
        System.out.println("Change state to Locked");
        m_controller.changeState(Locked.enter(m_controller));
    }
    @Override
    public void close() throws IllegalStateException{
        throw new IllegalStateException("door must be open!");
    }

    @Override
    public void lock() throws IllegalStateException{
        throw new IllegalStateException("door must be closed!");
    }

    @Override
    public void open() throws IllegalStateException{
        throw new IllegalStateException("enter combination first!");
    }

    @Override
    public void startUnlock() throws IllegalStateException{
        throw new IllegalStateException("door must be locked!");
    }
}
