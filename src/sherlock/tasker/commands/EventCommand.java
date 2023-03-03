package commands;

import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import tasks.Event;
import ui.Ui;

/**
 * Represents "event" command - creates event task when executed
 */
public class EventCommand extends Command {
    String name;
    String from;
    String to;

    /**
     * @param name
     * @param from
     * @param to
     */
    public EventCommand(String name, String from, String to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) throws SherlockException {

        Event event = new Event(this.name, false, this.from, this.to);
        tasksList.addTask(event);

        ui.printAddedTask(event, tasksList);

        storage.writeToFile(tasksList);
    }

}
