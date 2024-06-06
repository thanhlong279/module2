package mvc_person.model;

public class Student extends Person{
    private String classroom;

    public Student(Student student){
    }


    public Student(int id, String name, String address, String classroom) {
        super(id, name, address);
        this.classroom = classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString()+
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
