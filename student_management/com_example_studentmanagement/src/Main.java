import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventListener;

public class Main  {

    public JFrame frame = null;
    public JTextField nameTextField = null;
    public JTextField ageTextField = null;
    public JTextField gradeTextField = null;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
             Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Name:"));
        nameTextField = new JTextField();
        panel.add(nameTextField);

        panel.add(new JLabel("Age:"));
        ageTextField = new JTextField();
        panel.add(ageTextField);

        panel.add(new JLabel("Grade:"));
        gradeTextField = new JTextField();
        panel.add(gradeTextField);

        JButton addButton = new JButton("Add Student");
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
    }
    private void addStudent() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nameTextField.getText());
                preparedStatement.setInt(2, Integer.parseInt(ageTextField.getText()));
                preparedStatement.setString(3, (gradeTextField.getText()));

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Student added successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error adding student. See console for details.");
        }
    }



}