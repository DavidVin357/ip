package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Task;
import ui.Ui;

/**
 * Represents "mark" and "unmark" commands -
 * changes if the task is done or not given its index from the list
 */
public class MarkCommand extends Command {

    private boolean isDone;
    private int taskIndex;

    /**
     * @param isDone
     * @param taskIndex
     */
    public MarkCommand(boolean isDone, int taskIndex) {
        this.taskIndex = taskIndex;
        this.isDone = isDone;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {
        String successMessage = isDone ? "Nice! I've marked this task as done:"
                : "OK, I've marked this task as not done yet:";

        Task markedTask = tasksList.markTask(taskIndex, isDone);

        storage.writeToFile(tasksList);
        ui.printLines(successMessage, markedTask.toString());
    }
}


