/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 *
 * @author Sean
 */
@WebServlet(name = "Merchandise", urlPatterns = {"/merchandise"})
public class Merchandise extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://y0i0qxm7zw.database.windows.net:1433;database=tartan;user=tartan@y0i0qxm7zw;password=Z3nfuzVfq77vo497IwC0;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        String id = request.getParameter("id");
        if (id == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("{error:'no id'}");
            }
            return;
        }
        try {
            //Class.forName(driver).newInstance();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM merchandise WHERE id =" + id);
            Gson gson = new Gson();
            if (rs.next()) {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    MerchandiseObject m = new MerchandiseObject();
                    m.setTitle(rs.getString("title"))
                            .setDescription(rs.getString("description"))
                            .setPrice(rs.getInt("price"))
                            .setUrl(rs.getString("url"));
                    out.println(gson.toJson(m));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
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
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("ItemName") == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("{\"message\":\"item name is required\"}");
            }
        } else {
            //out.println("receive a post request");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("receive a post request");
                out.println(request.getParameter("ItemName").toString());
            }
            //processRequest(request, response,request.getParameter("ItemName").toString());
            String itemName = request.getParameter("ItemName").toString();
            String price = request.getParameter("Price").toString();
            String description = request.getParameter("Description").toString();
            String url = request.getParameter("Url").toString();

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String sqlUrl = "jdbc:sqlserver://y0i0qxm7zw.database.windows.net:1433;database=tartan;user=tartan@y0i0qxm7zw;password=Z3nfuzVfq77vo497IwC0;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            String query = "INSERT INTO merchandise (title,description,price,url) VALUES ('" + itemName + "','" + description + "','" + price + "','" + url + "')";
            System.out.println(query);
            try {
                //Class.forName(driver).newInstance();
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(sqlUrl);
                st = con.createStatement();
            //INSERT INTO merchandise (title,description,price) VALUES ('fff','ggg',4);

                try (PrintWriter out = response.getWriter()) {
                    out.println(query);
                }
                int isSuccess = st.executeUpdate(query);
                System.out.println(isSuccess);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Merchandise.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
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

        }

    }
}
