package pbo.pbo5.uas.bengkel.pkg10120171.pkg10120175.pkg10120204;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Isran
 */
public class menu_pilihan {
    service srv  = new service();
    barang brg   = new barang();
    pemasukan pm = new pemasukan();    
    
    public void menu() throws IOException {
        String repeat = "y";
        while(repeat.equals("y")) {            
            Scanner scan = new Scanner(System.in);
            System.out.println("\n            HACHI - Tech");
            System.out.println("            BENGKEL MOBIL");
            System.out.printf("%-12s%-15s%-12s\n", "SPAREPART -","HOME SERVICE -","BODY REPAIR");
            System.out.println("Jln. Halimunda No.66 - Kota Kabut Malam\n");
            
            System.out.println("---------------------------------------");
            System.out.println("|                  HOME               |");
            System.out.println("---------------------------------------");
            System.out.println("<1>. DATA SERVICE");
            System.out.println("<2>. DATA BARANG");
            System.out.println("<3>. DATA PEMASUKAN");
            System.out.println("<0>. EXIT");
            System.out.println("---------------------------------------");
            System.out.print(" Pilihan : ");
            int pilih = scan.nextInt();
            System.out.println();
            if(pilih < 0 || pilih > 3) {
                System.out.println("---------------------------------------");
                System.out.println("| Menu Tidak Tersedia                 |");
                System.out.println("| Silahkan coba 1, 2, 3, atau 0.      |");
                System.out.println("---------------------------------------");
            }                                                
            switch(pilih) {
                case 1:{
                    System.out.println("---------------------------------------");
                    System.out.println("|              DATA SERVICE           |");
                    System.out.println("---------------------------------------");
                    System.out.println("<1>. TAMBAH SERVICE");
                    System.out.println("<2>. TAMPIL DATA SERVICE");
                    System.out.println("<3>. CARI DATA SERVICE BERDASARKAN ID");
                    System.out.println("     SERVICE");
                    System.out.println("<4>. CARI DATA SERVICE BERDASARKAN");
                    System.out.println("     NOMOR NOTA");
                    System.out.println("<5>. UPDATE DATA SERVICE");
                    System.out.println("<6>. HAPUS DATA SERVICE");
                    System.out.println("<0>. EXIT");
                    System.out.println("---------------------------------------");
                    System.out.print(" Pilihan : ");
                    int pilih1 = scan.nextInt();
                    System.out.println();
                    if(pilih1 < 0 || pilih1 > 6) {
                        System.out.println("---------------------------------------");
                        System.out.println("| Menu Tidak Tersedia                 |");
                        System.out.println("| Silahkan coba 1,2,3,4,5,6, atau 0.  |");
                        System.out.println("---------------------------------------");
                    } 
                    switch(pilih1) {
                        case 1:{
                            srv.tambah_service();
                            break;
                        }
                        case 2:{
                            srv.tampil_data_service();
                            break;
                        }
                        case 3:{
                            srv.cari_data_service();
                            break;
                        }
                        case 4:{
                            srv.cari_data_service2();
                            break;
                        }
                        case 5:{
                            srv.update_data_service();
                            break;
                        }
                        case 6:{
                            srv.hapus_data_service();
                            break;
                        }
                        case 0:{
                            System.exit(0);
                        }
                    }                   
                }
                break;
                case 2:{
                    System.out.println("---------------------------------------");
                    System.out.println("|              DATA BARANG            |");
                    System.out.println("---------------------------------------");
                    System.out.println("<1>. TAMBAH BARANG");
                    System.out.println("<2>. TAMPIL DATA BARANG");
                    System.out.println("<3>. CARI DATA BARANG BERDASARKAN ID");
                    System.out.println("     BARANG");
                    System.out.println("<4>. CARI DATA BARANG BERDASARKAN NAMA");
                    System.out.println("     BARANG");
                    System.out.println("<5>. UPDATE DATA BARANG");
                    System.out.println("<6>. HAPUS DATA BARANG");
                    System.out.println("<0>. EXIT");
                    System.out.println("---------------------------------------");
                    System.out.print(" Pilihan : ");
                    int pilih2 = scan.nextInt();
                    System.out.println();
                    if(pilih2 < 0 || pilih2 > 6) {
                        System.out.println("---------------------------------------");
                        System.out.println("| Menu Tidak Tersedia                 |");
                        System.out.println("| Silahkan coba 1,2,3,4,5,6, atau 0.  |");
                        System.out.println("---------------------------------------");
                    }
                    switch(pilih2) {
                        case 1:{
                            brg.tambah_barang();
                            break;
                        }
                        case 2:{
                            brg.tampil_data_barang();
                            break;
                        }
                        case 3:{
                            brg.cari_barang();
                            break;
                        }
                        case 4:{
                            brg.cari_barang2();
                            break;
                        }
                        case 5:{
                            brg.update_data_barang();
                            break;
                        }
                        case 6:{
                            brg.hapus_data_barang();
                            break;
                        }
                        case 0:{
                            System.exit(0);
                        }
                    }                   
                }
                break;
                case 3:{
                    System.out.println("---------------------------------------");
                    System.out.println("|             DATA PEMASUKAN          |");
                    System.out.println("---------------------------------------");
                    System.out.println("<1>. TAMPIL DATA PEMASUKAN");
                    System.out.println("<2>. TAMPIL TOTAL PEMASUKAN");
                    System.out.println("<3>. CARI DATA PEMASUKAN BERDASARKAN");
                    System.out.println("     NOMOR NOTA");
                    System.out.println("<4>. CARI DATA PEMASUKAN BERDASARKAN");
                    System.out.println("     TANGGAL");
                    System.out.println("<5>. HAPUS DATA PEMASUKAN");
                    System.out.println("<0>. EXIT");
                    System.out.println("---------------------------------------");
                    System.out.print(" Pilihan : ");
                    int pilih3 = scan.nextInt();
                    System.out.println();
                    if(pilih3 < 0 || pilih3 > 5) {
                        System.out.println("---------------------------------------");
                        System.out.println("| Menu Tidak Tersedia                 |");
                        System.out.println("| Silahkan coba 1,2,3,4,5, atau 0.    |");
                        System.out.println("---------------------------------------");
                    }
                    switch(pilih3) {
                        case 1:{
                            pm.tampil_data_pemasukan();
                            break;
                        }
                        case 2:{
                            pm.tampil_total_pemasukan();
                            break;
                        }
                        case 3:{
                            pm.cari_data_pemasukan();
                            break;
                        }
                        case 4:{
                            pm.cari_data_pemasukan2();
                            break;
                        }
                        case 5:{
                            pm.hapus_data_pemasukan();
                            break;
                        }
                        case 0:{
                            System.exit(0);
                        }
                    }                   
                } 
                break;
                case 0:{
                    System.exit(0);
                }
                break;
            }                        
            System.out.print(" KEMBALI KE MENU UTAMA (y/n) : ");
            repeat = scan.next();
            if(repeat.equalsIgnoreCase("n")) {
                System.exit(0);            
            }            
        }
    }
}
