package lab2;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient {


    private List<Teacher> teachers = new ArrayList<>();
    private String emailAddress;

    public Faculty(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}
