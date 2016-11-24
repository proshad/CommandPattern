package cefalo.school.command;

/**
 * Created by proshad on 11/23/16.
 */
public class AddCommand implements Command {

    private OperationReceiver operationReceiver;
    String item;

    public AddCommand(OperationReceiver operationReceiver, String name) {
        this.operationReceiver = operationReceiver;
        this.item = name;
    }

    @Override
    public void execute() {
        operationReceiver.add(item);
    }

    @Override
    public void undo() {
        operationReceiver.delete();
    }

    @Override
    public void redo() {
        operationReceiver.add(item);
    }
}
