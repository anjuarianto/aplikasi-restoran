package Panel;

import javax.swing.*;
import Process.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MenuPanel extends JPanel {
    private JTextField inputField;
    private JButton inputButton;
    private JTextPane textArea;
    private JLabel inputLabel;
    private JPanel mainPanel;
    private JPanel contentPane;
    public MenuPanel(JPanel panel) {
        contentPane = panel;
        inputLabel.setText("Input");
        textArea.setText(setTextPanel());
        contentPane.add(mainPanel, "Menu Panel");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                switch (inputField.getText()) {
                    case "1":
                        cardLayout.show(contentPane, "Input Menu");
                        break;
                    case "0":
                        cardLayout.show(contentPane, "Main Panel");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Silahkan masukan input yang sesuai");
                }
                inputField.setText("");
            }

        });
    }

    public String setTextPanel() {
        Menu menuClass = new Menu();
        String[][] menus = menuClass.daftarMenu;
        String result = "";

//        Iterate makanan
        result = result + "Makanan\n";

        if(menus.length > 0) {
            for (int i=0; i< menus.length; i++ ) {
                if(menus[i][1] == "Makanan") {
                    result = result + "- " + menus[i][0] + " | " + menus[i][2] + "\n";
                }
            }
        }

        //        iterate minuman
        result = result + "\nMinuman\n";
        if(menus.length > 0) {
            for (int i=0; i < menus.length; i++) {
                if(menus[i][1] == "Minuman") {
                    result = result + "- " + menus[i][0] + " | " + menus[i][2] + "\n";
                }
            }
        }


        result = result + "\n1. Tambah Menu\n0.Kembali";

        return result;

    }


}
