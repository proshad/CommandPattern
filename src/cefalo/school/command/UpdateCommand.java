package cefalo.school.command;

/**
 * Created by proshad on 11/23/16.
 */
public class UpdateCommand implements Command {
    private OperationReceiver operationReceiver;
    String newValue;
    int position;
    String oldValue;

    public UpdateCommand(OperationReceiver operationReceiver, int position, String updatedValue){
        this.operationReceiver = operationReceiver;
        this.position = position;
        this.newValue = updatedValue;
    }

    @Override
    public void execute() {
        oldValue = operationReceiver.read(position);
        operationReceiver.update(position,newValue);
    }

    @Override
    public void undo() {
        operationReceiver.update(position,oldValue);
    }

    @Override
    public void redo() {
        execute();
    }
}
