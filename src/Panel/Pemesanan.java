package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Process.Menu;
import Process.Pesanan;

public class Pemesanan {
    private JTextField input;
    private JButton inputButton;
    private JTextPane textPane;
    private JPanel mainPanel;
    private JTextField jumlahPemesanan;
    private JButton selesaiButton;
    private JPanel contentPane;

    public Pemesanan(JPanel panel) {
        contentPane = panel;
        panel.setPreferredSize(panel.getPreferredSize());
        textPane.setText(setTextPanel());
        contentPane.add(mainPanel, "Pemesanan");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                Pesanan pesanan = new Pesanan();

                String[][] daftarMenu = Menu.daftarMenu;

                if(input.getText().isEmpty() || jumlahPemesanan.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Input tidak boleh kosong");
                    return;
                }

                if(isAlpha(input.getText()) || isAlpha(input.getText())) {
                    JOptionPane.showMessageDialog(null, "Silahkan input dengan format angka");
                    return;
                }


                if(!(Integer.parseInt(input.getText()) >= 0 && Integer.parseInt(input.getText()) < daftarMenu.length)) {
                    JOptionPane.showMessageDialog(null, "Input tidak sesuai");
                    return;
                }

                Integer[] menuPilihan = new Integer[] {Integer.parseInt(input.getText()), Integer.parseInt(jumlahPemesanan.getText())};

                pesanan.setPesanan(menuPilihan);

                new Pemesanan(contentPane);
                cardLayout.show(contentPane, "Pemesanan");
                return;

            }
        });
        selesaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                if(Pesanan.daftarPesanan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Silahkan input pesanan terlebih dahulu");
                    return;
                }
                new Pembayaran(contentPane);
                cardLayout.show(contentPane, "Pembayaran");

            }
        });
    }

    public String setTextPanel() {
        Pesanan pesananClass = new Pesanan();
        Menu menuClass = new Menu();
        String result = "";
        String menuString = showMenu();

        result = menuString;

        result = result + "\n Silahkan pilih nomor yang ada disamping menu untuk" +
                " memilih pesanan\n atau masukan 'selesai' untuk melanjutkan " +
                "ke pembayaran";

        result = result + "\n\nPesanan\n";

        ArrayList<Integer[]> pesanans = pesananClass.daftarPesanan;

        int counterPesanan = 1;
        if(pesanans.size() > 0) {
            for (Integer[] pesanan : pesanans) {
                result = result + counterPesanan + ". " + menuClass.daftarMenu[pesanan[0]][0] + " - jumlah pesanan: " + pesanan[1] + "\n";
                counterPesanan++;
            }
        }


        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }



    public String showMenu() {
        Menu menuClass = new Menu();
        String[][] menus = menuClass.daftarMenu;
        String result = "";

//        Iterate makanan
        result = result + "Makanan\n";

        if(menus.length > 0) {
            for (int i=0; i< menus.length; i++ ) {
                if(menus[i][1] == "Makanan") {
                    result = result + i + ". " + menus[i][0] + " | " + menus[i][2] + "\n";
                }
            }
        }

        //        iterate minuman
        result = result + "\nMinuman\n";
        if(menus.length > 0) {
            for (int i=0; i < menus.length; i++) {
                if(menus[i][1] == "Minuman") {
                    result = result + i + ". " + menus[i][0] + " | " + menus[i][2] + "\n";
                }
            }
        }

        return result;

    }

}
