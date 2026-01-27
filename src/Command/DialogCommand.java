package Command;

import java.io.File;

public class DialogCommand implements Command {
    File dialogue1 = new File("dialogue.txt");
    File answers = new File("answer.txt");

    //TODO: logic
    public void speak(){
    }
    public void answer(){

    }

    @Override
    public boolean execute() {
        speak();
        answer();
        return true;
    }
}
