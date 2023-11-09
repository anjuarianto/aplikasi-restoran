import Panel.MainFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Process.Menu;
import Process.Pembayaran;

public class Main {

    public static void main(String[] args) {
        new MainFrame();
    }

    public static void backup() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer[]> semuaPesanan;
        int inputMainMenu;

        while(true) {
            clearScreen();
            mainMenuDisplay();
            inputMainMenu = Integer.parseInt(scanner.nextLine());

            switch (inputMainMenu) {
                case 1:
                    clearScreen();
                    displayMenu();
                    System.out.println("Press anything to back to main menu...");
                    scanner.nextLine();
                    break;
                case 2:
                    semuaPesanan = buatPesanan();
                    semuaPesanan = bayar(semuaPesanan);
//                    printStruk(semuaPesanan);

                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input tidak diketahui");
            }

        }

    }

    public static boolean yesOrNo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" (y/n)");
        while(true) {
            String answer;
            answer = scanner.nextLine();

            if(answer.equals("y")) {
                return true;
            } else if(answer.equals("n")) {
                return false;
            } else {
                System.out.println("Tolong masukan y/n");
            }
        }

    }



    public static ArrayList<Integer[]> buatPesanan() throws IOException, InterruptedException {
        int decisionPesanan = 0;
        Integer[] pesanan;
        ArrayList<Integer[]> semuaPesanan = new ArrayList<>();

        while (decisionPesanan == 0) {

            if(decisionPesanan == 1) {
                break;
            }

            pesanan = simpanPesanan(semuaPesanan);
            semuaPesanan.add(pesanan);

            decisionPesanan = tanyaPesanan();

        }

        return semuaPesanan;
    }

    public static void mainMenuDisplay() {
        System.out.println("------------- Main menu -------------");
        System.out.println("Silahkan pilih:");
        System.out.println("1. Lihat Semua Process.Menu");
        System.out.println("2. Buat Pesanan");
        System.out.println("3. Keluar");
    }



    public static Integer[] simpanPesanan(ArrayList<Integer[]> semuaPesanan) throws IOException, InterruptedException {
        Integer[] pesanan = new Integer[0];

        clearScreen();
        displayMenu();
        pesanan = pilihMenu();


        return pesanan;
    }




    public static Integer tanyaPesanan() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tekan 0 untuk pilih menu atau 1 untuk lanjutkan pemesanan: ");
        Integer decision = Integer.valueOf(scanner.nextLine());

        return decision;
    }

    public static Integer[] pilihMenu() {
        Integer[] result;
        Integer hargaMenu;
        Scanner scanner = new Scanner(System.in);
        String[][] menu = new Menu().getMenus();

        System.out.println("Pilih Process.Menu: ");
        Integer menuPesanan = Integer.valueOf(scanner.nextLine())-1;
        System.out.println("Masukan jumlah pesanan: ");
        Integer jumlahPesanan = Integer.valueOf(scanner.nextLine());

        hargaMenu = Integer.valueOf(menu[menuPesanan][2]);

        result = new Integer[]{menuPesanan, jumlahPesanan, hargaMenu};

        return result;
    }



    public static void displayMenu() {
        Menu menu = new Menu();

        int i;

        System.out.println("==== Makanan ====");
        for (i = 0; i < menu.getMenus().length; i++)

            if (menu.getMenus()[i][1] == "Makanan") {
                System.out.println(i+1 + ". " + menu.getMenus()[i][0] + " | "  + menu.getMenus()[i][2]);
            }

        System.out.println();
        System.out.println("==== Minuman ====");

        for (i = 0; i < menu.getMenus().length; i++)
            if (menu.getMenus()[i][1] == "Minuman") {
                System.out.println(i+1 + ". " + menu.getMenus()[i][0]+ " | " + menu.getMenus()[i][2]);
            }
    }

    public static ArrayList<Integer[]> bayar(ArrayList<Integer[]> semuaPesanan) throws IOException, InterruptedException {
        clearScreen();

        float hargaSemuaPesanan, pajakPelayanan, totalPesanan;

        hargaSemuaPesanan = Pembayaran.hitungSemuaPesanan(semuaPesanan);

//        if(hargaSemuaPesanan > 50000) {
//            tambahGratisMinuman(semuaPesanan);
//        }

        clearScreen();
        Pembayaran.hitungSemuaPesanan(semuaPesanan);

        if(hargaSemuaPesanan > 100000) {
            hargaSemuaPesanan = Pembayaran.hitungDiskon(hargaSemuaPesanan);
        }



        pajakPelayanan = Pembayaran.hitungPajak(hargaSemuaPesanan);

        return semuaPesanan;
    }

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }


//    public static ArrayList<Integer[]> tambahGratisMinuman(ArrayList<Integer[]> semuaPesanan) throws IOException, InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        Integer[] pesanan = new Integer[0];
//
//        Integer input;
//        System.out.println("Pilih satu gratis minuman, ketik apa saja untuk melanjutkan...");
//        scanner.nextLine();
//        displayMenu();
//        System.out.println("Pilih minuman:");
//        input = Integer.valueOf(scanner.nextLine());
//
//        if(Menu.getMenus()[input][1] == "Minuman") {
//            pesanan = new Integer[] {input-1,1,0};
//            semuaPesanan.add(pesanan);
//        } else {
//            System.out.println("Silahkan pilih menu minuman..");
//        }
//
//        return semuaPesanan;
//    }
//
//    public static void printStruk(ArrayList<Integer[]> semuaPesanan) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Print struk?");
//
//        if(yesOrNo()) {
//            int numLength = 3, menuLength = 15, qtyLength = 3, hargaLength = 10;
//            float hargaTotal = 0;
//
//            System.out.println("____________________________________");
//            System.out.println("|No |Process.Menu           |Qty|Harga     |");
//            System.out.println("____________________________________");
//            int i=1;
//            for (Integer[] pesanan : semuaPesanan ) {
//                String[] dataOrder = Menu.getMenus()[pesanan[0]];
//                System.out.print("|" + String.format("%-"+numLength+"s", i));
//                System.out.print("|" + String.format("%-"+menuLength+"s", dataOrder[0]));
//                System.out.print("|" + String.format("%-"+qtyLength+"s", pesanan[1]));
//                System.out.println("|" + String.format("%-"+hargaLength+"s", pesanan[2]) + "|");
//                hargaTotal = hargaTotal + (pesanan[2]*pesanan[1]);
//                i++;
//            }
//            System.out.println("____________________________________");
//            System.out.println("|Total                  |" + String.format("%-"+hargaLength+"s", Pembayaran.getTotalPesanan(semuaPesanan))  + "|");
//            System.out.println("|Diskon                 |" + String.format("%-"+hargaLength+"s", Pembayaran.getDiskon(semuaPesanan))  + "|");
//            System.out.println("|Pajak 10% + Pelayanan  |" + String.format("%-"+hargaLength+"s", Pembayaran.getPajakPelayanan(semuaPesanan))  + "|");
//            System.out.println("|Grand Total            |" + String.format("%-"+hargaLength+"s", Pembayaran.getGrandTotal(semuaPesanan))  + "|");
//            System.out.println("____________________________________");
//        } else {
//            System.out.println("Struk tidak di print, terima kasih");
//        }
//    }
}

