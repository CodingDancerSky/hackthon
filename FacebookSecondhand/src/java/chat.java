/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Conversation;
import com.restfb.types.FacebookType;
import com.restfb.types.Message;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JudeWang
 */
@WebServlet(urlPatterns = {"/chat"})
public class chat extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet chat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet chat at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public void sendMessage(NamedFacebookType sender,String messageToBeSent, NamedFacebookType receiver){
        //send message from sender to receiver
        Message newMessage=new Message();
        newMessage.setFrom(sender);
        newMessage.setMessage(messageToBeSent);
        newMessage.addTo(receiver);
        
        
        
    }
    public static void main(String[] Args){
        FacebookClient facebookClient = new DefaultFacebookClient("CAALwgEFpUT8BAIYQoDQKiIIKjdLZAFD9v137i27ZCWGlGq3uX0Xnh60h31vzZC7DhNylGM4nW0QsYITN4OIq45QoTYDwp7MhZCGgpk9nakrPdi0sZBDoZAcO7w3iZBq6uVZAgLA9MvWCObR5nVZBPwYJ7VavQrDDzEWQKa5UG8XwdG4aH1kD72nkrVXE1ZCWuRZCZBaD11Ieehvg49DguWaXxUj2");
        User user = facebookClient.fetchObject("100002712829463", com.restfb.types.User.class);
        //Page page = facebookClient.fetchObject("cocacola", Page.class);
       
        //System.out.println("User name: " + user.getName());
        /*System.out.println("mimic the conversasion");
        NamedFacebookType sender= new NamedFacebookType();
        sender.setId("100002712829463");
        NamedFacebookType receiver=new NamedFacebookType();
        receiver.setId("100003782148290");
        Conversation c=new Conversation();
        c.addParticipant(sender);
        c.addSender(sender);
        c.addParticipant(sender);
        Message newMessage=new Message();
        newMessage.setMessage("hi see you");
        c.addMessage(newMessage);*/
        //Conversation c=new Conversation();
        facebookClient.publish("100002712829463", FacebookType.class, Parameter.with("message", "RestFB test"));
        //Parameter.with("", user)
    //System.out.println(c.getMessageCount());
        //System.out.println(c.getUnreadCount());
        //System.out.println(c.getMessages());
        //System.out.println("Page likes: " + page.getLikes());
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

}
