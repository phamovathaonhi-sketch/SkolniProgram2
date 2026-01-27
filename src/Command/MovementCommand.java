package Command;

public class MovementCommand implements Command{
    private String mapa;
    private String right;
    private String left;
    private String front;


    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }

    public String getFront() {
        return front;
    }

    public void goRight(){

    }
    //TODO: logic code for each command
    public void goLeft(){}
    public void goFront(){}
    public void teleport(){}
    //TODO : how to connect map with locations
    public void mapa(){}

    @Override
    public boolean execute() {
        // Here you would decide which movement to trigger
       goFront();
       goLeft();
       goRight();
       teleport();

        return true;
    }

}
