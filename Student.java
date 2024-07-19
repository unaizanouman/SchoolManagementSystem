import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int id;
    private String enrolledClass;

    public Student(String name, int id, String enrolledClass) {
        this.name = name;
        this.id = id;
        this.enrolledClass = enrolledClass;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEnrolledClass() {
        return enrolledClass;
    }

    public void setEnrolledClass(String enrolledClass) {
        this.enrolledClass = enrolledClass;
    }
}
