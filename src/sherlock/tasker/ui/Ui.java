package ui;

import data.TasksList;
import tasks.Task;

import java.util.Scanner;

public class Ui {
    static final String DIVIDER = "--------------------------------------------------------------------";

    public void printLines(String... lines) {
        System.out.println(DIVIDER);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println(DIVIDER + System.lineSeparator());
    }

    public void printAddedTask(Task task, TasksList tasksList) {
        String tasksWord = tasksList.getTasksCount() == 1 ? " task" : " tasks";
        final String FIRST_SENTENCE = "Got it. I've added this task:";
        final String SECOND_SENTENCE = "Now you have " + tasksList.getTasksCount() + tasksWord + " in the list.";
        printLines(FIRST_SENTENCE + System.lineSeparator() + task + System.lineSeparator() + SECOND_SENTENCE);
    }
    public void showWelcome() {
        String logo =
                "   _____ __  ____________  __    ____  ________ __\n" +
                        "  / ___// / / / ____/ __ \\/ /   / __ \\/ ____/ //_/\n" +
                        "  \\__ \\/ /_/ / __/ / /_/ / /   / / / / /   / ,<   \n" +
                        " ___/ / __  / /___/ _, _/ /___/ /_/ / /___/ /| |  \n" +
                        "/____/_/ /_/_____/_/ |_/_____/\\____/\\____/_/ |_|  ";


        printLines("Hello from", logo);

        printLines("Hello! I'm SHERLOCK", "What can I do for you?");
    }

    public String readCommand() {
        Scanner in = new Scanner(System.in);

        String fullCommand = in.nextLine();

        return fullCommand;
    }

    public void showError(String message) {
        printLines(message);
    }

    public void showLoadingSuccessful() {
        printLines("tasks contents are successfully loaded");
    }
}
