package tasks;

import data.exceptions.SherlockException;

public class Task {
    protected String name;
    protected Boolean isDone;


    public Task (String name, Boolean isDone) throws SherlockException{
        if (name.isEmpty()) {
            throw new SherlockException("Name argument cannot be empty");
        }
        this.name = name;
        this.isDone = isDone;
    }


    public String getType() {
        return "TASK";
    }
    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    public String toString() {
        String checker = this.isDone ? "[X]" : "[ ]";
        return checker + " " + this.name;
    }

    public String getFileFormatString() throws SherlockException {
        return String.format("%s | %d | %s", getType(), isDone ? 1 : 0, name);
    }
}
