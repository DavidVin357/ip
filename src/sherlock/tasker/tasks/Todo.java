package tasks;

import data.exceptions.SherlockException;

public class Todo extends Task{

    public Todo(String name, Boolean isDone) throws SherlockException {
        super(name, isDone);
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String getFileFormatString() {
        return String.format("%s | %d | %s",
                this.getType(),
                this.isDone ? 1 : 0,
                this.name
        );
    }
}
