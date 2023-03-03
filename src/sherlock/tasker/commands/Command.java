package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import ui.Ui;

public abstract class Command {
    public abstract void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException;

    public boolean isExit() {
        return false;
    }

}
