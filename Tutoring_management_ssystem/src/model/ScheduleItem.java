package model;

public class ScheduleItem {

    private String studentName;
    private String subject;
    private String day;
    private String time;

    public ScheduleItem(String studentName, String subject, String day, String time) {
        this.studentName = studentName;
        this.subject = subject;
        this.day = day;
        this.time = time;
    }

    @Override
    public String toString() {
        return studentName + " | " + subject + " | " + day + " | " + time;
    }
}

