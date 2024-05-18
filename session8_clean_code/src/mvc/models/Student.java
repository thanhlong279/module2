package mvc.models;

public class Student extends Person{
    private String classRoom;

    public Student(){
    }

    public Student(int code, String name, String address, String classRoom) {
        super(code, name, address);
        this.classRoom = classRoom;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    @Override
    public String toString() {
        return "Code: " + super.getCode() +
                ", Name: " + super.getName() +
                ", Address: " + super.getAddress() +
                ", Classroom: " + this.classRoom;
    }
}
