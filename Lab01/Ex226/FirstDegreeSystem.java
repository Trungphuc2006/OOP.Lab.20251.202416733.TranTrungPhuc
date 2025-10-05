package Ex226;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FirstDegreeSystem extends JFrame {
    private JTextField aField, bField, cField, dField, eField, fField;
    private JLabel resultLabel;
    public FirstDegreeSystem() {
        setTitle("2x2 Linear Equation Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));
        add(new JLabel("Equation 1: ax + by = c"));
        add(new JLabel(""));
        add(new JLabel("a:"));
        aField = new JTextField();
        add(aField);
        add(new JLabel("b:"));
        bField = new JTextField();
        add(bField);
        add(new JLabel("c:"));
        cField = new JTextField();
        add(cField);
        add(new JLabel("Equation 2: dx + ey = f"));
        add(new JLabel(""));
        add(new JLabel("d:"));
        dField = new JTextField();
        add(dField);
        add(new JLabel("e:"));
        eField = new JTextField();
        add(eField);
        add(new JLabel("f:"));
        fField = new JTextField();
        add(fField);
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquations();
            }
        });
        add(solveButton);
        resultLabel = new JLabel("Solution will appear here");
        add(resultLabel);
        setVisible(true);
    }
    private void solveEquations() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            double d = Double.parseDouble(dField.getText());
            double e = Double.parseDouble(eField.getText());
            double f = Double.parseDouble(fField.getText());
            double det = a * e - b * d;
            if (Math.abs(det) < 1e-10) { 
                if (Math.abs(a * f - c * d) < 1e-10 && Math.abs(b * f - c * e) < 1e-10) {
                    resultLabel.setText("Infinite solutions");
                } else {
                    resultLabel.setText("No solution");
                }
                return;
            }
            double x = (c * e - b * f) / det;
            double y = (a * f - c * d) / det;
            resultLabel.setText(String.format("Solution: x = %.2f, y = %.2f", x, y));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirstDegreeSystem();
            }
        });
    }
}