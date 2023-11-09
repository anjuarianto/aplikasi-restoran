package Panel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JPanel contentPane;
    private MenuPanel menuPanel;
    private MainPanel mainPanel;
    private InputMenu inputMenu;
    private Pemesanan pemesanan;
    private Pembayaran pembayaran;

    public MainFrame() {
        JFrame frame = new JFrame();
        contentPane = new JPanel();
        frame.getContentPane().add(contentPane);

        contentPane.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());

        mainPanel = new MainPanel(contentPane);
        menuPanel = new MenuPanel(contentPane);
        inputMenu = new InputMenu(contentPane);
        pemesanan = new Pemesanan(contentPane);
        pembayaran = new Pembayaran(contentPane);

        frame.setSize(700,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new MainFrame();
    }

}
