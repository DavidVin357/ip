package tasks;

import data.exceptions.SherlockException;
import parser.Parser;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Represents Deadline task
 */
public class Deadline extends Task {

    private LocalDateTime by;
    /**
     *
     * @param name
     * @param isDone
     * @param by deadline date (dd-MM-yyyy HH:mm)
     */
    public Deadline(String name, Boolean isDone, String by) throws SherlockException{
        super(name, isDone);
        this.by = Parser.parseDateTime(by);
    }

    /**
     * @return String representation of the Deadline type
     */
    @Override
    public String getType() {
        return "D";
    }

    /**
     *
     * @return String representation of the deadline for the CLI output
     */
    public String toString() {
        String by = this.by.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
        return "[D]" + super.toString() + " (" + "by: " + by + ")";
    }

    /**
     *
     * @return String representation of the deadline for the file output
     */
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
