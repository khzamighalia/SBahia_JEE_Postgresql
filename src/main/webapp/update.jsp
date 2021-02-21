<%@page import="services.SArticleDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String id= request.getParameter("id");
     String titre= request.getParameter("titre");
     String prix= request.getParameter("prix");
     String vote= request.getParameter("vote");
     int no = Integer.parseInt(id);
     int price = Integer.parseInt(prix);
     int vt = Integer.parseInt(vote);
     SArticleDAO dao= SArticleDAO.getInstance();
     dao.ModifierArticle(no,"image modifiée",titre,price,vt);
     ServletContext context= getServletContext();
     RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
     rd.forward(request, response);
    
%>

