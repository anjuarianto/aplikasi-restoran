package Panel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JPanel contentPane;
    private MenuPanel menuPanel;
    private MainPanel mainPanel;
    public MainFrame() {
        JFrame frame = new JFrame();
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        contentPane.setLayout(new CardLayout());
        mainPanel = new MainPanel(contentPane);
        menuPanel = new MenuPanel(contentPane);
        contentPane.add(mainPanel, "Panel 1");
        contentPane.add(menuPanel, "Panel 2");
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new MainFrame();
    }

}
