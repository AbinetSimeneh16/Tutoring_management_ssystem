package model;

public class Schedule {

    private String student;
    private String subject;
    private String day;
    private String time;

    public Schedule(String student, String subject, String day, String time) {
        this.student = student;
        this.subject = subject;
        this.day = day;
        this.time = time;
    }

    @Override
    public String toString() {
        return student + "," + subject + "," + day + "," + time;
    }

    public static Schedule fromString(String line) {
        String[] p = line.split(",");
        return new Schedule(p[0], p[1], p[2], p[3]);
    }
}

