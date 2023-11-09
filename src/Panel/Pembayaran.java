package Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Process.Pesanan;

public class Pembayaran extends JPanel {
    private JTextField input;
    private JButton inputButton;
    private JTextPane textPane;
    private JPanel mainPanel;
    private JPanel contentPane;


    public Pembayaran(JPanel panel) {
        contentPane = panel;
        panel.setPreferredSize(panel.getPreferredSize());
        textPane.setText(setTextPanel());
        contentPane.add(mainPanel, "Pembayaran");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public String setTextPanel() {
        ArrayList<Integer[]> pesanans = Pesanan.daftarPesanan;
        String result = "Total pesanan anda adalah sekian: \n";
        int numberingPesanan = 1;
        for (Integer[] pesanan: pesanans) {
            result = result + numberingPesanan + ". " + pesanan[0] + " - " + pesanan[2] + "\n";
            numberingPesanan++;
        }
        return result;
    }
}
