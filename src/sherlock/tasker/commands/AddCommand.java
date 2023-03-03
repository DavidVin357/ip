package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Task;
import ui.Ui;

/**
 * Represents "add" command - creates generic task when executed
 */
public class AddCommand extends Command{
    String name;

    /**
     * @param name
     */
    public AddCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {

        tasksList.addTask(new Task(this.name, false));

        storage.writeToFile(tasksList);

        ui.printLines("added: " + this.name);
    }
}
