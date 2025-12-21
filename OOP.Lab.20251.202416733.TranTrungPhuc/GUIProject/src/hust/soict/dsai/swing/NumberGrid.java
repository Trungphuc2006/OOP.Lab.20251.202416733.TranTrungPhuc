package hust.soict.dsai.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;
    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));  
        addButtons(panelButtons);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 400);  
        setVisible(true);
    }
    void addButtons(JPanel panel) {
        ButtonListener listener = new ButtonListener(); 
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].addActionListener(listener);
            panel.add(btnNumbers[i]);
        }

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);   
        panel.add(btnNumbers[0]);

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);         

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);            
        panel.add(btnReset);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + command);
            }
            else if (command.equals("DEL")) {
                String current = tfDisplay.getText();
                if (current.length() > 0) {
                    tfDisplay.setText(current.substring(0, current.length() - 1));
                }
            }
            else if (command.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }
}