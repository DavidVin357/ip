package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Todo;
import ui.Ui;

/**
 * Represents "todo" command - creates todo task when executed
 */
public class TodoCommand extends Command {
    String name;

    /**
     * @param arguments
     */
    public TodoCommand(String arguments) {
        this.name = arguments;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {
        Todo todo = new Todo(name, false);
        tasksList.addTask(todo);

        ui.printAddedTask(todo, tasksList);

        storage.writeToFile(tasksList);
    }
}
