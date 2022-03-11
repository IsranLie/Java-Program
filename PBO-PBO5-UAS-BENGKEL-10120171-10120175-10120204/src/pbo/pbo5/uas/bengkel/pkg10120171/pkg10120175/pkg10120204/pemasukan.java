package pbo.pbo5.uas.bengkel.pkg10120171.pkg10120175.pkg10120204;

import java.sql.*;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Isran
 */
public class pemasukan {
    // Koneksi
    String user = "ume4c33reid7tbyk";
    String pwd  = "JJCGFwjghVTpI2TchOAQ";
    String host = "bamo42c74s11s5jabuln-mysql.services.clever-cloud.com";
    String db   = "bamo42c74s11s5jabuln";
    String urlValue = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
    Statement s;
    ResultSet rs;
    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
     public void tampil_data_pemasukan() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // Query sql barang
            String sql = "SELECT * FROM pemasukan";
            rs = s.executeQuery(sql);
            
            System.out.println("---------------------------------------");
            System.out.println("|            DATA PEMASUKAN           |");
            System.out.println("---------------------------------------");
            
            while (rs.next()) {                
                int no_nota = rs.getInt("no_nota");
                String tgl = rs.getString("tgl");                
                int jml = rs.getInt("jumlah");
                                
                System.out.println(" Nomor Nota : "+no_nota);
                System.out.println(" Tanggal    : "+tgl);                
                System.out.println(" Jumlah     : Rp."+jml);
                System.out.println("---------------------------------------");
            }
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();
        }
        catch(SQLException e) {
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
    
    public void tampil_total_pemasukan() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            String sql_inner_join = "SELECT t1.`no_nota`, t2.`jumlah` FROM `service` t1 INNER JOIN `pemasukan` t2 ON t1.`no_nota` = t2.`no_nota`";
            rs = s.executeQuery(sql_inner_join);
            
            System.out.println("---------------------------------------");
            System.out.println("|            DATA PEMASUKAN           |");
            System.out.println("---------------------------------------");
            System.out.println("|     No.Nota      |       Jumlah     |");
            System.out.println("---------------------------------------");
                
            while(rs.next()) {
                int no_nota = rs.getInt("no_nota");
                int jml = rs.getInt("jumlah");                
                System.out.println(String.format("%-2s%-17s%-2s%-17s%-1s","|",no_nota,"|",jml,"|"));                                                             
                System.out.println("---------------------------------------");
            }
            
            String sql_sum = "SELECT SUM(jumlah) FROM pemasukan";
            rs = s.executeQuery(sql_sum);
            rs.next();
            int total_jumlah = rs.getInt("SUM(jumlah)");
                
            System.out.println("\n---------------------------------------");
            System.out.println("|                 TOTAL               |");
            System.out.println("---------------------------------------");
            System.out.println(String.format("%-17s%-6s","",total_jumlah));
            System.out.println("---------------------------------------");
            
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();
        }                        
        catch(SQLException e) {
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
    
    public void cari_data_pemasukan() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan no.nota yang ingin dicari
            System.out.println("[MENCARI DATA PEMASUKAN BERDASARKAN\nNOMOR NOTA]\n");
            System.out.print("Masukkan No. Nota : ");
            int cari_no_nota = scan.nextInt();
            
            String sql = "SELECT * FROM pemasukan WHERE no_nota='%d'";
            sql = String.format(sql, cari_no_nota);
            
            rs = s.executeQuery(sql);
            if (rs.next()) {                               
                int no_nota = rs.getInt("no_nota");
                String tgl = rs.getString("tgl");
                int jml = rs.getInt("jumlah");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|            DATA PEMASUKAN           |");
                System.out.println("---------------------------------------");
                System.out.println("Nomor Nota : "+no_nota);
                System.out.println("Tanggal    : "+tgl);                
                System.out.println("Jumlah     : Rp."+jml);
            } else {
                System.out.println("\n(?) Data Tidak Ditemukan");
            }
            System.out.println("---------------------------------------");
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();
        }
        catch(SQLException e) {
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }

    public void cari_data_pemasukan2() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan no.nota yang ingin dicari
            System.out.println("[MENCARI DATA PEMASUKAN BERDASARKAN\nTANGGAL]\n");
            System.out.print("Masukkan Tanggal (T-B-H) : ");
            String cari_tgl = scan.next();
            
            String sql = "SELECT * FROM pemasukan WHERE tgl='%s'";
            sql = String.format(sql, cari_tgl);
            
            rs = s.executeQuery(sql);
            if (rs.next()) {                               
                int no_nota = rs.getInt("no_nota");
                String tgl = rs.getString("tgl");
                int jml = rs.getInt("jumlah");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|            DATA PEMASUKAN           |");
                System.out.println("---------------------------------------");
                System.out.println("Nomor Nota : "+no_nota);
                System.out.println("Tanggal    : "+tgl);                
                System.out.println("Jumlah     : Rp."+jml);
            } else {
                System.out.println("\n(?) Data Tidak Ditemukan");
            }
            System.out.println("---------------------------------------");
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();
        }
        catch(SQLException e) {
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }
    
    public void hapus_data_pemasukan() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan nama brg yang ingin dihapus
            System.out.println("[MENGHAPUS DATA PEMASUKAN BERDASARKAN\nNOMOR NOTA]\n");            
            System.out.print("Masukkan No. Nota : ");
            int no_nota = Integer.parseInt(br.readLine());
            
            System.out.print("\nApakah Anda Yakin Ingin Menghapus Data\nDengan No.Nota "+no_nota+" (y/n)? : ");
            String jawab = scan.next();
            if(jawab.equals("y")) {
                String sql = "DELETE FROM pemasukan WHERE no_nota='%d'";
                sql = String.format(sql, no_nota);                                                
                int baris = s.executeUpdate(sql);
                if(baris > 0) {
                    System.out.println("\n(-) Data Pemasukan Berhasil Dihapus");
                } else {
                    System.out.println("\n(?) Data Pemasukan Tidak Ditemukan");
                }
                
                if(jawab.equalsIgnoreCase("n")) {
                    System.exit(0);                    
                }
            }
            System.out.println("---------------------------------------");
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();
        }
        catch(SQLException e) {
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
}
