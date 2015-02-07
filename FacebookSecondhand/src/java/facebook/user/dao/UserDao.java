/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.user.dao;

import facebook.user.domain.User;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mac
 */
public class UserDao {
    public void add(User user){
        
       // response.setContentType("application/json;charset=UTF-8");
        
        Connection con = null;
       
        PreparedStatement ps=null;
        
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://y0i0qxm7zw.database.windows.net:1433;database=tartan;user=tartan@y0i0qxm7zw;password=Z3nfuzVfq77vo497IwC0;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
       
        try {
            //Class.forName(driver).newInstance();
            Class.forName(driver);
            con = DriverManager.getConnection(url);
          
             String sql="insert into facebook_user (id,name,link,email) values(?,?,?,?)";
           
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
		
			ps.setString(3, user.getLink());
			ps.setString(4, user.getEmail());  
                        
                        ps.executeUpdate();
           

        } catch (SQLException ex) {
       
           ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                
                ex.printStackTrace();
            }
        }
      
    }
    public List<User> find(String sql){
         Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://y0i0qxm7zw.database.windows.net:1433;database=tartan;user=tartan@y0i0qxm7zw;password=Z3nfuzVfq77vo497IwC0;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
       
        List<User> list = new ArrayList<User>();
        try {
           
            Class.forName(driver);
            con = DriverManager.getConnection(url);
           	
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();		
            if (rs.next()) {
                
                     	User user = new User();
			user.setId(rs.getString("id"));
                        user.setUsername(rs.getString("name"));
                        user.setLink(rs.getString("link"));
                        user.setEmail(rs.getString("email"));
			list.add(user);
                 
            }

        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger();
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
           ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
//                Logger lgr = Logger.getLogger(Version.class.getName());
//                lgr.log(Level.WARNING, ex.getMessage(), ex);
                ex.printStackTrace();
            }
        }
        return list;
    }
}
