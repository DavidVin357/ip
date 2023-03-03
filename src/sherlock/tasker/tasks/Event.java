package tasks;

import data.exceptions.SherlockException;
import parser.Parser;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private LocalDateTime from;
    private LocalDateTime to;
    public Event(String name, Boolean isDone, String from, String to) throws SherlockException{
        super(name, isDone);
        this.from = Parser.parseDateTime(from);
        this.to = Parser.parseDateTime(to);
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String toString() {
        String from = this.from.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
        String to = this.to.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));

        return "[E]" + super.toString() + " (" + "from: " + from + "; to: " + to + ")";
    }

    @Override
    public String getFileFormatString() throws SherlockException {
        try {
            return String.format("%s | %d | %s | %s | %s",
                    this.getType(),
                    this.isDone ? 1 : 0,
                    this.name,
                    this.from.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                    this.to.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        } catch (DateTimeException e) {
            throw new SherlockException("event dateTime arguments cannot be formatted");
        }
    }
}
