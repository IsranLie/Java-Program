/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletedatabase;
import java.sql.*;
/**
 *
 * @author Lie
 */
public class DeleteDatabase {

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
            urlValue = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
            
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            
            String sql = "delete from t_mata_kuliah where kd_mk=?";
            
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, "IF008");
            
            int intBaris = pStatement.executeUpdate();
            if(intBaris > 0){
                System.out.println("Penghapusan data berhasil");
            }
            else {
                System.out.println("Penghapusan data gagal");
            }
            pStatement.close();
            conn.close();            
        }
        catch(SQLException e){
            System.out.println("Koneksi Gagal"+e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println("JDBC Driver tidak ditemukan");
        }
    }
    
}
