package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private JTextField inputField;
    private JButton inputButton;
    private JTextPane textArea;
    private JLabel inputLabel;
    private JPanel mainPanel;
    private JPanel contentPane;
    public MainPanel(JPanel panel) {
        contentPane = panel;
        inputLabel.setText("Input");
        textArea.setText(setTextPanel());
        add(mainPanel);

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (inputField.getText()) {
                    case "1":
                        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.next(contentPane);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Silahkan masukan input yang sesuai");
                }
            }
        });
    }

    public String setTextPanel() {
        return "Main Menu: \n" +
                "1. Tampilkan Menu \n" +
                "2. Input Menu Baru";
    }
}
