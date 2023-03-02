package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Deadline;
import ui.Ui;

public class DeadlineCommand extends Command {
    String name;
    String by;
    public DeadlineCommand(String name, String by) {

        this.name = name;
        this.by = by;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {

        Deadline deadline = new Deadline(this.name, false, this.by);
        tasksList.addTask(deadline);

        ui.printAddedTask(deadline, tasksList);
        storage.writeToFile(tasksList);
    }
}
