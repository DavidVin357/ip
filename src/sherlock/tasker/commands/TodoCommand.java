package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Todo;
import ui.Ui;

public class TodoCommand extends Command {
    String name;

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
