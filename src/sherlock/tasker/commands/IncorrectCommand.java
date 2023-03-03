package commands;

import data.TasksList;
import storage.Storage;
import ui.Ui;

public class IncorrectCommand extends Command {
    String feedback;

    public IncorrectCommand(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute(TasksList tasksList, Ui ui, Storage storage) {
        ui.printLines(feedback);
    }
}
