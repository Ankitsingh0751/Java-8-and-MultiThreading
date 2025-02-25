package org.example.collectionframework;

public class Students {
    private String name;
    private double gpa;

    public Students(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
