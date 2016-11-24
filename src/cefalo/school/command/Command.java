package cefalo.school.command;

/**
 * Created by proshad on 11/23/16.
 */
public interface Command {
    public void execute();
    public void undo();
    public void redo();
}
