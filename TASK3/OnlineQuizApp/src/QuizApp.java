import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

public class QuizApp extends JFrame {
    private QuizDatabase quizDatabase;
    private List<QuizQuestion> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private ButtonGroup buttonGroup;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public QuizApp() {
        quizDatabase = new QuizDatabase();
        questions = quizDatabase.getQuestions();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setTitle("Quiz App");

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        getContentPane().add(cardPanel);

        showQuestionPanel();

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNextButtonClick();
            }
        });

        cardPanel.add(nextButton);  // Add the "Next" button to cardPanel

        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void showQuestionPanel() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel questionLabel = new JLabel(currentQuestion.getQuestionText());
            panel.add(questionLabel);

            buttonGroup = new ButtonGroup();
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                JRadioButton radioButton = new JRadioButton(currentQuestion.getOptions()[i]);
                radioButton.setActionCommand(Integer.toString(i));  // Set the index as the action command
                buttonGroup.add(radioButton);
                panel.add(radioButton);
            }

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleSubmission(currentQuestion);
                }
            });
            panel.add(submitButton);

            cardPanel.add(panel,"Question" + currentQuestionIndex);
            cardLayout.show(cardPanel, "Question" + currentQuestionIndex);
        } else {
            displayResult();
        }
    }


    private void handleNextButtonClick() {
        if (currentQuestionIndex < questions.size()) {
            currentQuestionIndex++;
            showQuestionPanel();
        } else {
            displayResult();
        }
    }

    private void handleSubmission(QuizQuestion currentQuestion) {
        if (buttonGroup != null) {
            ButtonModel selectedOption = null;
            for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    selectedOption = button.getModel();
                    break;
                }
            }

            if (selectedOption != null) {
                String actionCommand = selectedOption.getActionCommand();

                if (actionCommand != null && !actionCommand.isEmpty()) {
                    try {
                        int selectedOptionIndex = Integer.parseInt(actionCommand);

                        if (currentQuestion.getCorrectOptionIndex() == selectedOptionIndex) {
                            score++;
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select an option before submitting.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an option before submitting.");
                return;
            }

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    handleNextButtonClick();
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Please select an option before submitting.");
        }
    }

    private void displayResult() {
        JOptionPane.showMessageDialog(this, "Quiz completed! Your score: " + score + "/" + questions.size());
        saveScoreToDatabase("username", score);
    }

    private void saveScoreToDatabase(String username, int score) {
        Connection connection = null;
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/quiz_db";
            String dbUsername = "your_username";
            String dbPassword = "your_password";

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db", "root", "Akhtar@123");

            String sql = "INSERT INTO quiz_scores (username, score) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, score);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApp();
            }
        });
    }
}
