package exmenu;

import exmenu.MenuItem;
import exmenu.MenuFetcher;
import exmenu.MenuDetailPanel;
import exmenu.MenuListPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("메뉴 설명 페이지");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        try {
            List<MenuItem> menuItems = MenuFetcher.fetchMenuItems();
            MenuDetailPanel detailPanel = new MenuDetailPanel();

            MenuListPanel listPanel = new MenuListPanel(menuItems, detailPanel::updateDetail);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, detailPanel);
            splitPane.setDividerLocation(250);
            add(splitPane);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "메뉴 데이터를 불러올 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
