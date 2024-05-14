
package admin_functionalities;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Client {
    
    
    //  Manage categories funtions  Start
 
    
    public Connection createConnection(){
       
        Connection connection= null;
        
       MysqlDataSource mds = new MysqlDataSource();
        
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("admin_functio");
        
        try {
            connection = mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
   
    
    public boolean M_Categories( String c_name, String c_des){
        
        PreparedStatement st;
        String addquery = "INSERT INTO `manage_category`(`cat_name`, `cat_descr`) VALUES (?,?)";
        
        try {
            st = createConnection().prepareStatement(addquery);
            
            st.setString(1,c_name);
            st.setString(2, c_des);
            
            return(st.executeUpdate()>0);
           
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
   public boolean editCategory(int id, String c_name, String c_des ){
         PreparedStatement st;
         String updatequery = "UPDATE `manage_category` SET `cat_name`=?,`cat_descr`=? WHERE `id`=?";
        
        try {
            st = createConnection().prepareStatement(updatequery);
            
            
            st.setString(1,c_name);
            st.setString(2, c_des);
           st.setInt(3,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public boolean removCategory(int id  ){
        
         PreparedStatement st;
        String deletequery = "DELETE FROM `manage_category` WHERE `id`=?";
        
        try {
            st = createConnection().prepareStatement(deletequery);
            
            
            st.setInt(1,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public void categoriesTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectquery = "SELECT * FROM manage_category";
        
        try {
            ps = createConnection().prepareStatement(selectquery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[3];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
               
                
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    // Manage categories funtions  End
    
    // Manage User funtion start
    
    public boolean update_user(int id, String u_name, String u_email, String u_password,String u_phone,String u_security,String u_answer,String u_address1,String u_address2){
         PreparedStatement st;
         String updatequery = "UPDATE `manage_user` SET `username`=?,`email`=?,`password`=?,`phone`=?,`Security_Q`=?,`answer`=?,`adderss_1`=?,`address_2`=? WHERE `u_id`=?";
        
             try {
            st = createConnection().prepareStatement(updatequery);
            
            
             st.setString(1,u_name);
            st.setString(2, u_email);
            st.setString(3, u_password);
            st.setString(4 ,u_phone);
            st.setString(5, u_security);
            st.setString(6, u_answer);
            st.setString(7, u_address1);
            st.setString(8, u_address2);
            st.setInt(9,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
      
    }
    
    public boolean delete_user(int id ){
        
         PreparedStatement st;
        String deletequery = "DELETE FROM `manage_user` WHERE `u_id`=?";
        
        try {
            st = createConnection().prepareStatement(deletequery);
            
            
            st.setInt(1,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public void userTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectquery = "SELECT * FROM manage_user";
        
        try {
            ps = createConnection().prepareStatement(selectquery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[9];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getString(4);
                row[4]= rs.getString(5);
                row[5]= rs.getString(6);
                row[6]= rs.getString(7);
                row[7]= rs.getString(8);
                row[8]= rs.getString(9);
               
                
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    
    // Manage User funtion end
    
    // Manage Product start
    
    
     public boolean Add_product( String p_name, String p_category ,String p_quantity,String p_price){
        
        PreparedStatement st;
        String addquery = "INSERT INTO `manage_product` (`pro_name`, `pro_category`, `pro_quantity`, `pro_price`) VALUES (?,?,?,?)";
        
        try {
            st = createConnection().prepareStatement(addquery);
            
            st.setString(1,p_name);
            st.setString(2, p_category);
            st.setString(3, p_quantity);
            st.setString(4,p_price);
            
            return(st.executeUpdate()>0);
           
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
   public boolean Update_product(int id, String name, String category, String quantity,String price ){
         PreparedStatement st;
         String updatequery = "UPDATE `manage_product` SET `pro_name`=?,`pro_category`=?,`pro_quantity`=?,`pro_price`=? WHERE `id`=?";
        
        try {
            st = createConnection().prepareStatement(updatequery);
            
           
             st.setString(1,name);
            st.setString(2, category);
            st.setString(3, quantity);
            st.setString(4,price);
             st.setInt(5,id);
           
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public boolean delete_product(int id  ){
        
         PreparedStatement st;
        String deletequery = "DELETE FROM `manage_product` WHERE `id`=?";
        
        try {
            st = createConnection().prepareStatement(deletequery);
            
            
            st.setInt(1,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public void productTable(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectquery = "SELECT * FROM manage_product";
        
        try {
            ps = createConnection().prepareStatement(selectquery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[5];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getString(4);
                row[4]= rs.getString(5);
               
                
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    
    // manage product end
    
    // Add suppliers start
    
    public boolean Add_suppliers( String username, String email ,String password,String phone,String address1,String address2){
        
        PreparedStatement st;
        String addquery = "INSERT INTO `add_suppliers` (`sup_username`, `sup_email`, `sup_password`, `sup_phone`, `sup_address_L1`, `sup_address_L2`) VALUES (?,?,?,?,?,?)";
        
        try {
            st = createConnection().prepareStatement(addquery);
           
            st.setString(1,username);
            st.setString(2, email);
            st.setString(3, password);
            st.setString(4,phone);
             st.setString(5,address1);
              st.setString(6,address2);
            
            return(st.executeUpdate()>0);
           
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    // Add suplier end
    
    
    // Manage Supplier start
    
     public boolean update_supplier(int id, String s_name, String s_email, String s_password,String s_phone,String s_address1,String s_address2){
         PreparedStatement st;
         String updatequery = "UPDATE `add_suppliers` SET `sup_username`=?,`sup_email`=?,`sup_password`=?,`sup_phone`=?,`sup_address_L1`=?,`sup_address_L2`=? WHERE `id`=?";
        
             try {
            st = createConnection().prepareStatement(updatequery);
            
            
             st.setString(1,s_name);
            st.setString(2, s_email);
            st.setString(3, s_password);
            st.setString(4 ,s_phone);
            st.setString(5, s_address1);
            st.setString(6, s_address2);
            st.setInt(7,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
      
    }
    
    public boolean delete_supplier(int id ){
        
         PreparedStatement st;
        String deletequery = "DELETE FROM `add_suppliers` WHERE `id`=?";
        
        try {
            st = createConnection().prepareStatement(deletequery);
            
            
            st.setInt(1,id);
            
             return(st.executeUpdate()>0);
          
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }
    
    public void supplier_Table(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        String selectquery = "SELECT * FROM add_suppliers";
        
        try {
            ps = createConnection().prepareStatement(selectquery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                
                row = new Object[7];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getString(4);
                row[4]= rs.getString(5);
                row[5]= rs.getString(6);
                row[6]= rs.getString(7);
               
                tableModel.addRow(row);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    
    // Manage Supplier end 
}
