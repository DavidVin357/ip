package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import ui.Ui;

/**
 * Represents generic abstract type of Commands
 */
public abstract class Command {
    /**
     * Executes command logic
     * @param tasksList - current tasks list
     * @param ui - program UI
     * @param storage - disk storage of the tasks list
     * @throws SherlockException
     */
    public abstract void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException;

    /**
     * Notifies the program if it's exiting command
     * @return
     */
    public boolean isExit() {
        return false;
    }

}
