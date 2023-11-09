package Process;

import java.util.Arrays;

public class Menu {
    public static String[][] daftarMenu = {
            {"Ikan bakar", "Makanan", "38000"},
            {"Ayam Goreng", "Makanan", "20000"},
            {"Es Teh Manis", "Minuman", "5000"},
            {"Cendol", "Minuman", "10000"},
    };

    public String[][] getMenus() {
        return daftarMenu;
    }


    public void addToMenu(String[] value) {
        String[][] menu = new String[daftarMenu.length + 1][];

        System.arraycopy(daftarMenu, 0, menu, 0, daftarMenu.length);

        String[] newElement = value;

        menu[daftarMenu.length] = newElement;

        daftarMenu = menu;
    }
}
