package pbo.pbo5.uas.bengkel.pkg10120171.pkg10120175.pkg10120204;

import java.sql.*;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Isran
 */
public class barang {
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
    
    public void tambah_barang() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            System.out.println("       [MENAMBAHKAN DATA BARANG]       \n");
            
            // Input Data Barang
            System.out.print("Masukkan ID Barang     : ");
            String id_brg = scan.next();
            System.out.print("Masukkan Nama Barang   : ");
            String nm_brg = br.readLine();
            System.out.print("Masukkan Harga Barang  : Rp.");
            int hrg_brg = scan.nextInt();
            System.out.print("Masukkan Jumlah Barang : ");
            int jml_brg = scan.nextInt();
            
            // Query Simpan Ke Tabel Barang
            String sql = "INSERT INTO barang(id_brg,nm_brg,hrg_brg,jumlah) VALUES('%s','%s','%d','%d')";
            sql = String.format(sql, id_brg,nm_brg,hrg_brg,jml_brg);
            s.execute(sql);
            System.out.println("\n(+) Data Barang Telah Ditambahkan");
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
    
    public void tampil_data_barang() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // Query sql barang
            String sql = "SELECT * FROM barang";
            rs = s.executeQuery(sql);
            
            System.out.println("---------------------------------------");
            System.out.println("|             DATA BARANG             |");
            System.out.println("---------------------------------------");
            
            while (rs.next()) {                
                String id_brg   = rs.getString("id_brg");
                String nm_brg = rs.getString("nm_brg");
                int hrg_brg   = rs.getInt("hrg_brg");
                int jml_brg    = rs.getInt("jumlah");                
                
                System.out.println(" ID Barang    : "+id_brg);
                System.out.println(" Nama Barang  : "+nm_brg);
                System.out.println(" Harga Barang : Rp."+hrg_brg);
                System.out.println(" Jumlah       : "+jml_brg);
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
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }
    
    public void cari_barang() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User Memasukkan Nama yang ingin dicari
            System.out.println("[MENCARI DATA BARANG BERDASARKAN ID\nBARANG]\n");
            System.out.print("Masukkan ID Barang : ");
            String cari_id_brg = scan.next();
            
            String sql = "SELECT * FROM barang WHERE id_brg='%s'";
            sql = String.format(sql, cari_id_brg);
            
            rs = s.executeQuery(sql);
            if(rs.next()) {
                String id_brg   = rs.getString("id_brg");
                String nm_brg = rs.getString("nm_brg");
                int hrg_brg   = rs.getInt("hrg_brg");
                int jml_brg    = rs.getInt("jumlah");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|             DATA BARANG             |");
                System.out.println("---------------------------------------");
                System.out.println("ID Barang    : "+id_brg);
                System.out.println("Nama Barang  : "+nm_brg);                
                System.out.println("Harga Barang : Rp."+hrg_brg);
                System.out.println("Jumlah       : "+jml_brg);
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
    
    public void cari_barang2() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User Memasukkan Nama yang ingin dicari
            System.out.println("[MENCARI DATA BARANG BERDASARKAN NAMA\nBARANG]\n");
            System.out.print("Masukkan Nama Barang : ");
            String cari_nm_brg = br.readLine();
            
            String sql = "SELECT * FROM barang WHERE nm_brg='%s'";
            sql = String.format(sql, cari_nm_brg);
            
            rs = s.executeQuery(sql);
            if(rs.next()) {
                String id_brg   = rs.getString("id_brg");
                String nm_brg = rs.getString("nm_brg");
                int hrg_brg   = rs.getInt("hrg_brg");
                int jml_brg    = rs.getInt("jumlah");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|             DATA BARANG             |");
                System.out.println("---------------------------------------");
                System.out.println("ID Barang    : "+id_brg);
                System.out.println("Nama Barang  : "+nm_brg);                
                System.out.println("Harga Barang : Rp."+hrg_brg);
                System.out.println("Jumlah       : "+jml_brg);
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
    
    public void update_data_barang() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            System.out.println("[UPDATE DATA BARANG BERDASARKAN ID\nBARANG]\n");
            // User memasukkan id barang yang ingin di perbarui
            System.out.print("Masukkan ID Barang : ");
            String cari_id_brg = scan.next();
            
            System.out.print("\nApakah Anda Yakin Ingin Mengubah Data\nDengan ID Barang "+cari_id_brg+" (y/n)? : ");
            String jawab = scan.next();
            if(jawab.equals("y")) {
                String sql = "SELECT * FROM barang WHERE id_brg='%s'";
                sql = String.format(sql, cari_id_brg);
                rs = s.executeQuery(sql);

                if(rs.next()) {
                    String id_brg = rs.getString("id_brg");
                    String nm_brg = rs.getString("nm_brg");                
                    int hrg_brg = rs.getInt("hrg_brg");
                    int jml_brg = rs.getInt("jumlah");

                    System.out.println("\n---------------------------------------");
                    System.out.println("|             DATA BARANG             |");
                    System.out.println("---------------------------------------");
                    System.out.println("ID Barang    : "+id_brg);
                    System.out.println("Nama Barang  : "+nm_brg);                
                    System.out.println("Harga Barang : Rp."+hrg_brg);
                    System.out.println("Jumlah       : "+jml_brg);

                    // Memasukkan data yang baru
                    System.out.println("\n---------------------------------------");
                    System.out.println("|        MASUKKAN DATA BARANG         |");
                    System.out.println("---------------------------------------");            
                    System.out.print("Nama Barang  : ");
                    String nm_brg_update = br.readLine();
                    System.out.print("Harga Barang : Rp.");
                    int hrg_brg_update = scan.nextInt();
                    System.out.print("Jumlah       : ");
                    int jml_brg_update = scan.nextInt();

                    // Query sql update
                    String sql_update = "UPDATE barang SET nm_brg='%s', hrg_brg='%d', jumlah='%d' WHERE id_brg='%s' ";
                    sql_update = String.format(sql_update, nm_brg_update,hrg_brg_update,jml_brg_update, cari_id_brg);
                    s.execute(sql_update);
                    System.out.println("\n(~) Data Berhasil Diperbarui");
                } else {
                    System.out.println("\n(?) Data Tidak Ditemukan");
                }
                
                if(jawab.equalsIgnoreCase("n")) {
                    System.exit(0);                    
                }
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
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }
    
    public void hapus_data_barang() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan nama brg yang ingin dihapus
            System.out.println("[MENGHAPUS DATA BARANG BERDASARKAN ID\nBARANG]\n");            
            System.out.print("Masukkan ID Barang : ");
            String id_brg = scan.next();
            
            System.out.print("\nApakah Anda Yakin Ingin Menghapus Data\nDengan ID Barang "+id_brg+" (y/n)? : ");
            String jawab = scan.next();
            if(jawab.equals("y")) {
                String sql = "DELETE FROM barang WHERE id_brg='%s'";
                sql = String.format(sql, id_brg);

                int baris = s.executeUpdate(sql);
                if(baris > 0) {
                    System.out.println("\n(-) Data Barang Berhasil Dihapus");
                } else {
                    System.out.println("\n(?) Data Barang Tidak Ditemukan");
                }
                System.out.println("---------------------------------------");
                if(jawab.equalsIgnoreCase("n")) {
                    System.exit(0);                    
                }
            }
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
}
