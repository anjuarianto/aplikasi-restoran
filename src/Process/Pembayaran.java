package Process;

import java.util.ArrayList;

public class Pembayaran {
    public static float getTotalPesanan(ArrayList<Integer[]> semuaPesanan) {
        float totalPesanan = 0;
        for (Integer[] pesanan : semuaPesanan ) {
            totalPesanan = totalPesanan + (pesanan[2]*pesanan[1]);
        }

        return totalPesanan;
    }
    public static float getDiskon(ArrayList<Integer[]> semuaPesanan) {
        float totalDiskon;

        float totalPesanan = getTotalPesanan(semuaPesanan);

        if(totalPesanan < 100000) {
            return 0;
        }

        totalDiskon = totalPesanan*10/100;

        return totalDiskon;
    }

    public static float getPajakPelayanan(ArrayList<Integer[]> semuaPesanan) {
        float totalPesanan = getTotalPesanan(semuaPesanan);

        float pelayanan = 20000;
        float pajak = totalPesanan*10/100;

        return pelayanan+pajak;
    }

    public static float getGrandTotal(ArrayList<Integer[]> semuaPesanan) {
        float totalPesanan = getTotalPesanan(semuaPesanan);
        float diskon = getDiskon(semuaPesanan);
        float pajakPelayanan = getPajakPelayanan(semuaPesanan);

        return totalPesanan-diskon+pajakPelayanan;
    }


    public static float hitungDiskon(float subTotal) {
        float totalDiskon;

        System.out.println("Anda mendapatkan diskon sebesar 10% karena transaksi diatas Rp. 100,000");
        totalDiskon = subTotal*10/100;
        System.out.println("Diskon 10% : " + totalDiskon);
        System.out.println("------------------------------------------------------------");
        System.out.println("Subtotal Pesanan : " + (subTotal - totalDiskon));
        System.out.println("------------------------------------------------------------");

        return subTotal - totalDiskon;
    }

    public static float hitungPajak(float hargaTotalPesanan) {
        float pelayanan = 20000;
        float pajak = hargaTotalPesanan*10/100;
        float pajakPelayanan = pajak+pelayanan;
        System.out.println("Pajak 10% + Biaya Pelayanan : " + pajakPelayanan);
        System.out.println("------------------------------------------------------------");
        System.out.println("Grand Total : " + (hargaTotalPesanan+pajakPelayanan));

        return pajakPelayanan;
    }

    public static float hitungSemuaPesanan(ArrayList<Integer[]> semuaPesanan) {
        float hargaTotal = 0;
        int i = 1;

//        for (Integer[] pesanan : semuaPesanan ) {
//            String[] dataOrder = Menu.getMenus()[pesanan[0]];
//            System.out.println(i + ". " + dataOrder[0] + " - Jumlah: " + pesanan[1] + " - Total: " + pesanan[2]*pesanan[1]);
//            hargaTotal = hargaTotal + (pesanan[2]*pesanan[1]);
//            i++;
//        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Total Pesanan : " + hargaTotal);
        System.out.println("------------------------------------------------------------");

        return hargaTotal;
    }

}
