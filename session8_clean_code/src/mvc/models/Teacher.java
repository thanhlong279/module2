package mvc.models;

public class Teacher extends Person{
    private String subject;

    public Teacher(){
    }

    public Teacher(int code, String name, String address, String subject) {
        super(code, name, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
