package cefalo.school.command;

/**
 * Created by proshad on 11/23/16.
 */
public class DeleteCommand implements Command {
    private OperationReceiver operationReceiver;
    String itemToBeDeleted;
    public DeleteCommand(OperationReceiver operationReceiver){
        this.operationReceiver = operationReceiver;
    }
    @Override
    public void execute() {
        itemToBeDeleted = operationReceiver.delete();
    }

    @Override
    public void undo() {
        operationReceiver.add(itemToBeDeleted);
    }

    @Override
    public void redo() {
        itemToBeDeleted = operationReceiver.delete();
    }
}
