package state_exp;

public interface State {

    public boolean pressPlay();

    public boolean pressPause();

    public boolean pressStop();
    
    public boolean pressRewind();
    
    public boolean pressLock();
}
