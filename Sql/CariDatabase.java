/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caridatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lie
 */
public class CariDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String kode_inp;
        String user = "root";
        String pwd = "";
        String host = "localhost";
        String db = "java_akdmk";
        String urlValue = "";
        
        int no;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            urlValue = "jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
            
            Connection conn = DriverManager.getConnection(urlValue);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from t_mata_kuliah where kd_mk='IF006'");
           
            no=0;
            
            while (rs.next())
            {
                no=no+1;
                System.out.println("No\t\t : "+no);
                System.out.println("Kode Mata Kuliah : "+rs.getString("kd_mk"));
                System.out.println("Nama Mata Kuliah : "+rs.getString("nama_mk"));
                System.out.println("\n");
            } 
            if(no == 0)
            {
                System.out.println("Data tidak ditemukan");
            }
            st.close();
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
