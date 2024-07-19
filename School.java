import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {
    private List<Student> students;
    private List<Staff> staff;
    private List<String> classes;

    public School() {
        students = new ArrayList<>();
        staff = new ArrayList<>();
        classes = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
    }

    public void addClass(String className) {
        classes.add(className);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void removeStaff(int id) {
        staff.removeIf(staffMember -> staffMember.getId() == id);
    }
}
