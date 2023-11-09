package Process;

import java.util.ArrayList;

public class Pesanan {
    public static ArrayList<Integer[]> daftarPesanan = new ArrayList<>();


    public void setPesanan(Integer[] value) {
        String[][] daftarMenu = Menu.daftarMenu;

        daftarPesanan.add(new Integer[]{value[0], value[1], Integer.parseInt(daftarMenu[value[0]][2])});
    }
}
