<%@page import="java.lang.String"%>
<%@page import="services.SUserDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String name= request.getParameter("name");
     String username= request.getParameter("username");
     String password= request.getParameter("password");
     SUserDAO dao= SUserDAO.getInstance();
     dao.Register(name,username,password);
     ServletContext context= getServletContext();
     RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
     rd.forward(request, response);
    
%>

