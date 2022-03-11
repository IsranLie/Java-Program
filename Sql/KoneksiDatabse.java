/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidatabse;
import java.sql.*;
/**
 *
 * @author Lie
 */
public class KoneksiDatabse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String user = "root";
        String pwd = "";
        String host = "localhost";
        String db = "java_akdmk";
        String urlValue = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            urlValue = "jdbc:mysql://"+host+"/"+db+"?user = "+user+"& password = "+pwd;
            
            Connection conn = DriverManager.getConnection(urlValue);
            System.out.println("Koneksi Sukses");
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Koneksi Gagal "+e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }
    
}
