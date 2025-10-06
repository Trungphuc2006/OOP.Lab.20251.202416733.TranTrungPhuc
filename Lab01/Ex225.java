import javax.swing.*;
import java.awt.*;
public class Ex225 extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JButton sumButton, diffButton, prodButton, quotButton;
    public Ex225() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        setSize(300, 250);
        JLabel num1Label = new JLabel("First Number:");
        num1Field = new JTextField(10);
        JLabel num2Label = new JLabel("Second Number:");
        num2Field = new JTextField(10);
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        sumButton = new JButton("Sum");
        diffButton = new JButton("Difference");
        prodButton = new JButton("Product");
        quotButton = new JButton("Quotient");
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(sumButton);
        add(diffButton);
        add(prodButton);
        add(quotButton);
        sumButton.addActionListener(e -> calculate("sum"));
        diffButton.addActionListener(e -> calculate("difference"));
        prodButton.addActionListener(e -> calculate("product"));
        quotButton.addActionListener(e -> calculate("quotient"));
        setLocationRelativeTo(null);
    }
    private void calculate(String operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            switch (operation) {
                case "sum":
                    result = num1 + num2;
                    break;
                case "difference":
                    result = num1 - num2;
                    break;
                case "product":
                    result = num1 * num2;
                    break;
                case "quotient":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ex225 calculator = new Ex225();
            calculator.setVisible(true);
        });
    }
}