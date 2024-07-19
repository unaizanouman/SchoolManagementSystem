import java.util.List;

public class SchoolController {
    private School school;

    public SchoolController(School school) {
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void enrollStudent(String name, int id, String className) {
        Student student = new Student(name, id, className);
        school.addStudent(student);
    }

    public void addStaff(String name, int id, String position) {
        Staff staff = new Staff(name, id, position);
        school.addStaff(staff);
    }

    public void addClass(String className) {
        school.addClass(className);
    }

    public void removeStudent(int id) {
        school.removeStudent(id);
    }

    public void removeStaff(int id) {
        school.removeStaff(id);
    }

    public List<Student> getAllStudents() {
        return school.getStudents();
    }

    public List<Staff> getAllStaff() {
        return school.getStaff();
    }

    public List<String> getAllClasses() {
        return school.getClasses();
    }
}
