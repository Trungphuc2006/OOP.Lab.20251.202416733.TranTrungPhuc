package Ex226;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SecondDegreeEquation extends JFrame {
    private JTextField aField, bField, cField;
    private JLabel resultLabel;
    public SecondDegreeEquation() {
        setTitle("Quadratic Equation Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));
        add(new JLabel("Equation: ax² + bx + c = 0"));
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
        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
        add(solveButton);
        resultLabel = new JLabel("Solution will appear here");
        add(resultLabel);
        setVisible(true);
    }
    private void solveEquation() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            if (Math.abs(a) < 1e-10) {
                resultLabel.setText("Error: 'a' cannot be zero");
                return;
            }
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                resultLabel.setText(String.format("Roots: x₁ = %.2f, x₂ = %.2f", root1, root2));
            } else if (Math.abs(discriminant) < 1e-10) {
                double root = -b / (2 * a);
                resultLabel.setText(String.format("One root: x = %.2f", root));
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
                resultLabel.setText(String.format("Complex roots: x = %.2f ± %.2fi", realPart, imaginaryPart));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SecondDegreeEquation();
            }
        });
    }
}