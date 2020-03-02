package lab2;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String groupId;
    private List<Double> grades = new ArrayList<>();

    public Student(String firstName, String lastName, String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getGradesAverage() {
        return grades.stream()
                .mapToDouble(num -> num)
                .average().orElse(0);
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
