import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Age Calculator App");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel prompoLabel = new JLabel("Enter your birthdate (YYYY-MM-DD): ");

        JTextField birthDateField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate Age");

        JLabel ageLabel = new JLabel("Your age is ");

        panel.add(prompoLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(ageLabel);

        frame.add(panel);

        frame.setSize(300, 200);

        frame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String birthDateInput = birthDateField.getText();

                try {
                    LocalDate birthDate = LocalDate.parse(birthDateInput);
                    LocalDate currentDate = LocalDate.now();
                    Period age = Period.between(birthDate, currentDate);
                    int years = age.getYears();

                    ageLabel.setText("Your age is " + years);
                } catch (Exception ex) {
                    ageLabel.setText("Invalid date format. Please enter date in YYYY-MM-DD format.");
                    return;
                }
            }
        });
    }
}