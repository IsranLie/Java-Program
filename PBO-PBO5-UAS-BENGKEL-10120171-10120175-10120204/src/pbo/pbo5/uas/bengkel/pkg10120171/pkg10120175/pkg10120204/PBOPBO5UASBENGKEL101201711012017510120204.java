package pbo.pbo5.uas.bengkel.pkg10120171.pkg10120175.pkg10120204;

import java.sql.*;
import java.io.*;
/**
 *
 * @author Isran
 */
public class PBOPBO5UASBENGKEL101201711012017510120204 {
    public static void main(String[] args) throws IOException {
        // Koneksi
        String user = "ume4c33reid7tbyk";
        String pwd  = "JJCGFwjghVTpI2TchOAQ";
        String host = "bamo42c74s11s5jabuln-mysql.services.clever-cloud.com";
        String db   = "bamo42c74s11s5jabuln";
        String urlValue = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
        Statement s;
        menu_pilihan mp = new menu_pilihan();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");            
            Connection conn = DriverManager.getConnection(urlValue);            
            s = conn.createStatement();
            
            while(!conn.isClosed()) {
                mp.menu();
            }            
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
