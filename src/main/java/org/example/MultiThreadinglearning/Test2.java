package org.example.MultiThreadinglearning;

public class Test2 {
    public static void main(String[] args) {
        Student engineeringStudent = new Student() {
            @Override
            public String getBio(String name) {
                return name+ " is a Engineering Student";
            }
        };

        String bio = engineeringStudent.getBio("Ram");
        System.out.println(bio);
    }
}
