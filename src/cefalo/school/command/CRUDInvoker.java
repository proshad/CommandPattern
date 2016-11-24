package cefalo.school.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 11/23/16.
 */
public class CRUDInvoker {
    List<Command> commands = new ArrayList<Command>();
    List<Command> undoCommands = new ArrayList<Command>();
    boolean bRedo = false;

    public CRUDInvoker(){

    }

    public void setCommand(Command command){
        reset();
        commands.add(command);
        command.execute();
    }

    public void undo(){
        if (commands.size() > 0) {
            System.out.println("Undoing the previous operation");
            Command command = commands.remove(commands.size() - 1);
            undoCommands.add(command);
            command.undo();
        }
        else {
            System.out.println("There is no command in the command lists to undo");
        }
    }

    public void redo(){
        if (undoCommands.size() > 0) {
            System.out.println("Redoing the previous operation");
            bRedo = true;
            Command command = undoCommands.remove(undoCommands.size() - 1);
            commands.add(command);
            command.redo();
        }
        else {
            System.out.println("There is no undo command in the lists to redo");
        }
    }

    private void reset(){
        if (bRedo == true) {
            undoCommands = new ArrayList<Command>();
            bRedo = false;
        }
    }
}
