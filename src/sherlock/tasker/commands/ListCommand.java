package commands;

import data.TasksList;
import storage.Storage;
import ui.Ui;

/**
 * Represents "list" command - lists all the stored tasks
 */
public class ListCommand extends Command{
    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) {
        ui.printLines(tasksList.toString());
    }
}
