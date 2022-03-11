/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lie
 */
public class InputDatabase {

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
            String sql = "INSERT INTO `t_mata_kuliah`(`kd_mk`,`nama_mk`)"+"VALUES(?,?);";
            
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, "IF007");
            pStatement.setString(2, "Software");                        
            
            int intBaris = pStatement.executeUpdate();
            if(intBaris > 0){
                System.out.println("Penambahan data berhasil");
            }
            else {
                System.out.println("Penambahan data gagal");
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
