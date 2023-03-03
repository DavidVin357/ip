package commands;

import data.TasksList;
import storage.Storage;
import ui.Ui;

/**
 * Represents invalid state of the commands - displays error message to the user
 */
public class IncorrectCommand extends Command{
    String feedback;

    /**
     * @param feedback
     */
    public IncorrectCommand(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) {
        ui.printLines(feedback);
    }
}
