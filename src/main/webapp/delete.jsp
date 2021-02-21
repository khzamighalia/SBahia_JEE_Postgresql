<%@page import="services.SArticleDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String id= request.getParameter("d");
     int no = Integer.parseInt(id);
     SArticleDAO dao= SArticleDAO.getInstance();
     dao.SupprimerArticle(no);
     //ServletContext context= getServletContext();
//RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet.do");
//rd.forward(request, response);
RequestDispatcher rd = request.getRequestDispatcher("/defaultServlet");
     request.setAttribute("msg","HI Welcome");
     rd.forward(request, response);
    
%>

