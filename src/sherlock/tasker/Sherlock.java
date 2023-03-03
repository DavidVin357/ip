import commands.Command;
import parser.Parser;
import data.TasksList;
import data.exceptions.SherlockException;
import storage.Storage;
import ui.Ui;

/**
 * Core class of the Sherlock program
 */
public class Sherlock {
    private Storage storage;
    private TasksList tasksList;
    private Ui ui;

    /**
     *
     * @param filePath
     */
    public Sherlock(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasksList = storage.loadTasks(ui);
            ui.showLoadingSuccessful();
        } catch (SherlockException e) {
            ui.showError(e.getMessage());
            tasksList = new TasksList();
        }
    }

    /**
     * Runs a Sherlock program
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Parser parser = new Parser();
                Command c = parser.parse(fullCommand);
                c.execute(tasksList, ui, storage);
                isExit = c.isExit();
            } catch (SherlockException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Entry point - starts the Sherlock program
     * @param args
     */
    public static void main(String[] args) {
        new Sherlock("data/tasks.txt").run();
    }

}
