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
        panel.setPreferredSize(panel.getPreferredSize());
        inputLabel.setText("Input");
        textArea.setText(setTextPanel());
        contentPane.add(mainPanel, "Main Panel");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                switch (inputField.getText()) {
                    case "1":
                        new MenuPanel(contentPane);
                        cardLayout.show(contentPane, "Menu Panel");
                        break;
                    case "2":
                        new Pemesanan(contentPane);
                        cardLayout.show(contentPane, "Pemesanan");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Silahkan masukan input yang sesuai");
                }
                inputField.setText("");
            }
        });
    }

    public String setTextPanel() {
        return "Main Menu: \n" +
                "1. Tampilkan Menu \n" +
                "2. Pesan";
    }

}
