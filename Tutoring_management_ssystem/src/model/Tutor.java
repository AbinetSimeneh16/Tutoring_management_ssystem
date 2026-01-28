package model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends User {

    private String subject;
    private List<Schedule> schedules;

    public Tutor(String username, String password, String subject) {
        super(username, password);
        this.subject = subject;
        this.schedules = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
}


