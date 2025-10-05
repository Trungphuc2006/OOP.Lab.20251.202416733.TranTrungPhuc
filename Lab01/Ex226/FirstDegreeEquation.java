package Ex226;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FirstDegreeEquation extends JFrame {
    private JTextField aField, bField, resultField;
    private JButton solveButton, clearButton;
    public FirstDegreeEquation() {
        setTitle("Linear Equation Solver (ax + b = 0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));
        JLabel aLabel = new JLabel("Coefficient a:");
        aField = new JTextField(10);
        JLabel bLabel = new JLabel("Coefficient b:");
        bField = new JTextField(10);
        JLabel resultLabel = new JLabel("Solution:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        solveButton = new JButton("Solve");
        clearButton = new JButton("Clear");
        add(aLabel);
        add(aField);
        add(bLabel);
        add(bField);
        add(resultLabel);
        add(resultField);
        add(solveButton);
        add(clearButton);
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }
    private void solveEquation() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            if (a == 0) {
                if (b == 0) {
                    resultField.setText("Infinite solutions");
                } else {
                    resultField.setText("No solution");
                }
            } else {
                double x = -b / a;
                resultField.setText(String.format("x = %.2f", x));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers for a and b", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearFields() {
        aField.setText("");
        bField.setText("");
        resultField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstDegreeEquation().setVisible(true);
            }
        });
    }
}