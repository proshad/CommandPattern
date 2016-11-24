package cefalo.school.command;

/**
 * Created by proshad on 11/23/16.
 */
public class ReadCommand implements Command {
    private OperationReceiver operationReceiver;
    int position;

    public ReadCommand(int position, OperationReceiver operationReceiver) {
        this.operationReceiver = operationReceiver;
        this.position = position;
    }

    @Override
    public void execute() {
        operationReceiver.read(position);
    }

    @Override
    public void undo() {
        System.out.println("Undo doesn't support from read command");
    }

    @Override
    public void redo() {
        System.out.println("Redo doesn't support from read command");
    }
}
