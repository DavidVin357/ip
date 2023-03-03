package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Task;
import ui.Ui;

public class DeleteCommand extends Command {
    int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {
        Task removedTask = tasksList.deleteTask(this.taskIndex);

        String tasksWord = tasksList.getTasksCount() == 1 ? " task " : " tasks ";

        String successMessage = "Noted. I've removed this task:" +
                System.lineSeparator() +
                removedTask +
                System.lineSeparator() +
                "Now you have " + tasksList.getTasksCount() + tasksWord + "in the list.";

        ui.printLines(successMessage);

        storage.writeToFile(tasksList);
    }
}
