package Command;

import java.io.File;

public class DialogCommand implements Command {
    File dialogue1 = new File("dialogue.txt");
    File answers = new File("answer.txt");

    public DialogCommand(File dialogue1, File answers) {
        this.dialogue1 = dialogue1;
        this.answers = answers;
    }

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
