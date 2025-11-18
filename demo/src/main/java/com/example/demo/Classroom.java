package com.example.demo;

public class Classroom {
    private String id;
    private String name;
    private int capacity;

    public Classroom(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
    public String getName() {
        return name;
    }
    public Classroom() {
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }




}
