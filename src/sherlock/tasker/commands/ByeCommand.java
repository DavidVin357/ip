package commands;

import data.TasksList;
import storage.Storage;
import ui.Ui;

/**
 * Represents "bye" command - exists program when executed
 */
public class ByeCommand extends Command{
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) {
        ui.printLines("Bye. Hope to see you again soon!");
    }
}
