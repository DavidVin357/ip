package commands;

import data.TasksList;
import storage.Storage;
import ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) {
        ui.printLines(tasksList.toString());
    }
}
