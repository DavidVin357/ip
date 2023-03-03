package storage;

import data.TasksList;
import data.exceptions.SherlockException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;
import ui.Ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that loads tasks from the given file at the beginning
 * and writes tasks to the same file in the end
 */
public class Storage {
    private String filepath;
    /**
     * @param filepath
     */
    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * @param ui
     * @return list of tasks
     * @throws SherlockException
     */

    public TasksList loadTasks(Ui ui) throws SherlockException {
        TasksList tasksList = new TasksList();
        try {
            File f = new File(filepath);
            Scanner s = new Scanner(f);
            int lineIndex = 1;

            while(s.hasNext()) {
                String taskLine = s.nextLine();
                String[] arguments = taskLine.split("\\|");

                try {
                    Task task = loadTask(arguments);
                    tasksList.addTask(task);
                } catch (SherlockException e) {
                    // Show error and continue to the next line
                    ui.showError(e.getMessage() + " Line index is " + lineIndex);
                } finally {
                    lineIndex++;
                }
            }
        } catch (IOException e) {
            throw new SherlockException("Error when reading " + filepath + " file");
        }
        return tasksList;
    }
    private Task loadTask(String[] arguments) throws SherlockException {
        try {
            String taskType = arguments[0].trim();
            Boolean isDone = arguments[1].trim().equals("1");
            String name = arguments[2].trim();

            switch (taskType){
            case "TASK":
                return new Task(name, isDone);
            case "T":
                return new Todo(name, isDone);
            case "D":
                String by = arguments[3].trim();
                return new Deadline(name, isDone, by);
            case "E":
                String from = arguments[3].trim();
                String to = arguments[4].trim();
                return new Event(name, isDone, from, to);

            default:
                throw new SherlockException("An invalid task type is given.");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new SherlockException("Invalid line format given.");
        }
    }

    /**
     * Writes tasks to the given file
     * @param tasksList list of tasks
     * @throws SherlockException
     */
    public void writeToFile(TasksList tasksList) throws SherlockException {
        try {
            FileWriter fw = new FileWriter(this.filepath);

            StringBuilder output = new StringBuilder();

            ArrayList<Task> tasks = tasksList.getTasks();

//            Construct a file output
            for (Task task : tasks) {
                output.append(task.getFileFormatString()).append(System.lineSeparator());
            }

            fw.write(output.toString());
            fw.close();

        } catch (IOException e) {
            throw new SherlockException("Couldn't add a change to file " + filepath);
        }

    }
}
