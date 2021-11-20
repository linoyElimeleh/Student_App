package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model() {
        for (int i = 0; i < 10; i++) {
            Student s = new Student("name " + i, "" + i, false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }
}
