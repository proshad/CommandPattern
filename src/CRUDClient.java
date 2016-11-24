import cefalo.school.command.*;

/**
 * Created by proshad on 11/23/16.
 */
public class CRUDClient {
    public static void main(String[] args){
        System.out.println("Welcome to command pattern");
        CRUDInvoker crudInvoker = new CRUDInvoker();
        OperationReceiver operationReceiver = new OperationReceiver();

//        addcommand operation
        Command addCommand = new AddCommand(operationReceiver, "proshad");
        Command addCommand2 = new AddCommand(operationReceiver, "satyajit");
        Command addCommand3 = new AddCommand(operationReceiver, "shimul");

        crudInvoker.setCommand(addCommand);
        crudInvoker.setCommand(addCommand2);
        crudInvoker.setCommand(addCommand3);
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.undo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.undo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.undo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.undo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.undo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.redo();
        System.out.println("Current item: "+operationReceiver.toString());
        crudInvoker.redo();
        System.out.println("Current item: "+operationReceiver.toString());

//        deletecommand operation
        Command deleteCommand = new DeleteCommand(operationReceiver);
        crudInvoker.setCommand(deleteCommand);
        System.out.println("After deleting current items are: "+operationReceiver.toString());

//        Readcommand operation
        Command readCommand = new ReadCommand(1, operationReceiver);
        crudInvoker.setCommand(readCommand);
        crudInvoker.setCommand(addCommand3);
        crudInvoker.setCommand(readCommand);

//        update command operation
        Command updateCommand = new UpdateCommand(operationReceiver, 1, "safayet");
        crudInvoker.setCommand(updateCommand);

    }
}
