<%-- 
    Document   : mainpage.jsp
    Created on : Feb 6, 2015, 10:44:47 PM
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String x="";
   
   System.out.print(session.getAttribute("name"));
   if(session.getAttribute("name")==null){
      response.sendRedirect("index.jsp");
   }
     
//   System.out.print(x.isEmpty());

   else{
   x+=(String)session.getAttribute("name");
   System.out.print(x);
   }
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
