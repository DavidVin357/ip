package tasks;

import data.exceptions.SherlockException;
import parser.Parser;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private LocalDateTime by;
    public Deadline(String name, Boolean isDone, String by) throws SherlockException{
        super(name, isDone);
        this.by = Parser.parseDateTime(by);
    }

    @Override
    public String getType() {
        return "D";
    }


    public String toString() {
        String by = this.by.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
        return "[D]" + super.toString() + " (" + "by: " + by + ")";
    }

    @Override
    public String getFileFormatString() throws SherlockException {
        try {
            return String.format("%s | %d | %s | %s",
                    this.getType(),
                    this.isDone ? 1 : 0,
                    this.name,
                    this.by.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
            );
        } catch (DateTimeException e) {
            throw new SherlockException("deadline /by argument cannot be formatted");
        }
    }
}
