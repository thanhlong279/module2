package demo;

import java.util.Arrays;

public class Student {
    private int[] soDo3;

    public int[] getSoDo3() {
//        sao chep ra mang moi
//        tra luon ve mang cu
        int x[] = new int[soDo3.length];
        for (int i = 0; i < soDo3.length; i++) {
            x[i] = soDo3[i];
        }
        return x;
    }

    public Student(int[] soDo3, int id, String name) {
        this.soDo3 = soDo3;
        this.id = id;
        this.name = name;
    }

    public void setSoDo3(int[] soDo3) {
        this.soDo3 = soDo3;
    }

    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "soDo3=" + Arrays.toString(soDo3) +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
