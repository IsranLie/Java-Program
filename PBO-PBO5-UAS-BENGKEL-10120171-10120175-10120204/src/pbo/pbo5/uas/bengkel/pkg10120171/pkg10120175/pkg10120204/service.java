package pbo.pbo5.uas.bengkel.pkg10120171.pkg10120175.pkg10120204;

import java.sql.*;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Isran
 */
public class service {
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
    
    public void tambah_service() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);                          
            s = conn.createStatement();                                  
            
            System.out.println("        [MENAMBAHKAN DATA SERVICE]     \n");
            
            // User Menambahkan Data Service
            System.out.println("[IDENTITAS PEMILIK]");
            System.out.print("Masukkan No. Nota      : ");
            int no_nota = scan.nextInt();            
            
            System.out.print("Masukkan Tanggal(T-B-H): ");
            String tgl = scan.next();                        
            
            System.out.print("Masukkan Nama Konsumen : ");
            String nama = br.readLine();
            
            System.out.print("Masukkan Alamat        : ");
            String alamat = br.readLine();
            
            System.out.print("Masukkan Plat Nomor    : ");
            String plat_no = br.readLine();
            
            System.out.print("Masukkan Merk Kendaraan: ");
            String merk = br.readLine();
            
            System.out.println("[JASA]");            
            System.out.print("Masukkan Nama Jasa     : ");
            String nm_jasa = br.readLine();
            
            System.out.print("Masukkan Nama Mekanik  : ");
            String nm_mekanik = br.readLine();
            
            System.out.print("Masukkan Harga Jasa    : Rp.");
            int hrg_jasa = scan.nextInt();
            
            System.out.println("[BARANG]");
            System.out.print("Masukkan ID Barang     : ");
            String id_brg = scan.next();
            
            // Mengambil nama & harga barang dari database
            String sql = "SELECT nm_brg,hrg_brg,jumlah FROM barang WHERE id_brg='%s'";
            sql = String.format(sql, id_brg);
            rs = s.executeQuery(sql);
            
            if(rs.next()) {
                String nm_brg = rs.getString("nm_brg");            
                System.out.println("Nama Barang            : "+nm_brg);

                int jumlah = rs.getInt("jumlah");
                System.out.print("Masukkan Jumlah Barang : ");
                int jml_input = scan.nextInt();

                int hrg = rs.getInt("hrg_brg");
                int hrg_brg = hrg * jml_input;
                System.out.println("Harga Barang           : Rp."+hrg_brg);                        

                // Menghitung total
                System.out.println("[TOTAL]");
                int total = hrg_jasa + hrg_brg;           
                System.out.println("Total                  : Rp."+total);

                // Update jumlah barang yang sudah terjual
                int jml_brg = jumlah - jml_input;
                String sql_update_jml = "UPDATE barang SET jumlah='%d' WHERE id_brg='%s'";
                sql_update_jml = String.format(sql_update_jml, jml_brg, id_brg);
                s.execute(sql_update_jml);            

                // Query tambah data pemasukan
                String sql_pemasukan = "INSERT INTO pemasukan (no_nota,tgl,jumlah) VALUES('%d','%s','%d')";
                sql_pemasukan = String.format(sql_pemasukan,no_nota,tgl,total);
                s.execute(sql_pemasukan);
                System.out.println("\n(+) Data Pemasukan Berhasil Ditambahkan");

                // Query service                        
                String sql_service = "INSERT INTO service (no_nota,tgl,nama,alamat,plat_no,merk,nm_jasa,nm_mekanik,hrg_jasa,id_brg,jml_input,nama_brg,hrg_brg,total) "
                        + "VALUES ('%d','%s','%s','%s','%s','%s','%s','%s','%d','%s','%d','%s','%d','%d')";
                sql_service = String.format(sql_service,no_nota,tgl,nama,alamat,plat_no,merk,nm_jasa,nm_mekanik,hrg_jasa,id_brg,jml_input,nm_brg,hrg_brg,total);
                s.execute(sql_service);
                System.out.println("(+) Data Service Berhasil Ditambahkan");            
            } else {
                System.out.println("\n(?) ID Barang Tidak Tersedia");                
                System.out.println("(*Gunakan Menu Tampil Barang Untuk Melihat\n ID Yang Tersedia)\n");
            }
            System.out.println("---------------------------------------");
            // Mengakhiri Connection & Statement
            conn.close();
            s.close();                        
        }
        // Error
        catch(SQLException e) {
            System.out.println("Koneksi Gagal"+e.toString());
        }
        catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver Tidak Ditemukan");
        }        
    }
    
    public void tampil_data_service() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // Query tampil data
            String sql = "SELECT * FROM service";
            rs = s.executeQuery(sql);
            
            System.out.println("---------------------------------------");
            System.out.println("|             DATA SERVICE            |");
            System.out.println("---------------------------------------");
            while(rs.next()) {
                int id_srv = rs.getInt("id_service");
                int no_nota = rs.getInt("no_nota");
                String tgl = rs.getString("tgl");
                String nm_pemilik = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String plat_no = rs.getString("plat_no");
                String merk = rs.getString("merk");
                String nm_jasa = rs.getString("nm_jasa");
                String nm_mekanik = rs.getString("nm_mekanik");
                int hrg_jasa = rs.getInt("hrg_jasa");               
                String id_brg = rs.getString("id_brg");
                String nm_brg = rs.getString("nama_brg");
                int hrg_brg = rs.getInt("hrg_brg");
                int tot = rs.getInt("total");
                                
                System.out.println(" ID Service     : "+id_srv);
                System.out.println(" Nomer Nota     : "+no_nota);
                System.out.println(" Tanggal        : "+tgl);
                System.out.println(" Nama Konsumen  : "+nm_pemilik);
                System.out.println(" Alamat         : "+alamat);
                System.out.println(" Plat Nomor     : "+plat_no);
                System.out.println(" Merk Kendaraan : "+merk);
                System.out.println(" Nama Jasa      : "+nm_jasa);
                System.out.println(" Nama Mekanik   : "+nm_mekanik);
                System.out.println(" Harga Jasa     : Rp."+hrg_jasa);
                System.out.println(" ID Barang      : "+id_brg);
                System.out.println(" Nama Barang    : "+nm_brg);
                System.out.println(" Harga Barang   : Rp."+hrg_brg);
                System.out.println(" Total          : Rp."+tot);
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
    
    public void cari_data_service() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan data yang dicari
            System.out.println("[MENCARI DATA SERVICE BERDASARKAN ID\nSERVICE]\n");
            System.out.print("Masukkan ID SERVICE : ");
            int cari_id_service = scan.nextInt();
            
            String sql_cari = "SELECT * FROM service WHERE id_service='%d'";
            sql_cari = String.format(sql_cari, cari_id_service);
            rs = s.executeQuery(sql_cari);
            if(rs.next()) {
                int id_srv = rs.getInt("id_service");                
                String tgl = rs.getString("tgl");
                String nm_pemilik = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String plat_no = rs.getString("plat_no");
                String merk = rs.getString("merk");
                String nm_jasa = rs.getString("nm_jasa");
                String nm_mekanik = rs.getString("nm_mekanik");
                int hrg_jasa = rs.getInt("hrg_jasa");               
                String id_brg = rs.getString("id_brg");
                String nm_brg = rs.getString("nama_brg");
                int hrg_brg = rs.getInt("hrg_brg");
                int tot = rs.getInt("total");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|             DATA SERVICE            |");
                System.out.println("---------------------------------------");
                System.out.println("ID Service     : "+id_srv);              
                System.out.println("Tanggal        : "+tgl);
                System.out.println("Nama Konsumen  : "+nm_pemilik);
                System.out.println("Alamat         : "+alamat);
                System.out.println("Plat Nomor     : "+plat_no);
                System.out.println("Merk Kendaraan : "+merk);
                System.out.println("Nama Jasa      : "+nm_jasa);
                System.out.println("Nama Mekanik   : "+nm_mekanik);
                System.out.println("Harga Jasa     : Rp."+hrg_jasa);
                System.out.println("ID Barang      : "+id_brg);
                System.out.println("Nama Barang    : "+nm_brg);
                System.out.println("Harga Barang   : Rp."+hrg_brg);
                System.out.println("Total          : Rp."+tot);
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
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
    
    public void cari_data_service2() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan data yang dicari
            System.out.println("[MENCARI DATA SERVICE BERDASARKAN NO.\nNOTA]\n");
            System.out.print("Cari Nomor Nota : ");
            int no_nota = scan.nextInt();
            
            String sql_cari = "SELECT * FROM service WHERE no_nota='%d'";
            sql_cari = String.format(sql_cari, no_nota);
            rs = s.executeQuery(sql_cari);
            if(rs.next()) {
                int id_srv = rs.getInt("id_service");                
                String tgl = rs.getString("tgl");
                String nm_pemilik = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String plat_no = rs.getString("plat_no");
                String merk = rs.getString("merk");
                String nm_jasa = rs.getString("nm_jasa");
                String nm_mekanik = rs.getString("nm_mekanik");
                int hrg_jasa = rs.getInt("hrg_jasa");               
                String id_brg = rs.getString("id_brg");
                String nm_brg = rs.getString("nama_brg");
                int hrg_brg = rs.getInt("hrg_brg");
                int tot = rs.getInt("total");
                
                System.out.println("\n---------------------------------------");
                System.out.println("|             DATA SERVICE            |");
                System.out.println("---------------------------------------");
                System.out.println("ID Service     : "+id_srv);              
                System.out.println("Tanggal        : "+tgl);
                System.out.println("Nama Konsumen  : "+nm_pemilik);
                System.out.println("Alamat         : "+alamat);
                System.out.println("Plat Nomor     : "+plat_no);
                System.out.println("Merk Kendaraan : "+merk);
                System.out.println("Nama Jasa      : "+nm_jasa);
                System.out.println("Nama Mekanik   : "+nm_mekanik);
                System.out.println("Harga Jasa     : Rp."+hrg_jasa);
                System.out.println("ID Barang      : "+id_brg);
                System.out.println("Nama Barang    : "+nm_brg);
                System.out.println("Harga Barang   : Rp."+hrg_brg);
                System.out.println("Total          : Rp."+tot);
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
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
    
    public void update_data_service() throws IOException {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan id barang yang ingin di perbarui
            System.out.println("[MEMASUKKAN NO. NOTA UNTUK UPDATE DATA\nSERVICE]\n");
            System.out.print("Masukkan No. Nota : ");
            int cari_no_nota = scan.nextInt();
            
            System.out.print("\nApakah Anda Yakin Ingin Mengubah Data\nDengan No.Nota "+cari_no_nota+" (y/n)? : ");
            String jawab = scan.next();
            if(jawab.equals("y")) {
                String sql_update = "SELECT * FROM service WHERE no_nota='%d'";
                sql_update = String.format(sql_update, cari_no_nota);
                rs = s.executeQuery(sql_update);

                if(rs.next()) {
                    int id_srv = rs.getInt("id_service");
                    int no_nota = rs.getInt("no_nota");
                    String tgl = rs.getString("tgl");                
                    String nama = rs.getString("nama");
                    String alamat = rs.getString("alamat");
                    String plat_no = rs.getString("plat_no");
                    String merk = rs.getString("merk");
                    String nm_jasa = rs.getString("nm_jasa");
                    String nm_mekanik = rs.getString("nm_mekanik");
                    int hrg_jasa = rs.getInt("hrg_jasa");
                    String id_brg = rs.getString("id_brg");
                    int jml_input = rs.getInt("jml_input");
                    String nm_brg = rs.getString("nama_brg"); 
                    int hrg_brg = rs.getInt("hrg_brg");
                    int tot = rs.getInt("total");

                    System.out.println("\n---------------------------------------");
                    System.out.println("|             DATA SERVICE            |");
                    System.out.println("---------------------------------------");
                    System.out.println("ID Service     : "+id_srv);
                    System.out.println("Nomer Nota     : "+no_nota);
                    System.out.println("Tanggal        : "+tgl);
                    System.out.println("Nama Konsumen  : "+nama);
                    System.out.println("Alamat         : "+alamat);
                    System.out.println("Plat Nomor     : "+plat_no);
                    System.out.println("Merk Kendaraan : "+merk);
                    System.out.println("Nama Jasa      : "+nm_jasa);
                    System.out.println("Nama Mekanik   : "+nm_mekanik);                
                    System.out.println("Harga Jasa     : Rp."+hrg_jasa);
                    System.out.println("ID Barang      : "+id_brg);
                    System.out.println("Jumlah Barang  : "+jml_input);
                    System.out.println("Nama Barang    : "+nm_brg);
                    System.out.println("Harga Barang   : Rp."+hrg_brg);
                    System.out.println("Total          : Rp."+tot);  

                    // Memasukkan data yang baru
                    System.out.println("\n---------------------------------------");
                    System.out.println("|        MASUKKAN DATA SERVICE         |");
                    System.out.println("---------------------------------------");            
                    System.out.print("Nomor Nota     : ");
                    int no_nota_update = scan.nextInt();
                    System.out.print("Tanggal(T-B-H) : ");
                    String tgl_update = scan.next();
                    System.out.print("Nama Konsumen  : ");
                    String nama_update = br.readLine();
                    System.out.print("Alamat         : ");
                    String alamat_update = br.readLine();
                    System.out.print("Plat Nomor     : ");
                    String plat_no_update = br.readLine();
                    System.out.print("Merk Kendaraan : ");
                    String merk_update = br.readLine();            
                    System.out.print("Nama Jasa      : ");
                    String nm_jasa_update = br.readLine();
                    System.out.print("Nama Mekanik   : ");
                    String nm_mekanik_update = br.readLine();
                    System.out.print("Harga Jasa     : Rp.");
                    int hrg_jasa_update = scan.nextInt();
                    System.out.print("ID Barang      : ");
                    String id_brg_update = scan.next();

                    String sql = "SELECT nm_brg,hrg_brg,jumlah FROM barang WHERE id_brg='%s'";
                    sql = String.format(sql, id_brg_update);
                    rs = s.executeQuery(sql);
                    rs.next();

                    String nm_brg_update = rs.getString("nm_brg");
                    System.out.println("Nama Barang    : "+nm_brg_update);

                    int jumlah = rs.getInt("jumlah");
                    System.out.print("Jumlah Barang  : ");
                    int jml_input_update = scan.nextInt();

                    int hrg = rs.getInt("hrg_brg");
                    int hrg_brg_update = hrg * jml_input_update;
                    System.out.println("Harga Barang   : Rp."+hrg_brg_update);

                    int total_update = hrg_jasa_update + hrg_brg_update;
                    System.out.println("Total          : Rp."+total_update);

                    // Update jumlah barang yang sudah terjual
                    int jml_brg = jumlah - jml_input;
                    String sql_update_jml = "UPDATE barang SET jumlah='%d' WHERE id_brg='%s'";
                    sql_update_jml = String.format(sql_update_jml, jml_brg, id_brg_update);
                    s.execute(sql_update_jml);

                    // Query update data pemasukan                        
                    String sql_update_pemasukan = "UPDATE pemasukan SET no_nota='%d',tgl='%s',jumlah='%d' WHERE no_nota='%d'";
                    sql_update_pemasukan = String.format(sql_update_pemasukan, no_nota_update,tgl_update,total_update,no_nota_update);
                    s.execute(sql_update_pemasukan);

                    // Query service update
                    String sql_update_service = "UPDATE service SET no_nota='%d',tgl='%s',nama='%s',alamat='%s',plat_no='%s',merk='%s',"
                            + "nm_jasa='%s',nm_mekanik='%s',hrg_jasa='%d',id_brg='%s',jml_input='%d',nama_brg='%s',hrg_brg='%d',total='%d' WHERE no_nota='%d'";
                    sql_update_service = String.format(sql_update_service, no_nota_update,tgl_update,nama_update,alamat_update,plat_no_update,
                            merk_update,nm_jasa_update,nm_mekanik_update,hrg_jasa_update,id_brg_update,jml_input_update,nm_brg_update,hrg_brg_update,total_update,cari_no_nota);
                    s.execute(sql_update_service);

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
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
    
    public void hapus_data_service() {
        try {
            // Koneksi
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            // User memasukkan nama brg yang ingin dihapus
            System.out.println("[MENGHAPUS DATA SERVICE BERDASARKAN\nNOMOR NOTA]\n");            
            System.out.print("Masukkan No. Nota : ");
            int cari_no_nota = scan.nextInt();
            
            System.out.print("\nApakah Anda Yakin Ingin Menghapus Data\nDengan No.Nota "+cari_no_nota+" (y/n)? : ");
            String jawab = scan.next();
            if(jawab.equals("y")) {
                String sql_hapus_service = "DELETE FROM service WHERE no_nota='%d'";   
                sql_hapus_service = String.format(sql_hapus_service, cari_no_nota);

                int baris = s.executeUpdate(sql_hapus_service);
                if(baris > 0) {
                    System.out.println("\n(-) Data Service Berhasil Dihapus");
                } else {
                    System.out.println("\n(?) Data Service Tidak Ditemukan");
                }

                String sql_hapus_pemasukan = "DELETE FROM pemasukan WHERE no_nota='%d'";
                sql_hapus_pemasukan = String.format(sql_hapus_pemasukan, cari_no_nota);

                int barisPemasukan = s.executeUpdate(sql_hapus_pemasukan);
                if(barisPemasukan > 0) {
                    System.out.println("(-) Data Pemasukan Berhasil Dihapus");
                }
                
                if(jawab.equals("n")) {
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
            System.out.println("JDBC Driver Tidak Ditemukan");
        }
    }
}
