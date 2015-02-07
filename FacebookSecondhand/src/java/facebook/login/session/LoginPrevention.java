/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook.login.session;

import facebook.user.domain.User;
import facebook.user.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mac
 */
@WebServlet(name = "LoginPrevention", urlPatterns = {"/LoginPrevention"})
public class LoginPrevention extends HttpServlet {
     
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String id =request.getParameter("id").trim();
            String name =request.getParameter("name");
            String link=request.getParameter("link");
            String email=request.getParameter("email");
           
            

            HttpSession session=request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("link", link);
            
            
            
            User user=new User();
            user.setId(id);
            user.setUsername(name);
            user.setLink(link);
            user.setEmail(email);
            
            UserService us1=new UserService();
            User userPage=new User();
            userPage=us1.findUserById(id);
            
            if(userPage==null){
               UserService us2=new UserService();
               us2.add(user);
            }
            else{
                String comid = userPage.getId().trim();
              //  System.out.println("ad************************SSSSSSSsSSSSsssssfadsfdafasdfa"+comid + "end");
                
                if (comid.equals("419580614863785")){
                              //  419580614863785
                PrintWriter out=response.getWriter();
                out.println("xiangzhuusermainpage.jsp");
               // System.out.println("************************SSSSSSSsSSSSssss ");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("xiangzhuusermainpage.jsp");
//                dispatcher.forward(request, response);
                
                 //response is a string itself  
                }
            }
          
        
      
        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
