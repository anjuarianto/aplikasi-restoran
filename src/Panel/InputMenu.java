package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Process.Menu;

public class InputMenu extends JPanel {
    private JTextField nama;
    private JTextField harga;
    private JComboBox kategori;
    private JButton button1;
    private JPanel contentPane;
    private JPanel mainPanel;

    public InputMenu(JPanel panel) {
        JLabel combotext = new JLabel();
        contentPane = panel;
        kategori.add(combotext);
        contentPane.add(mainPanel, "Input Menu");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nama.getText().equals("") || harga.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                    return;
                }
                addToMenu();
                nama.setText("");harga.setText("");
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Menu Panel");
            }
        });
    }

    public void addToMenu() {
        String[] value = {String.valueOf(nama.getText()), kategori.getSelectedItem().toString(), String.valueOf(harga.getText())};
        Menu menu = new Menu();
        menu.addToMenu(value);

        new MenuPanel(contentPane);
    }
}
