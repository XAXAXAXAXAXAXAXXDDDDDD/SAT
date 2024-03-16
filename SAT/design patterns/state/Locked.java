package state;
public class Locked  implements State{

    private Controller m_controller;
    private static Locked m_instance;

    public Locked (Controller c) {
        this.m_controller = c;
    }

    public static State enter (Controller c) {
        if(m_instance == null) m_instance = new Locked(c);
        return m_instance;
    }

    @Override
    public void startUnlock() {
        System.out.println("change state to Awaiting Combination");
        m_controller.changeState(AwaitingCombination.enter(m_controller));
    }

    @Override
    public void lock() {
        System.out.println("door is already Locked!");
    }

    @Override
    public void close() throws IllegalStateException{
        throw new IllegalStateException("door is currently locked and cannot be closed!");
    }

    @Override
    public void combinationEntered() throws IllegalStateException{
        throw new IllegalStateException("unlock door first!");
    }

    @Override
    public void errorEntered() throws IllegalStateException{
        throw new IllegalStateException("cannot enter error, door is locked!");
    }

    @Override
    public void open() throws IllegalStateException{
        throw new IllegalStateException("door must be closed!");
    }
}
