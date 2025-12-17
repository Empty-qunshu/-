package org.example.sqlclassroom.entity;

public class Classroom {
    private int classroomId;
    private String classroomName;
    private int classroomPeople;

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getClassroomPeople() {
        return classroomPeople;
    }

    public void setClassroomPeople(int classroomPeople) {
        this.classroomPeople = classroomPeople;
    }
}
