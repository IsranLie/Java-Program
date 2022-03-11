/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lie
 */
public class EditDatabase {

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
            urlValue = "jdbc:mysql://"+host+"/"+db+"?user ="+user+"& password = "+pwd;
            
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql = "update t_mata_kuliah set nama_mk=? where kd_mk='IF007'";
            
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, "Matematika");
            
            int intBaris = pStatement.executeUpdate();
            if(intBaris > 0){
                System.out.println("Pengubahan data berhasil");
            }
            else {
                System.out.println("Pengubahan data gagal");
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
