package command;

import java.util.LinkedList;
import java.util.List;

public class ConfirmButton {
    Command theCommand;
    List moveRecord;
    public ConfirmButton(Command newCommand){
        this.theCommand = newCommand;
        moveRecord = new LinkedList();
    }

    public void press(){
        theCommand.execute();
    }
}
