import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SchoolManagementSystem {
    private SchoolController ctrl;
    private JFrame frame;
    private JTextField studentNameInput, studentIdInput, classNameInput;
    private JTextField staffNameInput, staffIdInput, positionInput;
    private JTextField classInput, removeStudentInput, removeStaffInput;

    public SchoolManagementSystem() {
        School school = new School();
        ctrl = new SchoolController(school);

        frame = new JFrame("School Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        int row = 0;

        // Enroll Student Section
        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(new JLabel("Student Name:"), gbc);

        gbc.gridx = 1;
        frame.add(studentNameInput = new JTextField(15), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        frame.add(new JLabel("Student ID:"), gbc);

        gbc.gridx = 1;
        frame.add(studentIdInput = new JTextField(5), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        frame.add(new JLabel("Class:"), gbc);

        gbc.gridx = 1;
        frame.add(classNameInput = new JTextField(5), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        JButton enrollStudentButton = new JButton("Enroll Student");
        enrollStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enrollStudent();
                clearStudentForm();
            }
        });
        frame.add(enrollStudentButton, gbc);

        row++;

        // Add Staff Section
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        frame.add(new JLabel("Staff Name:"), gbc);

        gbc.gridx = 1;
        frame.add(staffNameInput = new JTextField(15), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        frame.add(new JLabel("Staff ID:"), gbc);

        gbc.gridx = 1;
        frame.add(staffIdInput = new JTextField(5), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        frame.add(new JLabel("Position:"), gbc);

        gbc.gridx = 1;
        frame.add(positionInput = new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        JButton addStaffButton = new JButton("Add Staff");
        addStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStaff();
                clearStaffForm();
            }
        });
        frame.add(addStaffButton, gbc);

        row++;

        // Add Class Section
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        frame.add(new JLabel("Class Name:"), gbc);

        gbc.gridx = 1;
        frame.add(classInput = new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        JButton addClassButton = new JButton("Add Class");
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass(classInput.getText());
                classInput.setText("");
            }
        });
        frame.add(addClassButton, gbc);

        row++;

        // Remove Student Section
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        frame.add(new JLabel("Remove Student ID:"), gbc);

        gbc.gridx = 1;
        frame.add(removeStudentInput = new JTextField(5), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        JButton removeStudentButton = new JButton("Remove Student");
        removeStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent(Integer.parseInt(removeStudentInput.getText()));
                removeStudentInput.setText("");
            }
        });
        frame.add(removeStudentButton, gbc);

        row++;

        // Remove Staff Section
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        frame.add(new JLabel("Remove Staff ID:"), gbc);

        gbc.gridx = 1;
        frame.add(removeStaffInput = new JTextField(5), gbc);

        gbc.gridx = 0;
        gbc.gridy = ++row;
        gbc.gridwidth = 2;
        JButton removeStaffButton = new JButton("Remove Staff");
        removeStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStaff(Integer.parseInt(removeStaffInput.getText()));
                removeStaffInput.setText("");
            }
        });
        frame.add(removeStaffButton, gbc);

        row++;

        // Save School Data
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        JButton saveSchoolButton = new JButton("Save School Data");
        saveSchoolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSchoolData();
            }
        });
        frame.add(saveSchoolButton, gbc);

        row++;

        // Display Enrolled People
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        JButton displayEnrolledButton = new JButton("Display Enrolled People");
        displayEnrolledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEnrolledPeople();
            }
        });
        frame.add(displayEnrolledButton, gbc);

        frame.setVisible(true);
    }

    private void enrollStudent() {
        String name = studentNameInput.getText();
        int id = Integer.parseInt(studentIdInput.getText());
        String className = classNameInput.getText();
        ctrl.enrollStudent(name, id, className);
    }

    private void clearStudentForm() {
        studentNameInput.setText("");
        studentIdInput.setText("");
        classNameInput.setText("");
    }

    private void addStaff() {
        String name = staffNameInput.getText();
        int id = Integer.parseInt(staffIdInput.getText());
        String position = positionInput.getText();
        ctrl.addStaff(name, id, position);
    }

    private void clearStaffForm() {
        staffNameInput.setText("");
        staffIdInput.setText("");
        positionInput.setText("");
    }

    private void addClass(String className) {
        ctrl.addClass(className);
    }

    private void removeStudent(int id) {
        ctrl.removeStudent(id);
    }

    private void removeStaff(int id) {
        ctrl.removeStaff(id);
    }

    private void saveSchoolData() {
        try {
            FileHandler.saveSchoolToFile(ctrl.getSchool(), "school_data.txt");
            JOptionPane.showMessageDialog(frame, "School data saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving school data: " + e.getMessage());
        }
    }

    private void displayEnrolledPeople() {
        try {
            School school = FileHandler.loadSchoolFromFile("school_data.txt");
            List<Student> students = school.getStudents();
            List<Staff> staff = school.getStaff();
            StringBuilder displayText = new StringBuilder();

            displayText.append("Enrolled Students:\n");
            for (Student student : students) {
                displayText.append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");
            }

            displayText.append("\nStaff Members:\n");
            for (Staff member : staff) {
                displayText.append(member.getName()).append(" (ID: ").append(member.getId()).append(", Position: ").append(member.getPosition()).append(")\n");
            }

            JTextArea textArea = new JTextArea(displayText.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(frame, scrollPane, "Enrolled People", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Error loading school data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchoolManagementSystem();
            }
        });
    }
}
